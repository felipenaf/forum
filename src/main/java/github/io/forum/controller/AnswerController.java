package github.io.forum.controller;

import github.io.forum.entity.AnswerEntity;
import github.io.forum.service.AnswerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @ApiOperation(value = "Persistir uma resposta")
    @PostMapping("")
    public ResponseEntity save(@RequestBody AnswerEntity answer) {
        AnswerEntity answerSaved = answerService.save(answer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Apagar uma resposta")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Boolean answer = answerService.delete(id);

        if(answer == true) {
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Editar uma resposta")
    @PutMapping("/{id}")
    public ResponseEntity<AnswerEntity> update(@PathVariable Integer id, @Valid @RequestBody AnswerEntity newAnswer){
        AnswerEntity answer = answerService.update(id, newAnswer);

        if (answer != null) {
            return new ResponseEntity<AnswerEntity>(answer, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
