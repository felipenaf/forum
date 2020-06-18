package github.io.forum.service;

import github.io.forum.entity.QuestionEntity;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    public List<QuestionEntity> getAll();

    public Optional<QuestionEntity> getById(Integer id);

    public QuestionEntity save(QuestionEntity question);

    public QuestionEntity delete(Integer id);

    public QuestionEntity update(Integer id, QuestionEntity newQuestion);

    }
