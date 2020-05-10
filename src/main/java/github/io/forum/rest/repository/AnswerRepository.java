package github.io.forum.rest.repository;

import github.io.forum.rest.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Integer > {}
