package com.example.JPAbasicsmay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student, Department department) {
        LibraryCard card = new LibraryCard();
        card.setDepartment(department);
        card.setStudent(student);

        student.setLibraryCard(card);
        studentRepository.save(student);
    }

    public Student getStudentById(int id) {

        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    public Student updateNameByStudentId(int id, String name) {
        Student student = studentRepository.findById(id).get();
        student.setName(name);
        studentRepository.save(student);
        return student;
    }


    public List<String> getByAge(int age) {
        List<Student> students = studentRepository.findByAge(age);
        List<String> names = new ArrayList<>();

        for(Student student : students){
            names.add(student.getName());
        }
        return names;
    }

    public List<String> getByAgeAndMarks(int age, int marks) {
        List<Student> students = studentRepository.findByAgeAndMarks(age,marks);
        List<String> names = new ArrayList<>();

        for(Student student : students){
            names.add(student.getName());
        }
        return names;
    }

    public List<String> getByAgeGreaterThan(int age) {
        List<Student> students = studentRepository.findByAgeGreaterThan(age);
        List<String> names = new ArrayList<>();

        for(Student student : students){
            names.add(student.getName());
        }
        return names;
    }
}
