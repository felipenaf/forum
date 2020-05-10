package github.io.forum.rest.controller;

import github.io.forum.domain.entity.QuestionEntity;
import github.io.forum.domain.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/")
    public ResponseEntity getQuestions() {
        List<QuestionEntity> questionEntity = questionRepository.findAll();

        if((questionEntity).size() > 0){
            return ResponseEntity.ok(questionEntity);
        }

        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity getQuestionById(@PathVariable Integer id)
    {
        Optional<QuestionEntity> questionEntity = questionRepository.findById(id);

        if((questionEntity).isPresent()){
            return ResponseEntity.ok(questionEntity.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity saveQuestion(@RequestBody QuestionEntity question) {
        QuestionEntity questionSaved = questionRepository.save(question);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
