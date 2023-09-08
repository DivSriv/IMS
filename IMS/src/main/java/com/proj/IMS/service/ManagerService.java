package com.proj.IMS.service;

import com.proj.IMS.model.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {

    Optional<Manager> findManagerById(int id);

    List<Manager> getAllManagers();


//    List<Intern> getInterns();

//    void deleteInternById(int id);
}
