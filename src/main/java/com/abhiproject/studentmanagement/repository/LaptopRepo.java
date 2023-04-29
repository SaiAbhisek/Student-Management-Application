package com.abhiproject.studentmanagement.repository;

import com.abhiproject.studentmanagement.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop,Integer> {
}
