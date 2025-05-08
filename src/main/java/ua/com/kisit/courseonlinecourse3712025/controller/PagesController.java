package ua.com.kisit.courseonlinecourse3712025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/index")
    public String getIndexPage(Model model){
        return "index";
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model){
        return "admin_page";
    }

    @GetMapping("/teacher")
    public String getTeacherPage(Model model){
        return "teacher_page";
    }

    @GetMapping("/student")
    public String getStudentPage(Model model){
        return "student_page";
    }

    @GetMapping("/error403")
    public String getErrorPage(Model model){
        return "error403";
    }
}
