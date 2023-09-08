package com.proj.IMS.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Manager_Table")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int managerId;
    private String name;
    private String email;
    @Column(name="contact_no")
    private String contactNumber;

    @Autowired
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Intern> internsUnderManager = new ArrayList<>();

    public Manager(int managerId, String name, String email, String contactNumber, List<Intern> internsUnderManager) {
        this.managerId = managerId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.internsUnderManager = internsUnderManager;

    }

    public Manager() {
    }

    public int getId() {
        return managerId;
    }

    public void setId(int managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Intern> getInternsUnderManager() {
        return internsUnderManager;
    }

    public void setInternsUnderManager(List<Intern> internsUnderManager) {
        this.internsUnderManager = internsUnderManager;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manager_id=" + managerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", intern=" + internsUnderManager +
                '}';
    }
}
