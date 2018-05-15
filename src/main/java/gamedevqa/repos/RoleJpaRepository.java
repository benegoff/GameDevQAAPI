package gamedevqa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import gamedevqa.models.Role;

public interface RoleJpaRepository extends JpaRepository<Role, Integer> {

}
