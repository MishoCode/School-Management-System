package example.school.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import example.school.model.Student;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private List<PlainSubjectDto> plainSubjectsDto = new ArrayList<>();

    public static StudentDto from(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setPlainSubjectsDto(
            student.getSubjects().stream()
                .map(PlainSubjectDto::from)
                .collect(Collectors.toList()));
        return studentDto;
    }
}
