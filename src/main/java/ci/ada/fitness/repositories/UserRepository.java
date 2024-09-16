package ci.ada.fitness.repositories;

import ci.ada.fitness.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

