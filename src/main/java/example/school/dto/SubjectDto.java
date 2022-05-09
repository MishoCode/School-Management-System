package example.school.dto;

import example.school.model.Subject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SubjectDto {
    private Long id;
    private String name;
    private List<PlainStudentDto> plainStudentsDto = new ArrayList<>();

    public static SubjectDto from(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        subjectDto.setPlainStudentsDto(
            subject.getStudents().stream()
                .map(PlainStudentDto::from)
                .collect(Collectors.toList()));
        return subjectDto;
    }
}
