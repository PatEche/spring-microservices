package com.microservice.course.client;

/* Aqui vamos a configurar el cliente de nuestra aplicacion  */

import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8080/api/student")//Habilitamos el cliente e indicamos el nombre del microservicio al cual vamos a hacer la consulta o conectar.
public interface StudentClient {

    @GetMapping("/search-by-course/{idCourse}")
    List<StudentDTO> findAllStudentByCourse(@PathVariable Long idCourse);



}
