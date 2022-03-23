package github.io.forum.controller;

import github.io.forum.entity.UserEntity;
import github.io.forum.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "Retornar todos os usuários")
    @GetMapping("")
    public ResponseEntity getAll() {
        List<UserEntity> userEntity = userRepository.findAll();

        if(userEntity.size() > 0){
            return new ResponseEntity(userEntity, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

//    @ApiOperation(value = "Retornar uma pergunta")
//    @GetMapping("/{id}")
//    public ResponseEntity getById(@PathVariable Integer id)
//    {
//        Optional<QuestionEntity> questionEntity = questionService.getById(id);
//
//        if(questionEntity.isPresent()){
//            return new ResponseEntity(questionEntity.get(), HttpStatus.OK);
//        }
//
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }
//
    @ApiOperation(value = "Persistir um usuário")
    @PostMapping("")
    public ResponseEntity save(@RequestBody UserEntity user) {
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            return new ResponseEntity(user, HttpStatus.BAD_REQUEST);
        }

        UserEntity userSaved = userRepository.save(user);
        return new ResponseEntity(userSaved, HttpStatus.CREATED);
    }
//
//    @ApiOperation(value = "Apagar uma pergunta")
//    @DeleteMapping("/{id}")
//    public ResponseEntity<QuestionEntity> delete(@PathVariable Integer id){
//        QuestionEntity questionDeleted = questionService.delete(id);
//
//        if (questionDeleted != null) {
//            return new ResponseEntity(HttpStatus.OK);
//        }
//
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }
//
//    @ApiOperation(value = "Editar uma pergunta")
//    @PutMapping("/{id}")
//    public ResponseEntity<QuestionEntity> update(@PathVariable Integer id, @Valid @RequestBody QuestionEntity newQuestion){
//        if (newQuestion.getContent() == null) {
//            return new ResponseEntity(newQuestion, HttpStatus.BAD_REQUEST);
//        }
//
//        QuestionEntity questionUpdated = questionService.update(id, newQuestion);
//
//        if (questionUpdated != null) {
//            return new ResponseEntity(questionUpdated, HttpStatus.OK);
//        }
//
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//    }

}
