package com.abhiproject.studentmanagement.controller;

import com.abhiproject.studentmanagement.model.Course;
import com.abhiproject.studentmanagement.model.Laptop;
import com.abhiproject.studentmanagement.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping("/laptop/{studentId}")
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop, @PathVariable Integer studentId)
    {
        Laptop laptop1=this.laptopService.createLaptop(laptop,studentId);
        return  new ResponseEntity<>(laptop1, HttpStatus.CREATED);
    }

    @PutMapping("/laptop/{id}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable Integer id, @RequestBody Laptop laptop){
        Laptop laptop1=this.laptopService.updateLaptop(id,laptop);
        return new ResponseEntity<>(laptop1,HttpStatus.OK);
    }

    @GetMapping("/laptop/{id}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable Integer id)
    {
        Laptop laptop=this.laptopService.getLaptopById(id);
        return new ResponseEntity<>(laptop,HttpStatus.OK);
    }

    @GetMapping("/laptops")
    public ResponseEntity<List<Laptop>> getAllLaptops()
    {
        List<Laptop> laptops=this.laptopService.getAllLaptops();
        return new ResponseEntity<>(laptops,HttpStatus.OK);
    }

    @DeleteMapping("/laptop/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id)
    {
        this.laptopService.deleteLaptop(id);
        return ResponseEntity.ok(Map.of("message","laptop details deleted successfully"));
    }
}
