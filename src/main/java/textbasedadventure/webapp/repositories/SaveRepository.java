package textbasedadventure.webapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import textbasedadventure.webapp.models.Save;

public interface SaveRepository extends MongoRepository<Save, String> {
    Save findByUsername(String username);

    Save findById(String id);
}