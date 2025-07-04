package in.kunal.main.controller;

import in.kunal.main.model.Student;
import in.kunal.main.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // POST - Register Student
    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    // GET - Fetch All Students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // GET - Search by Skill
    @GetMapping("/search")
    public List<Student> searchBySkill(@RequestParam String skill) {
        return studentService.searchBySkill(skill);
    }

    // GET - Get Student by Email (Login-like functionality)
    @GetMapping("/email")
    public Student getStudentByEmail(@RequestParam String email) {
        return studentService.getStudentByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found with email: " + email));
    }
}
