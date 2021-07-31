package vn.amit.springcrud.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.amit.springcrud.entity.Point;
import vn.amit.springcrud.entity.Student;
import vn.amit.springcrud.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-detail/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Integer id) {
        Optional<Student> student = studentService.findById(id);

        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-detail/{name}")
    public ResponseEntity<Student> getByName(@PathVariable("name") String name) {
        Optional<Student> student = studentService.findByName(name);

        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-point/{id}")
    public ResponseEntity<Point> getPoint(@PathVariable("id") Integer id) {
        Point point = studentService.getPoint(id);

        if (point!=null) {
            return new ResponseEntity<>(point, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Student> create(@RequestBody Student item) {
        try {
            Student savedItem = studentService.save(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Integer id,@RequestBody Student item) {
        Optional<Student> existingItemOptional = studentService.findById(id);
        if (existingItemOptional.isPresent()) {
            Student existingItem = existingItemOptional.get();
            return new ResponseEntity<>(studentService.save(existingItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{/delete/id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
            studentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
