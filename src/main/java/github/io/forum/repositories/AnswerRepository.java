package github.io.forum.repositories;

import github.io.forum.entities.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Integer > {}
