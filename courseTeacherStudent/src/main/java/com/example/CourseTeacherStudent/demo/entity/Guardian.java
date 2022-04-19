/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.CourseTeacherStudent.demo.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author davoudnasrabadi
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
    @AttributeOverride(
            name="name",
            column=@Column(name="guardian_name")
    ),
     @AttributeOverride(
            name="email",
            column=@Column(name="guardian_email")
    ),
     @AttributeOverride(
            name="mobile",
            column=@Column(name="guardian_mobile")
    )
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
