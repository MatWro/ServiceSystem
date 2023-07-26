package carServiceSystem.repository;

import carServiceSystem.entity.FixRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulingRepository extends JpaRepository<FixRequest, Long> {
}
