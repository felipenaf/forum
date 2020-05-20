package github.io.forum;

import github.io.forum.entities.AnswerEntity;
import github.io.forum.entities.QuestionEntity;
import github.io.forum.repositories.AnswerRepository;
import github.io.forum.repositories.QuestionRepository;
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
        QuestionEntity questionEntity = new QuestionEntity("Pra que serve o @Controller?", "Felipe");
        this.questionRepository.save(questionEntity);

        AnswerEntity answerEntity = new AnswerEntity(questionEntity, "Criar um controllers", "Shibata");
        this.answerRepository.save(answerEntity);

        assertThat(answerEntity.getId()).isNotNull();
        assertThat(answerEntity.getContent()).isEqualTo("Criar um controllers");
        assertThat(answerEntity.getUser()).isEqualTo("Shibata");
    }

}
