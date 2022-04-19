/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.CourseTeacherStudent.demo.repository;

import com.example.CourseTeacherStudent.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davoudnasrabadi
 */

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    
}
