package com.paf.exercise;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.paf.exercise"})
public class ExerciseApplicationV2 {
    public static void main(String[] args) {
        SpringApplication.run(ExerciseApplicationV2.class, args);
    }
}
