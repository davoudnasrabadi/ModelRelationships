/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.CourseTeacherStudent.demo;
import com.example.CourseTeacherStudent.demo.entity.Student;
import com.example.CourseTeacherStudent.demo.entity.Guardian;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.CourseTeacherStudent.demo.repository.StudentRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
/**
 *
 * @author davoudnasrabadi
 */

@SpringBootTest

public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("davoud@gmail.com")
                .firstName("davoud")
                .lastName("Nasrabadi")
                .build();
                //.guardianName("dnafae")
                //.guardianEmail("dnafae@gmail.com")
               // .guardianMobile("98765432123").build();
        studentRepository.save(student);
    }
    
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("danial")
                .email("daniali@gmail.com")
                .mobile("09994383339")
                .build();
        
        Student student = Student.builder()
                .firstName("danialo")
                .lastName("ahmadi")
                .emailId("dan@gmail.com")
                .guardian(guardian)
                .build();
        
        studentRepository.save(student);
        
    }
    
    
    
    @Test
    public void printAll(){
        List<Student> students = studentRepository.findAll();
        System.out.print("All students: "+students);
    }
    
    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("davoud");
          System.out.print("All students: "+students);
    }
    
     @Test
    public void printStudentByFirstContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("d");
          System.out.print("All students: "+students);
    }
    
     @Test
    public void printStudentGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("rezax");
          System.out.print("All students: "+students);
    }
    
    @Test
    public void printStudentByEmail(){
        Student student = studentRepository.getStudentByEmailAddress("dan@gmail.com");
          System.out.print("All students: "+student);
    }
      @Test
    public void printStudentNameByEmail(){
        String name = studentRepository.getStudentFirstNameByEmailAddress("reza@gmail.com");
          System.out.print("All students: "+name);
    }
    
    @Test
    public void printAllByNative(){
        List<Student> students= studentRepository.getAllStudentsByNative();
          System.out.print("All students: "+students);
    }
    
     @Test
     public void printGetByLastNameNative(){
        List<Student> students= studentRepository.getByLastNameNative("ahmadi");
          System.out.print("All students: "+students);
    }
     
     @Test
     public void printGetStudentByEmailIdNamedParams(){
        Student student= studentRepository.getStudentByEmailAddressNativeNamedParam("dan@gmail.com");
          System.out.print("All students: "+student);
    }
     
    @Test void updateStudentNameByEmail(){
        int a = studentRepository.updateStudentNameByEmailId("davood", "davoud@gmail.com");
    }
}
//