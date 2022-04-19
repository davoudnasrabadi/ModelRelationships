/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.CourseTeacherStudent.demo;
import com.example.CourseTeacherStudent.demo.entity.Course;
import com.example.CourseTeacherStudent.demo.entity.Student;
import com.example.CourseTeacherStudent.demo.entity.Teacher;
import com.example.CourseTeacherStudent.demo.repository.CourseRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
/**
 *
 * @author davoudnasrabadi
 */
@SpringBootTest
public class CourseRepositoryTest {
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.print("courses = "+courses);
    }
    
    
    @Test()
    public void saveCourseWithTeacherObject(){
        Teacher teacher  = Teacher
                .builder()
                .firstName("hamid")
                .lastName("akbari")
                .build();
        Course course = Course
                .builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();
        
        courseRepository.save(course);
                
    }
    
    @Test()
    public void findAllPagination(){
        Pageable firstPageWithThreeRec =  PageRequest.of(0, 3);
        Pageable secondPageWith2Rec = PageRequest.of(1, 2);
        
        List<Course> courses = courseRepository.findAll(firstPageWithThreeRec).getContent();
        System.out.print(courses);
        Long totalElements = courseRepository.findAll(firstPageWithThreeRec).getTotalElements();
    }
    
    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0, 2,Sort.by("title"));
        Pageable sortByCredit = PageRequest.of(0, 2,Sort.by("title").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2,Sort.by("title").descending().and(Sort.by("credit")));
         List<Course> courses = courseRepository.findAll(sortByCredit).getContent();
         
        System.out.print(courses);
    }
    
    @Test
    public void printfindByTitle(){
        Pageable firstPageTenRecords =PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();
    }
    
    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher= Teacher.builder()
                        .firstName("Omid")
                        .lastName("SAN")
                        .build();
        
        Student student = Student.builder()
                        .firstName("Pedram")
                         .lastName("hrs")
                        .emailId("ssd@gmail.com")
                         .build();
        Course course =  Course.builder()
                       .title("Csharp")
                       .credit(33)
                       .teacher(teacher)
                       .build();
        course.addStudent(student);
                       
        courseRepository.save(course);
                
    }
}
