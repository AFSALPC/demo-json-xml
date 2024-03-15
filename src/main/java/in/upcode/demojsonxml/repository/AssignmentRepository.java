package in.upcode.demojsonxml.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.upcode.demojsonxml.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {

    Optional<Assignment> findByNameIgnoreCase(String name);
    
}
