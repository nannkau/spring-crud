package vn.amit.springcrud.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import vn.amit.springcrud.entity.ClassRoom;
import vn.amit.springcrud.repository.ClassRoomCustomRepository;

public class ClassRoomCustomRepositoryImpl implements ClassRoomCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Double getScoreTotal(Integer classRoomId) {
        String sql= "select count(score_value) from class_room cr and student s and  scores sc where"
        +" cr.class_room_id= student.class_room_id and s.student_id = sc.student_id and cr.class_room_id=:id ";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", classRoomId);
        return Double.valueOf(query.getSingleResult().toString());
    }
    @Override
    public List<ClassRoom> search(Integer id, String name, String studentName) {
        StringBuffer sql= new StringBuffer();
        sql.append("select c from ClassRoom c join c.students s where 1=1");
        if(id != null){
            sql.append(" and c.id=:id");
        }
        if(StringUtils.isNotBlank(name)){
            sql.append(" and c.name=:name");
        }
        if(StringUtils.isNotBlank(studentName)){
            sql.append(" and s.fullName=:studentName");
        }
        Query query = entityManager.createQuery(sql.toString());
        if(id != null){
            query.setParameter("id", id);
        }
        if(StringUtils.isNotBlank(name)){
            query.setParameter("name", id);
        }
        if(StringUtils.isNotBlank(studentName)){
            query.setParameter("studentName", studentName);
        }
        return (List<ClassRoom>) query.getResultList();
    }
    
}
