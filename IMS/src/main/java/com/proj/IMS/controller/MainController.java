package com.proj.IMS.controller;

import com.proj.IMS.exception.InternNotFoundException;
import com.proj.IMS.model.Intern;
import com.proj.IMS.model.Manager;
import com.proj.IMS.repository.InternRepository;
import com.proj.IMS.repository.ManagerRepository;
import com.proj.IMS.service.InternService;
import com.proj.IMS.service.PatchUsingReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping
public class MainController {
    @Autowired
    private InternRepository internRepository;

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private InternService internService;

    @Autowired
    PatchUsingReflection patcher;

    @PostMapping("/interns")
    public Intern addNewIntern(@RequestBody Map<String,String> requestBody){
        System.out.println(requestBody.values());
//        requestBody=requestBody==null?new HashMap<>():requestBody;
        Manager assignedManager=requestBody.containsKey("manager")
                ?managerRepository.findById(Integer.parseInt(requestBody.get("manager"))).orElse(null) :null;
//        System.out.println(assignedManager);

        Intern buildIntern= Intern.builder()

                .name(requestBody.get("name"))
                .email(requestBody.get("email"))
                .contactNumber(requestBody.get("contactNumber"))
                .manager(assignedManager)
                .build();
        Intern intern = internRepository.save(buildIntern);
//        System.out.println(intern);
        return intern;

    }
    @GetMapping("/interns/{id}")
    public Intern findInternById(@PathVariable int id){
        System.out.println("Request for /findUserById had id as " + id);
        return internService.findInternById(id);
    }


    @GetMapping("/interns")
    public List<Intern> getAllInterns()
    {
        List<Intern> allInterns = internService.getAllInterns();
        System.out.print(allInterns);
        return allInterns;
    }


    @GetMapping("/managers/{id}/interns")
    public List<Intern> getInternsByManagerId(@PathVariable int id){
        return internRepository.getInternsByManagerId(id);
    }

    @PatchMapping("/interns")
    public ResponseEntity<Intern> patchIntern(@RequestBody Intern modifiedIntern) throws InternNotFoundException {
//        System.out.println(internRepository.findById(modifiedIntern.getId())
//                .orElseThrow(() -> new InternNotFoundException(modifiedIntern.getId())));

        Intern currentIntern=internRepository.findById(modifiedIntern.getId())
                .orElseThrow(() -> new InternNotFoundException("" + modifiedIntern.getId()));
        try {
            patcher.internPatcher(currentIntern, modifiedIntern);
//            System.out.println(currentIntern+" cur "+ modifiedIntern + " mod /n");
            internRepository.save(currentIntern);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(currentIntern);
    }

    @DeleteMapping("/interns/{id}")
    public String deleteIntern(@PathVariable int id){
        internRepository.deleteById(id);
        return "Deleted intern with id "+id;
    }

}
