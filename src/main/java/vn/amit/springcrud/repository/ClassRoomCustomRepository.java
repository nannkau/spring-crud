package vn.amit.springcrud.repository;

import java.util.List;

import vn.amit.springcrud.entity.ClassRoom;

public interface ClassRoomCustomRepository {
    Double getScoreTotal(Integer classRoomId);
    List<ClassRoom> search(Integer id, String name, String studentName);
}