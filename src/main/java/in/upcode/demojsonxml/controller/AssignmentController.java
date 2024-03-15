package in.upcode.demojsonxml.controller;

import in.upcode.demojsonxml.model.Assignment;
import in.upcode.demojsonxml.repository.AssignmentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/assignments")
public class AssignmentController {

  // @GetMapping("/single")
  //    public Assignment getSingleAssignment(){
  //     Assignment assignment = new Assignment();
  //     assignment.setName("afsal");
  //     assignment.setPages(5);
  //     return assignment;

  //    }

  //    @GetMapping("")
  //    public List<Assignment>getAssignmentList(){
  //       Assignment assignment1 = new Assignment();
  //       assignment1.setName("Time");
  //       assignment1.setPages(8);
  //       Assignment assignment2 = new Assignment();
  //       assignment2.setName("Forbes");
  //       assignment2.setPages(15);
  //       return Arrays.asList(assignment1,assignment2);
  //    }

  @Autowired
  AssignmentRepository assignmentRepository;

  @GetMapping("")
  List<Assignment> listOfAllAssignments(
    @RequestHeader(value = "name", required = false) String name
  ) {
    if (name == null) return assignmentRepository.findAll();
    final Optional<Assignment> assignmentWithGivenName = assignmentRepository.findByNameIgnoreCase(
      name
    );

    if (assignmentWithGivenName.isEmpty()) {
      return new ArrayList<>();
    }
    return List.of(assignmentWithGivenName.get());
  }

  @GetMapping("{id}")
  ResponseEntity getAllAssignmentById(@PathVariable("id") Integer id) {
    final Optional<Assignment> optionalAssignment = assignmentRepository.findById(
      id
    );
    if (optionalAssignment.isEmpty()) {
      return ResponseEntity
        .badRequest()
        .body("could not assignment in given id " + id);
    }
    return ResponseEntity.ok(optionalAssignment.get());
  }

  @PutMapping("{id}")
  ResponseEntity updateAssignmentWithId(
    @PathVariable("id") Integer id,
    @RequestBody Assignment assignment
  ) {
    final Optional<Assignment> optionalAssignment = assignmentRepository.findById(id);
    if (optionalAssignment.isEmpty()) {
      return ResponseEntity.badRequest().body("could not assignment");
    }
    return ResponseEntity.ok(assignmentRepository.save(assignment));
  }

  @DeleteMapping("/{id}")
  ResponseEntity deleteAssignment(@PathVariable("id") Integer id) {
    assignmentRepository.deleteById(id);
    return ResponseEntity.notFound().build();
  }

  @PatchMapping("{id}")
  ResponseEntity changeAssignmentWithId(@PathVariable("id") Integer id) {

    return null;
  }
}
