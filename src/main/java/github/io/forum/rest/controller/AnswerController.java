package github.io.forum.rest.controller;

import github.io.forum.rest.entity.AnswerEntity;
import github.io.forum.rest.repository.AnswerRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @ApiOperation(
            value = "Persistir uma resposta"
    )
    @PostMapping("/")
    public ResponseEntity save(@RequestBody AnswerEntity answer) {
        AnswerEntity answerSaved = answerRepository.save(answer);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ApiOperation(
        value = "Apagar uma resposta"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<AnswerEntity> answer = answerRepository.findById(id);

        if(answer.isPresent()) {
            answerRepository.delete(answer.get());
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(
            value = "Editar uma resposta"
    )
    @PutMapping("/{id}")
    public ResponseEntity<AnswerEntity> update(@PathVariable Integer id, @Valid @RequestBody AnswerEntity newAnswer){
        Optional<AnswerEntity> answerExistente = answerRepository.findById(id);

        if (answerExistente.isPresent()) {
            AnswerEntity answer = answerExistente.get();
            answer.setContent(newAnswer.getContent());
            answerRepository.save(answer);
            return new ResponseEntity<AnswerEntity>(answer, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
