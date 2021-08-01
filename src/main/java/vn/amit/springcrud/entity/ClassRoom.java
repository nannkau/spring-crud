package vn.amit.springcrud.entity;

import java.util.List;

public class ClassRoom {
    private Integer id;
    private String name;
    private List<Student> list;

    public ClassRoom() {
    }

    public ClassRoom(Integer id, String name, List<Student> list) {
        this.id = id;
        this.name = name;
        this.list = list;
    }

    public List<Student> getList() {
        return this.list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
