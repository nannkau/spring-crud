package vn.amit.springcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.amit.springcrud.entity.Scores;

public interface ScoresRepository extends JpaRepository<Scores,Integer>{
    List<Scores> findByStudent_Id(Integer id);
}
