package com.abhiproject.studentmanagement.service.impl;

import com.abhiproject.studentmanagement.exception.ResourceNotFoundException;
import com.abhiproject.studentmanagement.model.Laptop;
import com.abhiproject.studentmanagement.model.Student;
import com.abhiproject.studentmanagement.repository.LaptopRepo;
import com.abhiproject.studentmanagement.repository.StudentRepo;
import com.abhiproject.studentmanagement.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    private LaptopRepo laptopRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Laptop createLaptop(Laptop laptop, Integer studentId) {
        Student student=this.studentRepo.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("student not found with the id you mentioned"));
        laptop.setStudent(student);
        Laptop laptop1=this.laptopRepo.save(laptop);
        return laptop1;
    }

    @Override
    public Laptop updateLaptop(Integer id, Laptop laptop) {
        Laptop laptop1=this.laptopRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("student not found with the id you mentioned"));
        laptop1.setBrand(laptop.getBrand());
        laptop1.setModel(laptop.getModel());
        laptop1.setPrice(laptop.getPrice());
        Laptop updatedLaptop=this.laptopRepo.save(laptop1);
        return updatedLaptop;
    }

    @Override
    public Laptop getLaptopById(Integer id) {
        Laptop laptop=this.laptopRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("student not found with the id you mentioned"));
        return laptop;
    }

    @Override
    public List<Laptop> getAllLaptops() {
        List<Laptop> laptops=this.laptopRepo.findAll();
        return laptops;
    }

    @Override
    public void deleteLaptop(Integer id) {
        Laptop laptop=this.laptopRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("student not found with the id you mentioned"));
        this.laptopRepo.delete(laptop);
    }
}
