package in.kunal.main.repository;

import in.kunal.main.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByStudent_Id(Long studentId);
    List<Application> findByJob_Id(Long jobId);
}
