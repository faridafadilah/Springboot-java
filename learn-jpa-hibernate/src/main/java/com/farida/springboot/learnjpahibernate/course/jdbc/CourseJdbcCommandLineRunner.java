// package com.farida.springboot.learnjpahibernate.course.jdbc;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.farida.springboot.learnjpahibernate.course.Course;

// @Component
// public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//   @Autowired
//   private CourseJdbcRepository repository;

//   @Override
//   public void run(String... args) throws Exception {
//     // TODO Auto-generated method stub
//     repository.insert(new Course(1, "Learn AWS Now", "farida"));
//     repository.insert(new Course(2, "Learn Javascript", "hisyam"));
//     repository.insert(new Course(3, "Learn Python", "hani"));

//     repository.delete(1);
//     System.out.println(repository.findById(2));
//   }
  
// }
