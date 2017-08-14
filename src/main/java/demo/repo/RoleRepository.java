package demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
