package github.io.forum.service;

import github.io.forum.entity.AnswerEntity;

public interface AnswerService {

    public AnswerEntity save(AnswerEntity answer);

    public Boolean delete(Integer id);

    public AnswerEntity update(Integer id, AnswerEntity newAnswer);
}
