package github.io.forum.repository;

import github.io.forum.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer > {

    List<QuestionEntity> findAllByDeletedOrderByCreationDateDesc(Boolean deleted);

}

