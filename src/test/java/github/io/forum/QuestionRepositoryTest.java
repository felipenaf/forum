package github.io.forum;

import github.io.forum.entity.QuestionEntity;
import github.io.forum.repository.QuestionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void saveQuestionTest() {
        QuestionEntity questionEntity = new QuestionEntity("Pra que serve o @Controller?", "Felipe");
        this.questionRepository.save(questionEntity);
        assertThat(questionEntity.getId()).isNotNull();
        assertThat(questionEntity.getContent()).isEqualTo("Pra que serve o @Controller?");
        assertThat(questionEntity.getUser()).isEqualTo("Felipe");
    }

    @Test
    public void getAllTest() {
        QuestionEntity questionEntity = new QuestionEntity("Pra que serve o @Controller?", "Felipe");
        questionEntity.setDeleted(true);
        QuestionEntity questionEntity2 = new QuestionEntity("Pra que serve o @Controller?", "Felipe");

        this.questionRepository.save(questionEntity);
        this.questionRepository.save(questionEntity2);

        List<QuestionEntity> questionResult = questionRepository.findAllByDeletedOrderByCreationDateDesc(false);
        assertThat(questionResult.size()).isEqualTo(1);
    }

}
