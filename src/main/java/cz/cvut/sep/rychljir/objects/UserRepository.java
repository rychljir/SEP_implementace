package cz.cvut.sep.rychljir.objects;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByName(String nickname);
}