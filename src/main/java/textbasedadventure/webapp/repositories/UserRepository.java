package textbasedadventure.webapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import textbasedadventure.webapp.models.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    List<User> findByEmail(String email);
    User findByUsernameAndPassword(String username,String password);
}
