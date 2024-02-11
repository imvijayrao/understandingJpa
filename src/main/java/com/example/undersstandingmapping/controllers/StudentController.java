package com.example.undersstandingmapping.controllers;

import com.example.undersstandingmapping.models.Student;
import com.example.undersstandingmapping.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// to mark this class as a controller.
// and return the output as json directly
@RestController
public class StudentController {

    // not a good idea to use repositories inside controllers

    // automatically wire an instance of repo to this class -> Autowired
    @Autowired
    private StudentRepository studentRepository;

    // I'  doing something

    // actual url to which you're serving the response
    @RequestMapping(method = RequestMethod.GET, value = "/students")
    public ModelAndView gethomepage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homepage");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getStudents")
    public List<Student> getstudents(){
        return studentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create-student")
    public ModelAndView getStudentform(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete-student")
    public ModelAndView deleteStudent(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("del_student");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ModelAndView createStudent(Long id, String name, String psp){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setPsp(psp);
        studentRepository.save(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public ModelAndView deleteStudent(Long id, String name, String psp){
        Student student = new Student();
        student.setId(id);
        studentRepository.delete(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }
    // Transactions 1 and 2 completely.
}