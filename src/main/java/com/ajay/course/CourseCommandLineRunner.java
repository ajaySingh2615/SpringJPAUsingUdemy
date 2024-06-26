package com.ajay.course;

import com.ajay.course.jdbc.CourseJdbcRepository;
import com.ajay.course.jpa.CourseJpaRepository;
import com.ajay.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1L, "Learn Docker", "Ajay"));
        repository.save(new Course(2L, "Learn Git", "Ajay"));
        repository.save(new Course(3L, "Learn Devops", "Ajay"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("Ajay"));
        System.out.println(repository.findByName("Learn Git"));

    }


}
