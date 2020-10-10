package github.io.forum.service.impl;

import github.io.forum.entity.AnswerEntity;
import github.io.forum.repository.AnswerRepository;
import github.io.forum.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public AnswerEntity save(AnswerEntity answer) {
        AnswerEntity answerSaved = answerRepository.save(answer);
        return answerSaved;
    }

    @Override
    public AnswerEntity delete(Integer id) {
        return null;
    }

    @Override
    public AnswerEntity update(Integer id, AnswerEntity newAnswer) {
        return null;
    }
}
