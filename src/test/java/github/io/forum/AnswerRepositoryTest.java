package github.io.forum;

import github.io.forum.entity.AnswerEntity;
import github.io.forum.entity.QuestionEntity;
import github.io.forum.entity.UserEntity;
import github.io.forum.repository.AnswerRepository;
import github.io.forum.repository.QuestionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnswerRepositoryTest {

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void saveAnswerTest() {
        UserEntity userEntity = new UserEntity("Felipe", "felipe@felipe", "123");
        QuestionEntity questionEntity = new QuestionEntity("Pra que serve o @Controller?", userEntity);
        this.questionRepository.save(questionEntity);

        AnswerEntity answerEntity = new AnswerEntity(questionEntity, "Criar um controller", "Shibata");
        this.answerRepository.save(answerEntity);

        assertThat(answerEntity.getId()).isNotNull();
        assertThat(answerEntity.getContent()).isEqualTo("Criar um controller");
        assertThat(answerEntity.getUser()).isEqualTo("Shibata");
    }

}
