package in.kunal.main.controller;

import in.kunal.main.model.Application;
import in.kunal.main.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public String applyForJob(@RequestParam Long studentId, @RequestParam Long jobId) {
        return applicationService.applyForJob(studentId, jobId);
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }
    
}
