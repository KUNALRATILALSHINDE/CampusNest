package in.kunal.main.service;

import in.kunal.main.model.Employer;
import in.kunal.main.model.Job;
import in.kunal.main.repository.EmployerRepository;
import in.kunal.main.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private EmployerRepository employerRepo;

    public String postJob(Job job) {
        Employer employer = job.getEmployer();

        if (employer == null || !employerRepo.existsById(employer.getId())) {
            return "Invalid Employer!";
        }

        Employer dbEmployer = employerRepo.findById(employer.getId()).get();

        if (!dbEmployer.isVerified()) {
            return "Employer is not verified. Cannot post job.";
        }

        job.setEmployer(dbEmployer);
        jobRepo.save(job);

        return "Job Posted Successfully by: " + dbEmployer.getCompanyName();
    }

    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public List<Job> getJobsByType(String jobType) {
        return jobRepo.findByJobType(jobType);
    }

    public List<Job> getJobsByTitleKeyword(String keyword) {
        return jobRepo.findByTitleContainingIgnoreCase(keyword);
    }

    public List<Job> getJobsByEmployerKeyword(String keyword) {
        return jobRepo.findByEmployer_CompanyNameContainingIgnoreCase(keyword);
    }
}
