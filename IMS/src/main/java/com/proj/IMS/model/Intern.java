package com.proj.IMS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
//@ToString
@Table(name="Intern_Table")
public class Intern {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    private String email;
    @Column(name="contact_no")
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name="manager_id")
    @JsonIgnore
    private Manager manager;

//    public Intern(String name, String email, String contactNumber, Manager manager) {
//        this.name = name;
//        this.email = email;
//        this.contactNumber = contactNumber;
//        this.manager = manager;
//    }
//    public Intern(int id, String name, String email, String contactNumber, Manager manager) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.contactNumber = contactNumber;
//        this.manager = manager;
//    }
//
//    public Intern() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getContactNumber() {
//        return contactNumber;
//    }
//
//    public void setContactNumber(String contactNumber) {
//        this.contactNumber = contactNumber;
//    }
//
//    public Manager getManager() {
//        return manager;
//    }
//
//    public void setManager(Manager manager) {
//        this.manager = manager;
//    }

    @Override
    public String toString() {
        return "Intern{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
//                ", manager=" + manager.toString() +
                '}';
    }
}
