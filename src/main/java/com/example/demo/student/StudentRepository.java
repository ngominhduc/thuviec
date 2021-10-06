package com.example.demo.student;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.name = ?1")
    Optional<Student> findStudentByName(String name);

    @Query("select s from Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
