package sem3.rest_js.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import sem3.rest_js.demo.entity.Person;

public interface PersonRepository extends CrudRepository<Person,Integer> {

}
