/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.CourseTeacherStudent.demo;

import com.example.CourseTeacherStudent.demo.entity.Course;
import com.example.CourseTeacherStudent.demo.entity.Teacher;
import com.example.CourseTeacherStudent.demo.repository.TeacherRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author davoudnasrabadi
 */

@SpringBootTest
public class TeacherRepositoryTest {
    
    @Autowired
    private TeacherRepository teacherRepository;
    
    @Test
    public void saveTeacher(){
        
        Course course1 = Course.builder()
                .title("DBA")
                .credit(13)
                .build();
          Course course2 = Course.builder()
                .title("JAVA")
                .credit(14)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("ali")
                .lastName("ahmadi")
                .courses(List.of(course1,course2))
                .build();
        
        teacherRepository.save(teacher);
    }
    
}
