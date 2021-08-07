package vn.amit.springcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.amit.springcrud.entity.ClassRoom;
import vn.amit.springcrud.entity.Student;
@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom,Integer>,ClassRoomCustomRepository {
    ClassRoom findByName(String name);
    @Query("select s from ClassRoom cr join cr.students s where cr.id =:id")
    List<Student> findStudent(@Param("id") Integer id);
}
