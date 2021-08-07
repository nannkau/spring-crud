package vn.amit.springcrud.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vn.amit.springcrud.repository.ClassRoomCustomRepository;

public class ClassRoomCustomRepositoryImpl implements ClassRoomCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Double getScoreTotal(Integer classRoomId) {
        String sql= "select count(score_value) from class_room cr and student s and  scores sc where"
        +" cr.class_room_id= student.class_room_id and s.student_id = sc.student_id";
        Query query = entityManager.createQuery(sql);
        return Double.valueOf(query.getSingleResult().toString());
    }
    
}
