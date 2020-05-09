package github.io.forum.rest.controller;

import github.io.forum.domain.entity.AnswerEntity;
import github.io.forum.domain.repository.AnswerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private AnswerRepository answerRepository;

    public AnswerController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @PostMapping("/create")
    public ResponseEntity saveAnswer(@RequestBody AnswerEntity answer) {
        AnswerEntity answerSaved = answerRepository.save(answer);

        return ResponseEntity.ok(answerRepository);
    }

}
