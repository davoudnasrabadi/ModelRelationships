/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.CourseTeacherStudent.demo.repository;

import com.example.CourseTeacherStudent.demo.entity.Student;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davoudnasrabadi
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    
    public List<Student> findByFirstName (String firstName);
    
    
    public List<Student> findByFirstNameContaining(String w);
    
     public List<Student> findByLastNameNotNull();
     
      public List<Student> findByGuardianName(String name);
      
      public Student findByFirstNameAndLastName(String firstName,String lastName);
      
      @Query("select s from Student s  where s.emailId=?1")
      public Student getStudentByEmailAddress(String EmailId);
      
      @Query("select s.firstName from Student s  where s.emailId=?1")
      public String getStudentFirstNameByEmailAddress(String EmailId);
      
      @Query(
       value="select * from tbl_student",
       nativeQuery = true       
      )
      public List<Student> getAllStudentsByNative();
          
       @Query(
       value="select * from tbl_student s where s.last_name=?1",
       nativeQuery = true       
      )
       public List<Student> getByLastNameNative(String lastName);
          
       @Query(
       value="select * from tbl_student s where s.last_name= :emailId",
       nativeQuery = true       
      )
       public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
       
       
       @Modifying
       @Transactional
       @Query(
         value="update tbl_student set first_name=?1 where email_address=?2",
         nativeQuery=true
       )
       int updateStudentNameByEmailId(String firstName,String emailId);
}
 