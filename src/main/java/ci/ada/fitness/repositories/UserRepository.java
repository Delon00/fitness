package ci.ada.fitness.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import ci.ada.fitness.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findBySlug(String slug);
}

