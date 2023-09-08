package com.proj.IMS.controller;

import com.proj.IMS.model.Manager;
import com.proj.IMS.repository.ManagerRepository;
import com.proj.IMS.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping
public class ManagerController {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ManagerService managerService;


    @PostMapping("/managers")
    public Manager addNewManager(@RequestBody Manager newManager) {
        return managerRepository.save(newManager);

    }

    @GetMapping("/managers/{id}")
    public Optional<Manager> findManagerById(@PathVariable int id) {
        log.info("API call hit : /find/{}", id);
        return managerService.findManagerById(id);
    }


    @GetMapping("/managers")
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }
}