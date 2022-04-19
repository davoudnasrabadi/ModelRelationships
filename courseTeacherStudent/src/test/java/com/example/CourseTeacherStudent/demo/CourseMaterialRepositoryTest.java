/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.CourseTeacherStudent.demo;
import com.example.CourseTeacherStudent.demo.entity.Course;
import com.example.CourseTeacherStudent.demo.entity.CourseMaterial;
import com.example.CourseTeacherStudent.demo.repository.CourseMaterialRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author davoudnasrabadi
 */

@SpringBootTest
public class CourseMaterialRepositoryTest {
     @Autowired
     private CourseMaterialRepository repository;
     
     @Test
     public void saveCourseMaterial(){
         
         Course course= Course.builder()
                 .title(".net")
                 .credit(6)
                 .build();
         CourseMaterial courseMaterial =
                 CourseMaterial.builder()
                 .url("www.netnet.com")
                 .course(course)
                 .build();
         repository.save(courseMaterial);
     }
     
     @Test
     public void printAllCourseMaterials(){
         List<CourseMaterial> courseMaterials = 
                 repository.findAll();
         System.out.print("CourseMaterials = "+courseMaterials);
     }
     
}
