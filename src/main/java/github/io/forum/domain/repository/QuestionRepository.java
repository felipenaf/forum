package github.io.forum.domain.repository;

import github.io.forum.domain.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer > {

}

