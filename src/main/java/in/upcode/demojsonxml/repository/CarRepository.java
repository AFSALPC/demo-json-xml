package in.upcode.demojsonxml.repository;

import in.upcode.demojsonxml.dto.PersonCarsDTO;
import in.upcode.demojsonxml.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findByOwnerId(Integer ownerId);
    @Query(value = "select p.name as name, string_agg(c.model,',') as cars from person p left join car c on c.owner_id = p.id group by p.name",nativeQuery = true)
    List<PersonCarsDTO> findAllPersonNameWithCars();
}
