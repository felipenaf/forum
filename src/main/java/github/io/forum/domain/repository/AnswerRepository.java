package github.io.forum.domain.repository;

import github.io.forum.domain.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Integer > {}
