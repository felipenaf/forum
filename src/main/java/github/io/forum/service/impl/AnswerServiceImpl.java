package github.io.forum.service.impl;

import github.io.forum.entity.AnswerEntity;
import github.io.forum.repository.AnswerRepository;
import github.io.forum.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Boolean delete(Integer id) {
        Optional<AnswerEntity> answer = answerRepository.findById(id);

        if(answer.isPresent()) {
            answerRepository.delete(answer.get());
            return true;
        }

        return false;
    }

    @Override
    public AnswerEntity update(Integer id, AnswerEntity newAnswer) {
        Optional<AnswerEntity> answerExistente = answerRepository.findById(id);

        if (answerExistente.isPresent()) {
            AnswerEntity answer = answerExistente.get();
            answer.setContent(newAnswer.getContent());
            answerRepository.save(answer);
            return answer;
        }

        return null;
    }
}
