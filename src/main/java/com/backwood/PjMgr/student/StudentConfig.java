package com.backwood.PjMgr.student;

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
  return  args -> {

      Student Ashwin = new Student(
              "Ashwin",
              LocalDate.of(1998, Month.DECEMBER,30),
              "apexashwin@gmail.com"
      );
     Student Rio =  new Student(
              "Rio Alyzah",
              LocalDate.of(2001, Month.OCTOBER,18),
              "rioalyzahprinces@gmail.com"
      );

      repository.saveAll(
              List.of(Ashwin,Rio)
      );
  };
    }
}
