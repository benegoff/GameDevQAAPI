package gamedevqa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import gamedevqa.models.Bug;

public interface BugJpaRepository extends JpaRepository<Bug, Integer> {

}
