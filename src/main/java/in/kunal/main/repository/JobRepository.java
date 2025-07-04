package in.kunal.main.repository;

import in.kunal.main.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    // Find jobs by Job Type (Full-Time, Part-Time)
    List<Job> findByJobType(String jobType);

    // Find jobs where title contains a keyword (case-insensitive)
    List<Job> findByTitleContainingIgnoreCase(String keyword);

    // Find jobs by Employer's Company Name
    List<Job> findByEmployer_CompanyNameContainingIgnoreCase(String keyword);

}
