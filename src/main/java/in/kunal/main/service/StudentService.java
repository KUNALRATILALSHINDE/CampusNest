package in.kunal.main.service;

import in.kunal.main.model.Student;
import in.kunal.main.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public Student registerStudent(Student student) {
        if (student.getEmail() == null || student.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is required!");
        }
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public List<Student> searchBySkill(String skill) {
        return studentRepo.findBySkillsContainingIgnoreCase(skill);
    }

    public Optional<Student> getStudentByEmail(String email) {
        return studentRepo.findByEmail(email);
    }
}
