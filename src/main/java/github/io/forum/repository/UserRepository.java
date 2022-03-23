package github.io.forum.repository;

import github.io.forum.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer > {

//    List<QuestionEntity> findAllByDeletedOrderByCreationDateDesc(Boolean deleted);

}

