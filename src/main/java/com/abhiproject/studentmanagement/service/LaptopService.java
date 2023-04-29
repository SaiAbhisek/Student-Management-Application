package com.abhiproject.studentmanagement.service;

import com.abhiproject.studentmanagement.model.Laptop;

import java.util.List;

public interface LaptopService {
    Laptop createLaptop(Laptop laptop,Integer studentId);

    Laptop updateLaptop(Integer id,Laptop laptop);
    Laptop getLaptopById(Integer id);
    List<Laptop> getAllLaptops();
    void deleteLaptop(Integer id);
}
