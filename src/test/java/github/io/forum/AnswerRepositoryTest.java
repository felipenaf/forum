package github.io.forum;

import github.io.forum.entity.AnswerEntity;
import github.io.forum.entity.QuestionEntity;
import github.io.forum.entity.UserEntity;
import github.io.forum.repository.AnswerRepository;
import github.io.forum.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AnswerRepositoryTest {

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void saveAnswerTest() {
        UserEntity felipe = new UserEntity("Felipe", "felipe@test", "123");
        QuestionEntity questionEntity = new QuestionEntity("Pra que serve o @Controller?", felipe);
        this.questionRepository.save(questionEntity);

        UserEntity dunha = new UserEntity("Dunha", "dunha@test", "123");
        AnswerEntity answerEntity = new AnswerEntity(questionEntity, "Criar um controller", dunha);
        this.answerRepository.save(answerEntity);

        assertThat(answerEntity.getId()).isNotNull();
        assertThat(answerEntity.getContent()).isEqualTo("Criar um controller");
        assertThat(answerEntity.getUser()).isEqualTo(dunha);
    }

}
