package vn.amit.springcrud.api;

import java.util.ArrayList;
import java.util.List;
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

import vn.amit.springcrud.entity.ClassRoom;
import vn.amit.springcrud.entity.Student;
import vn.amit.springcrud.service.ClassRoomService;

@RestController
@RequestMapping("/api/class-room")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping("/get-all")
    public ResponseEntity<List<ClassRoom>> getAll() {
        try {
            List<ClassRoom> items = new ArrayList<ClassRoom>();

            classRoomService.getAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get-student/{id}")
    public ResponseEntity<List<Student>> getStudentClass(@PathVariable("id") Integer id) {
        try {
            List<Student> items = new ArrayList<Student>();

            classRoomService.findStudentByClass(id).forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get-total-point/{id}")
    public ResponseEntity<Double> getTotalPoint(@PathVariable("id") Integer id) {
        Double point = classRoomService.getTotalPoint(id);
        if (point!=null) {
            return new ResponseEntity<>(point, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-by-name/{id}")
    public ResponseEntity<ClassRoom> getById(@PathVariable("name") String name) {
        Optional<ClassRoom> existingItemOptional = classRoomService.findByName(name);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ClassRoom> create(@RequestBody ClassRoom item) {
        try {
            ClassRoom savedItem = classRoomService.add(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClassRoom> update(@PathVariable("id") Integer id, @RequestBody ClassRoom item) {
        Optional<ClassRoom> existingItemOptional = classRoomService.findById(id);
        if (existingItemOptional.isPresent()) {
            ClassRoom existingItem = existingItemOptional.get();
            return new ResponseEntity<>(classRoomService.add(existingItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
            classRoomService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
