package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Course course) {
        try {
            iCourseService.save(course);
        } catch (Exception e) {
            e.getMessage();
        }

    }


    @GetMapping("/all")
    public ResponseEntity<?> findAllCourse() {
        return ResponseEntity.ok(iCourseService.findAll());

    }


    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(iCourseService.findById(id));


    }

    @GetMapping("/search-student/{idCourse}")
    public ResponseEntity<?>findStudenstByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(iCourseService.findStudentsByIdCourse(idCourse));
    }




}
