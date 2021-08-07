package vn.amit.springcrud.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddStudentRequest {
    private String fullName;
    private String studentCode;
}
