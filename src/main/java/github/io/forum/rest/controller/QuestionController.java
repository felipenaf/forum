package github.io.forum.rest.controller;

import github.io.forum.domain.entity.QuestionEntity;
import github.io.forum.domain.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository qr) {
        this.questionRepository = qr;
    }

    @GetMapping("/{id}")
    public ResponseEntity getQuestionById(@PathVariable Integer id)
    {
        Optional<QuestionEntity> questionEntity = questionRepository.findById(id);

        if((questionEntity).isPresent()){
            return ResponseEntity.ok( questionEntity.get() );
        }

        return ResponseEntity.notFound().build();
    }

}
