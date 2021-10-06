package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student ngo = new Student(
                    1L,
                    "ngo",
                    30,
                    LocalDate.of(2021, Month.JULY, 5),
                    "ngo@gmail.com"
            );

            Student minh = new Student(
                    2L,
                    "minh",
                    30,
                    LocalDate.of(2021, Month.JULY, 5),
                    "minh@gmail.com"
            );

            Student duc = new Student(
                    3L,
                    "duc",
                    30,
                    LocalDate.of(2021, Month.JULY, 5),
                    "duc@gmail.com"
            );

            repository.saveAll(
                    List.of(ngo, minh, duc)
            );
        };
    }
}
