package gamedevqa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import gamedevqa.models.Priority;

public interface PriorityJpaRepository extends JpaRepository<Priority, Integer> {

}
