package com.proj.IMS.service;

import com.proj.IMS.model.Intern;

import java.util.List;

public interface InternService {

    Intern findInternById(int id);

    List<Intern> getAllInterns();

//    void deleteInternById(int id);
}
