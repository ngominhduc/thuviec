package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private  final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        Optional<Student> studentByName = studentRepository.findStudentByName(student.getName());
        /*if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }*/
        if (studentByName.isPresent()){
            throw new IllegalStateException("name taken");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentID) {
        boolean exists = studentRepository.existsById(studentID);
        if(!exists){
            throw new IllegalStateException("student with id " + studentID + " do not exists");
        }
        studentRepository.deleteById(studentID);

    }

    @Transactional
    public void updateStudent(Long studentID, String name, String email) {
        Student student = studentRepository.findById(studentID).orElseThrow(
                () -> new IllegalStateException(
                        "student with id " + studentID + " do not exists"
                )
        );

        if(name != null && !name.equals(student.getName())){
            student.setName(name);
        }

        student.setEmail(email);
    }
}
