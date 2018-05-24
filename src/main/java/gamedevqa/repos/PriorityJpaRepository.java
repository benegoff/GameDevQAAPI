package gamedevqa.repos;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import gamedevqa.models.Priority;

public interface PriorityJpaRepository extends JpaRepository<Priority, Integer> {
	
}
