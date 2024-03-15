package in.upcode.demojsonxml.controller;
import in.upcode.demojsonxml.model.Person;
import in.upcode.demojsonxml.repository.PersonRepository;
import in.upcode.demojsonxml.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(value = "/api/persons" ,produces = MediaType.APPLICATION_ATOM_XML_VALUE)
@RequestMapping(value = "/api/persons")
public class PersonController {
    Logger logger = LoggerFactory.getLogger("PersonController");
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonService personService;

    @GetMapping("")
    List<Person> listOfAllPeoples(@RequestParam(value = "name", required = false) String name) {
        // logger.debug("Received parameter " + name);
        List<Person> persons = personService.getPerson(name);
        // logger.debug("Returning list of person " + persons);
        return persons;

    }

    @GetMapping("/{id}")
    ResponseEntity getAPersonWithID(@PathVariable("id") Integer id) {
        final Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            // logger.error("The person with id : " + id + "is not fount");
            return ResponseEntity.ok(optionalPerson.get());
        }
        return ResponseEntity.badRequest().body("could not fount any person with the given id.. " + id);
    }

    @GetMapping("/{id}/cars")
    ResponseEntity getAllCarsOwnedByAPerson(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(personService.getAllCarsOwnedBy(id));
    }

    @PutMapping(value = "/{id}")
    ResponseEntity updateAPersonWithID(@PathVariable("id") Integer id, @RequestBody Person person) {
        final Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            return ResponseEntity.badRequest().body("could not faint any person !!!");
        }
        Person existingPerson = optionalPerson.get();
        existingPerson.setName(person.getName());
        existingPerson.setAge(person.getAge());
        return ResponseEntity.ok(personRepository.save(existingPerson));


    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity deleteAPerson(@PathVariable("id") Integer id) {
        personRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    ResponseEntity createAPerson(@RequestBody Person person, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println(person);


        if (person.getOwnedCars() != null)
            person.getOwnedCars().forEach(car -> car.setOwner(person));


        final Person createdPerson = personRepository.save(person);
        final URI location = uriComponentsBuilder.path("/api/persons/{id}").buildAndExpand(createdPerson.getId()).toUri();
        return ResponseEntity.created(location).body(createdPerson);
    }
}





