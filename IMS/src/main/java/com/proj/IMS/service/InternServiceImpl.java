package com.proj.IMS.service;

import com.proj.IMS.model.Intern;
import com.proj.IMS.repository.InternRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class InternServiceImpl implements InternService{
    HashMap<Integer, Intern> HmCache = new HashMap<>();
    Logger logger = LoggerFactory.getLogger(InternServiceImpl.class);
    @Autowired
    private InternRepository internRepository;

    public Intern findInternById(int id) {

        Intern cacheVal = HmCache.get(id);
        //cache hit
        if(cacheVal !=null){
            logger.info("Data retrieved from cache");
            return cacheVal;
        }
        else {//cache miss
            //from db
            Optional<Intern> intern = internRepository.findById(id);
            logger.info("Data retrieved from db");
            if(intern.isPresent()){
                HmCache.put(id,intern.get());
                logger.info("Data saved to cache", intern);
                return intern.get();
            }
            return null;
        }
    }


    @Override
    public List<Intern> getAllInterns() {
        List<Intern> all = internRepository.findAll();
        logger.info("getAllInterns is called " + all);
        return all;
    }


    public List<Intern> getInternsByManagerId(int id){
        return internRepository.getInternsByManagerId(id);
    }
}
