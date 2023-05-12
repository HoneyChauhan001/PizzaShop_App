package com.example.JPAbasicsmay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add-student")
    public String addStudent(@RequestBody Student student,@RequestParam Department department){
        studentService.addStudent(student,department);
        return "Student Added Successfully";
    }

    @GetMapping("/get-student-by-id/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/get-all-students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/delete-student-by-id/{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteStudentById(id);
        return "Deleted Successfully";
    }

    @DeleteMapping("/delete-all-students")
    public String deleteAllStudent(){
        studentService.deleteAllStudents();
        return "All Students Deleted Successfully";
    }

    @PutMapping("/update-name-by-id/{id}")
    public Student updateNameById(@PathVariable int id, @RequestParam String name){
        Student student = studentService.updateNameByStudentId(id,name);
        return student;
    }

    @GetMapping("/get-by-age")
    public List<String> getByAge(@RequestParam int age){
        return studentService.getByAge(age);
    }

    @GetMapping("/get-by-age-marks")
    public List<String> getByAgeAndMarks(@RequestParam("age") int age,@RequestParam("marks") int marks){
        return studentService.getByAgeAndMarks(age,marks);
    }

    @GetMapping("/get-by-age-greater-than")
    public List<String> getByAgeGreaterThan(@RequestParam("age") int age){
        return studentService.getByAgeGreaterThan(age);
    }

}
