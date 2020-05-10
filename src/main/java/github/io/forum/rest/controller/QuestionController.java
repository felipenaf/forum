package github.io.forum.rest.controller;

import github.io.forum.domain.entity.QuestionEntity;
import github.io.forum.domain.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/")
    public ResponseEntity getAll() {
        List<QuestionEntity> questionEntity = questionRepository.findAllByDeleted(false);

        if((questionEntity).size() > 0){
            return ResponseEntity.ok(questionEntity);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id)
    {
        Optional<QuestionEntity> questionEntity = questionRepository.findById(id);

        if((questionEntity).isPresent()){
            return ResponseEntity.ok(questionEntity.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody QuestionEntity question) {
        QuestionEntity questionSaved = questionRepository.save(question);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<QuestionEntity> update(@PathVariable Integer id){
        Optional<QuestionEntity> questionExistente = questionRepository.findById(id);

        if (questionExistente.isPresent()) {
            QuestionEntity question = questionExistente.get();
            question.setDeleted(true);
            questionRepository.save(question);
            return new ResponseEntity<QuestionEntity>(question, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionEntity> update(@PathVariable Integer id, @Valid @RequestBody QuestionEntity newQuestion){
        Optional<QuestionEntity> questionExistente = questionRepository.findById(id);

        if (questionExistente.isPresent()) {
            QuestionEntity question = questionExistente.get();
            question.setContent(newQuestion.getContent());
            questionRepository.save(question);
            return new ResponseEntity<QuestionEntity>(question, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
