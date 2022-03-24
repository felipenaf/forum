package github.io.forum;

import github.io.forum.entity.QuestionEntity;
import github.io.forum.entity.UserEntity;
import github.io.forum.repository.QuestionRepository;
import github.io.forum.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveQuestionTest() {
        UserEntity userEntity = new UserEntity("Felipe", "felipe@felipe", "123");
        QuestionEntity questionEntity = new QuestionEntity("Pra que serve o @Controller?", userEntity);
        this.questionRepository.save(questionEntity);
        assertThat(questionEntity.getId()).isNotNull();
        assertThat(questionEntity.getContent()).isEqualTo("Pra que serve o @Controller?");
        assertThat(questionEntity.getUser()).isEqualTo(userEntity);
    }

    @Test
    public void getAllTest() {
        UserEntity userEntity = new UserEntity("Felipe", "felipe@felipe", "123");
        this.userRepository.save(userEntity);

        QuestionEntity questionEntity = new QuestionEntity("Pra que serve o @Controller?", userEntity);
        questionEntity.setDeleted(true);
        QuestionEntity questionEntity2 = new QuestionEntity("Pra que serve o @Controller?", userEntity);

        this.questionRepository.save(questionEntity);
        this.questionRepository.save(questionEntity2);

        List<QuestionEntity> questionResult = questionRepository.findAllByDeletedOrderByCreationDateDesc(false);
        assertThat(questionResult.size()).isEqualTo(1);
    }

}
