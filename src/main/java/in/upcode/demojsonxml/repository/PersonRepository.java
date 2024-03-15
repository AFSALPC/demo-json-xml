package in.upcode.demojsonxml.repository;

import in.upcode.demojsonxml.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);

    @Query(value = "select * from person where name like :name limit 1",nativeQuery = true)
    Optional<Person> findByNameIgnoreCase(String name);
//    @Query(value = "from Person where age > 10",nativeQuery = false)
//    @Query(value = "select * from Person where age > 10",nativeQuery = true)
//    Optional<Person> findByAgeGreaterThan(int count);
}
