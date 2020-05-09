package github.io.forum.rest.controller;

import github.io.forum.domain.repository.AnswerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    private AnswerRepository answerRepository;

    public AnswerController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

}
