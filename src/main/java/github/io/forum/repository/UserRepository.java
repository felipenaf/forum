package github.io.forum.repository;

import github.io.forum.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer > {

    List<UserEntity> findAllByDeleted(Boolean deleted);

}

