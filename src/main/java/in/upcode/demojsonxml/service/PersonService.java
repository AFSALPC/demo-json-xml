package in.upcode.demojsonxml.service;

import in.upcode.demojsonxml.model.Car;
import in.upcode.demojsonxml.model.Person;
import in.upcode.demojsonxml.repository.CarRepository;
import in.upcode.demojsonxml.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class                                                                                                                                                                    PersonService {
    @Autowired
    CarRepository carRepository;
    @Autowired
   PersonRepository personRepository;

    public List<Car> getAllCarsOwnedBy(Integer id) {
        return carRepository.findByOwnerId(id);

    }
    public  List<Person> getPerson(String name){
        if (name == null)
            return personRepository.findAll();
        final Optional<Person> personWithGivenName = personRepository.findByNameIgnoreCase(name);

        if (personWithGivenName.isEmpty()){
            return new ArrayList<>();
        }
        return List.of(personWithGivenName.get());
    }
}

