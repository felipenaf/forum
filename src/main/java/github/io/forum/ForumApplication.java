package github.io.forum;

import github.io.forum.domain.entity.AnswerEntity;
import github.io.forum.domain.entity.QuestionEntity;
import github.io.forum.domain.repository.AnswerRepository;
import github.io.forum.domain.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class ForumApplication {

    @PostConstruct
    public void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired QuestionRepository questionRepository, @Autowired AnswerRepository answerRepository) {
        return args -> {
            QuestionEntity question = new QuestionEntity(
                "Pra que serve a annotation @Controller ?",
                "Fulano"
            );

            questionRepository.save(question);

            QuestionEntity question2 = new QuestionEntity(
                    "Como fazer um requisição GET ?",
                    "Cicrano"
            );

            questionRepository.save(question2);

            AnswerEntity answer = new AnswerEntity(
                    question,
                    "Criar um controller",
                    "Josefina"
            );

            answerRepository.save(answer);

            AnswerEntity answer2 = new AnswerEntity(
                    question,
                    "Criar um controller hehehe",
                    "Maria José"
            );

            answerRepository.save(answer2);
        };

    }

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

}
