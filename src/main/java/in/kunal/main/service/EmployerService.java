package in.kunal.main.service;

import in.kunal.main.model.Employer;
import in.kunal.main.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepo;

    public Employer registerEmployer(Employer employer) {
        // Basic email check - can extend validation here
        if (employer.getEmail() == null || employer.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is required!");
        }

        employer.setVerified(false);  // New employers default unverified
        return employerRepo.save(employer);
    }

    public List<Employer> getAllEmployers() {
        return employerRepo.findAll();
    }

    public String verifyEmployer(Long employerId) {
        Optional<Employer> employerOpt = employerRepo.findById(employerId);

        if (employerOpt.isEmpty()) {
            return "Employer not found!";
        }

        Employer employer = employerOpt.get();
        employer.setVerified(true);
        employerRepo.save(employer);

        return "Employer verified successfully!";
    }
}
