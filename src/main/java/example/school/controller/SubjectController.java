package example.school.controller;

import example.school.dto.SubjectDto;
import example.school.model.Subject;
import example.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("")
    public ResponseEntity<List<SubjectDto>> getSubjects() {
        List<Subject> subjects = subjectService.getSubjects();
        List<SubjectDto> subjectsDtoList = subjects.stream().map(SubjectDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(subjectsDtoList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<SubjectDto> addSubject(@RequestBody SubjectDto subjectDto) {
        Subject subject = subjectService.addSubject(Subject.from(subjectDto));
        return new ResponseEntity<>(SubjectDto.from(subject), HttpStatus.OK);
    }
}
