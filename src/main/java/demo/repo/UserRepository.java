package demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
}
