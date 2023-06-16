package kz.birlab.spring.first_project.controller;

import kz.birlab.spring.first_project.DB.DBManager;
import kz.birlab.spring.first_project.DB.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.ArrayList;

@Controller
public class Home_controller {
    @GetMapping(value = "/")
    public String mainpage(Model model){
        ArrayList<Student> students= DBManager.getStudents();
        model.addAttribute("students",students);
        return "main";
    }
    @GetMapping(value = "/add-student")
    public String addstudent(){
        return "add-student";
    }
    @PostMapping(value ="/add-student")
    public String addstudentPost(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("exam") int exam
    ){
        if(name.length()>0&&surname.length()>0&&exam>=0&&exam<=100){
            String mark="";
            if(exam>=90&&exam<=100){
                mark="A";
            }else if(exam>=75&&exam<=89){
                mark="B";
            }else if(exam>=60&&exam<=74){
                mark="C";
            }else if(exam>=50&&exam<=59){
                mark="D";
            }else {
                mark="F";
            }
            Student student=new Student(0L,name,surname,exam,mark);
            DBManager.addStudent(student);
        }
        return "redirect:/";
    }

}
