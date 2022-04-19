/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.CourseTeacherStudent.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CourseTeacherStudent.demo.entity.Course;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
 
/**
 *
 * @author davoudnasrabadi
 */

@Repository 
public interface CourseRepository extends JpaRepository<Course,Long> {
    Page<Course> findByTitleContaining(String title,Pageable pageRequest);
}
