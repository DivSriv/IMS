package com.proj.IMS.repository;

import com.proj.IMS.model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InternRepository extends JpaRepository<Intern, Integer> {
    @Query("Select u FROM Intern u WHERE manager_id = ?1")
    List<Intern> getInternsByManagerId(int id);
}
