package gamedevqa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import gamedevqa.models.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
