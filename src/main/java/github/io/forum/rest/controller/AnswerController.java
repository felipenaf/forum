package github.io.forum.rest.controller;

import github.io.forum.domain.entity.AnswerEntity;
import github.io.forum.domain.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping("/create")
    public ResponseEntity saveAnswer(@RequestBody AnswerEntity answer) {
        AnswerEntity answerSaved = answerRepository.save(answer);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
