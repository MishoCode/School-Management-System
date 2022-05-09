package example.school.dto;

import example.school.model.Student;
import lombok.Data;

@Data
public class PlainStudentDto {
    private Long id;
    private String name;

    public static PlainStudentDto from(Student student) {
        PlainStudentDto plainStudentDto = new PlainStudentDto();
        plainStudentDto.setId(student.getId());
        plainStudentDto.setName(student.getName());
        return plainStudentDto;
    }
}
