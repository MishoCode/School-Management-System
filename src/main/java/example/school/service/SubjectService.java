package example.school.service;

import example.school.exceptions.StudentNotFoundException;
import example.school.model.Subject;
import example.school.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubject(Long id) {
        return subjectRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("This subject cannot be found"));
    }

    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
}
