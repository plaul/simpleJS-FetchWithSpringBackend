package sem3.rest_js.demo.rest;

import org.springframework.web.bind.annotation.*;
import sem3.rest_js.demo.entity.Person;
import sem3.rest_js.demo.repositories.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("api/persons")
public class PersonResource {

    PersonRepository personRepository;

    public PersonResource(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    Iterable<Person> getAll() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    Person getOne(@PathVariable("id") int id) {
        //We will change this to handle error
        return personRepository.findById(id).get();
    }

    @PostMapping()
    Person addOne(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    Person editOne(@RequestBody Person person, @PathVariable("id") int id) {
        //We will change this to handle error
        Person p = personRepository.findById(id).get();
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        return personRepository.save(p);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable("id") int id) {
        personRepository.deleteById(id);
    }

}
