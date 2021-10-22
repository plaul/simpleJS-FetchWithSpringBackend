package sem3.rest_js.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import sem3.rest_js.demo.entity.Person;
import sem3.rest_js.demo.repositories.PersonRepository;

@Configuration
public class DataSetup implements CommandLineRunner {

    PersonRepository personRepository;

    public DataSetup(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        personRepository.save(new Person("Peter","Olsen"));
        personRepository.save(new Person("Hanne","Olsen"));
    }
}
