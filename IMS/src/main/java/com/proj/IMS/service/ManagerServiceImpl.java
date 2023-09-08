package com.proj.IMS.service;

import com.proj.IMS.cache.LRUCache;
import com.proj.IMS.model.Manager;
import com.proj.IMS.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService{
    LRUCache<Integer, Manager> lruCache = new LRUCache<>(3);

    @Autowired
    private ManagerRepository managerRepository;
    @Override
    public Optional<Manager> findManagerById(int id) {
        Manager cache = lruCache.get(id);
        //cache hit
        if(cache !=null){
            return Optional.of(cache);
        }
        else {//cache miss
            //from db
            Optional<Manager> manager = Optional.ofNullable(managerRepository.findById(id).get());
            if(manager.isPresent()){
                lruCache.put(id,manager.get());
                return Optional.of(manager.get());
            }
            return null;
        }
    }

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }




}
