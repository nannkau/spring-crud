package vn.amit.springcrud.entity;

import java.util.List;

public class Student {
    private Integer id;
    private String fullName;
    private String studentCode;
    private List<Point> points;
    private ClassRoom classRoom; 

    public Student() {
    }

    public Student(Integer id, String fullName, String studentCode, List<Point> points, ClassRoom classRoom) {
        this.id = id;
        this.fullName = fullName;
        this.studentCode = studentCode;
        this.points = points;
        this.classRoom = classRoom;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentCode() {
        return this.studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public ClassRoom getClassRoom() {
        return this.classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
    
}
