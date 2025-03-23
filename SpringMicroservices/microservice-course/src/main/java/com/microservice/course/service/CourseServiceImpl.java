package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient; //inyectamos el client para poder acceder al metodo

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();//Hacemos un casteo ya que el CRUDREPOSITORY devuelve un Iterable
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();

    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {

        /** Busca en la base de datos el curso con el ID proporcionado. Si no encuentra el curso,
        devuelve un objeto Course vacío en lugar de null. Esto evita excepciones por NullPointerException. */
        Course course = courseRepository.findById(idCourse).orElse(new Course());

        //Obtener los estudiantes
        List<StudentDTO>studentDTOList = studentClient.findAllStudentByCourse(idCourse);

          return StudentByCourseResponse.builder()//Patron builder para crear un objeto StudentByCourseResponse
                  .courseName(course.getName())
                  .teacher(course.getTeacher())
                  .studentDTOList(studentDTOList)
                  .build();

        /** Este metodo devuelve una respuesta personalizada,
         agrupando atributos del curso y agrupando un listado que viene
         desde otro microservicio, consultandolo atravez de nuestro cliente "feing" **/

    }
}

