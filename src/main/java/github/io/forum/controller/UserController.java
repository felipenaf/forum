package github.io.forum.controller;

import github.io.forum.entity.UserEntity;
import github.io.forum.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "Return all users")
    @GetMapping("")
    public ResponseEntity getAll() {
        List<UserEntity> userEntity = userRepository.findAllByDeleted(false);

        if(userEntity.size() > 0){
            return new ResponseEntity(userEntity, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Return a user")
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id)
    {
        Optional<UserEntity> userEntity = userRepository.findById(id);

        if(userEntity.isPresent()){
            return new ResponseEntity(userEntity.get(), HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Persist a user")
    @PostMapping("")
    public ResponseEntity save(@RequestBody UserEntity user) {
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            return new ResponseEntity(user, HttpStatus.BAD_REQUEST);
        }

        UserEntity userSaved = userRepository.save(user);
        return new ResponseEntity(userSaved, HttpStatus.CREATED);
    }
}
