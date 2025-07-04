package in.kunal.main.controller;

import in.kunal.main.model.Job;
import in.kunal.main.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public String postJob(@RequestBody Job job) {
        return jobService.postJob(job);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/search/type")
    public List<Job> getJobsByType(@RequestParam String jobType) {
        return jobService.getJobsByType(jobType);
    }

    @GetMapping("/search/title")
    public List<Job> getJobsByTitle(@RequestParam String keyword) {
        return jobService.getJobsByTitleKeyword(keyword);
    }

    @GetMapping("/search/employer")
    public List<Job> getJobsByEmployerKeyword(@RequestParam String keyword) {
        return jobService.getJobsByEmployerKeyword(keyword);
    }
}
