package in.kunal.main.controller;

import in.kunal.main.model.Employer;
import in.kunal.main.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @PostMapping
    public Employer registerEmployer(@RequestBody Employer employer) {
        return employerService.registerEmployer(employer);
    }

    @GetMapping
    public List<Employer> getAllEmployers() {
        return employerService.getAllEmployers();
    }

    @PutMapping("/verify/{employerId}")
    public String verifyEmployer(@PathVariable Long employerId) {
        return employerService.verifyEmployer(employerId);
    }
}
