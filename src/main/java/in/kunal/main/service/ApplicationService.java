package in.kunal.main.service;

import in.kunal.main.model.Application;
import in.kunal.main.model.Job;
import in.kunal.main.model.Student;
import in.kunal.main.repository.ApplicationRepository;
import in.kunal.main.repository.JobRepository;
import in.kunal.main.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private JobRepository jobRepo;

    public String applyForJob(Long studentId, Long jobId) {

        Optional<Student> studentOpt = studentRepo.findById(studentId);
        Optional<Job> jobOpt = jobRepo.findById(jobId);

        if (studentOpt.isEmpty() || jobOpt.isEmpty()) {
            return "Invalid Student or Job ID!";
        }

        Student student = studentOpt.get();
        Job job = jobOpt.get();

        Application application = new Application();
        application.setStudent(student);
        application.setJob(job);

        applicationRepo.save(application);

        return student.getName() + " successfully applied for " + job.getTitle();
    }

    public List<Application> getAllApplications() {
        return applicationRepo.findAll();
    }
    
}
