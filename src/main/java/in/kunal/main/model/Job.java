package in.kunal.main.model;

import jakarta.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String jobType; // Internship or Full-Time

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    public Job() {}

    public Job(Long id, String title, String description, String jobType, Employer employer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.jobType = jobType;
        this.employer = employer;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getJobType() { return jobType; }
    public void setJobType(String jobType) { this.jobType = jobType; }

    public Employer getEmployer() { return employer; }
    public void setEmployer(Employer employer) { this.employer = employer; }
}
