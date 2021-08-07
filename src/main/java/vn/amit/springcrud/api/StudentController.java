package vn.amit.springcrud.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.amit.springcrud.entity.Scores;
import vn.amit.springcrud.entity.Student;
import vn.amit.springcrud.model.request.AddStudentRequest;
import vn.amit.springcrud.model.request.UpdateStudentRequest;
import vn.amit.springcrud.model.response.BaseResponse;
import vn.amit.springcrud.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Student>> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(new BaseResponse<>(studentService.findById(id)));
    }
    @GetMapping("/search")
    public ResponseEntity<BaseResponse<Student>> getByName(@RequestParam("name") String name) {
        return ResponseEntity.ok().body(new BaseResponse<>(studentService.findByName(name)));
    }
    @GetMapping("/{id}/scores")
    public ResponseEntity<BaseResponse<List<Scores>>> getPoint(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(new BaseResponse<>(studentService.getPoint(id)));
    }

    @PostMapping()
    public ResponseEntity<BaseResponse<Student>> create(@RequestBody AddStudentRequest request) {
        return ResponseEntity.ok().body(new BaseResponse<>(studentService.save(request)));
    }

    @PutMapping()
    public ResponseEntity<BaseResponse<Student>> update(@RequestBody UpdateStudentRequest item) {
        return ResponseEntity.ok().body(new BaseResponse<>(studentService.update(item)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> delete(@PathVariable("id") Integer id) {
        studentService.deleteById(id);
        return ResponseEntity.ok().body(new BaseResponse<>());
    }
}
