package cz.cvut.sep.rychljir.objects;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RequestRepository extends CrudRepository<Request, Integer> {
    List<Request> findByTimeStamp(String timeStamp);
    List<Request> findById(int id);
}