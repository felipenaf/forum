package github.io.forum.service.impl;

import github.io.forum.entity.QuestionEntity;
import github.io.forum.repository.QuestionRepository;
import github.io.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<QuestionEntity> getAll() {
        List<QuestionEntity> questionEntity = questionRepository.findAllByDeletedOrderByCreationDateDesc(false);
        return questionEntity;
    }

    public Optional<QuestionEntity> getById(Integer id) {
        Optional<QuestionEntity> questionEntity = questionRepository.findById(id);
        return Optional.of(questionEntity.get());
    }

    public QuestionEntity save(QuestionEntity question) {
        QuestionEntity questionSaved = questionRepository.save(question);
        return questionSaved;
    }

    public QuestionEntity delete(Integer id){
        Optional<QuestionEntity> questionExistente = questionRepository.findById(id);

        if (questionExistente.isPresent()) {
            QuestionEntity question = questionExistente.get();
            question.setDeleted(true);
            return questionRepository.save(question);
        }

        return null;
    }

    public QuestionEntity update(Integer id, QuestionEntity newQuestion){
        Optional<QuestionEntity> questionExistente = questionRepository.findById(id);

        if (questionExistente.isPresent()) {
            QuestionEntity question = questionExistente.get();
            question.setContent(newQuestion.getContent());
            return questionRepository.save(question);
        }

        return null;
    }

}
