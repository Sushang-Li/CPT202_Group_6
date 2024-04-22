package com.group6.booking4sportcentre;

import com.group6.booking4sportcentre.controller.StudentController;
import com.group6.booking4sportcentre.model.StudentInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author Yixuan.Wang
 * @create 2024-04-22 16:20
 */

@SpringBootTest
public class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    //Test findAll method
    @Test
    public void testFindAll(){
        List<StudentInfo> studentInfoList = studentController.findAll();
        // Assert that the result is not empty
        assertNotNull(studentInfoList);
    }

    //Test findById method
    @Test
    public void testFindById(){
        List<StudentInfo> studentInfoList = studentController.findById(1);
        // Assert that the result is not empty
        assertNotNull(studentInfoList);
    }

    //Test addStudent method
    @Test
    public void testAddStudent(){
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(2145058);
        studentInfo.setUsername("2145058");
        studentInfo.setPosition("Student");
        studentInfo.setMobilePhone("13728472843");
        studentInfo.setGender("male");
        studentInfo.setSchoolEmail("2145058@email.com");
        studentInfo.setEmergencyContactNumber("13728472843");
        // Assert that the result is not empty
        assertNotNull(studentController.addStudent(studentInfo));
    }

    //Test updateStudent method
    @Test
    public void testUpdateStudent(){
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(2145058);
        studentInfo.setUsername("2145058");
        studentInfo.setPosition("Teacher");
        studentInfo.setMobilePhone("13728472843");
        studentInfo.setGender("male");
        studentInfo.setSchoolEmail("2145058@email.com");
        studentInfo.setEmergencyContactNumber("13728472843");
        // Assert that the result is not empty
        assertNotNull(studentController.updateStudent(studentInfo));
    }

    //Test deleteStudent method
    @Test
    public void testDeleteStudent(){
        // Assert that the result is not empty
        assertNotNull(studentController.deleteStudent(2105058));
    }

}
