package github.io.forum.controller;

import github.io.forum.entity.QuestionEntity;
import github.io.forum.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "Retornar todas a perguntas")
    @GetMapping("")
    public ResponseEntity getAll() {
        List<QuestionEntity> questionEntity = questionService.getAll();

        if(questionEntity.size() > 0){
            return ResponseEntity.ok(questionEntity);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Retornar uma pergunta")
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id)
    {
        Optional<QuestionEntity> questionEntity = questionService.getById(id);

        if(questionEntity.isPresent()){
            return ResponseEntity.ok(questionEntity.get());
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Persistir uma pergunta")
    @PostMapping("")
    public ResponseEntity save(@RequestBody QuestionEntity question) {
        QuestionEntity questionSaved = questionService.save(question);
        return new ResponseEntity(questionSaved, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Apagar uma pergunta")
    @DeleteMapping("/{id}")
    public ResponseEntity<QuestionEntity> delete(@PathVariable Integer id){
        QuestionEntity questionDeleted = questionService.delete(id);

        if (questionDeleted != null) {
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Editar uma pergunta")
    @PutMapping("/{id}")
    public ResponseEntity<QuestionEntity> update(@PathVariable Integer id, @Valid @RequestBody QuestionEntity newQuestion){
        QuestionEntity questionUpdated = questionService.update(id, newQuestion);

        if (questionUpdated != null) {
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
