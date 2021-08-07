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
import org.springframework.web.bind.annotation.RestController;

import vn.amit.springcrud.entity.ClassRoom;
import vn.amit.springcrud.entity.Student;
import vn.amit.springcrud.model.request.AddClassRoomRequest;
import vn.amit.springcrud.model.request.UpdateClassRoomRequest;
import vn.amit.springcrud.model.response.BaseResponse;
import vn.amit.springcrud.service.ClassRoomService;

@RestController
@RequestMapping("/api/class-rooms")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @GetMapping()
    public ResponseEntity<BaseResponse<List<ClassRoom>>> getAll() {
        return ResponseEntity.ok().body(new BaseResponse<>(classRoomService.getAll()));
        
    }
    @GetMapping("/{id}/students")
    public ResponseEntity<BaseResponse<List<Student>>> getStudentClass(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(new BaseResponse<>(classRoomService.findStudentByClass(id)));
    }
    @GetMapping("/{id}/total-point/")
    public ResponseEntity<BaseResponse<Double>> getTotalPoint(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(new BaseResponse<>(classRoomService.getTotalPoint(id)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ClassRoom>> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(new BaseResponse<>(classRoomService.findById(id)));
    }
    @GetMapping("/search")
    public ResponseEntity<BaseResponse<List<ClassRoom>>> getByName(@PathVariable("name") String name,@PathVariable("studentName") String studentName,@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(new BaseResponse<>(classRoomService.search(id, name, studentName)));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse<ClassRoom>> create(@RequestBody AddClassRoomRequest item) {
        return ResponseEntity.ok().body(new BaseResponse<>(classRoomService.add(item)));
    }

    @PutMapping()
    public ResponseEntity<BaseResponse<ClassRoom>> update( @RequestBody UpdateClassRoomRequest item) {
        return ResponseEntity.ok().body(new BaseResponse<>(classRoomService.update(item)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> delete(@PathVariable("id") Integer id) {
        classRoomService.delete(id);
        return ResponseEntity.ok().body(new BaseResponse<>());
    }
}
