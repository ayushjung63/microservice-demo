package com.ayush.accountservice.proxy;


import com.ayush.accountservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentProxyService {
    private final String STUDENT_SERVICE="http://STUDENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod ="getFallBackStudentById")
    public Student getStudentById(int studentId){
        Student student = restTemplate.getForObject(STUDENT_SERVICE+"/student/" +studentId, Student.class);
        return student;
    }

    public Student getFallBackStudentById(int studentId){
        return new Student(0,"Student Service not available","","");
    }
}
