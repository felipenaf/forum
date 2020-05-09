package github.io.forum;

import github.io.forum.domain.entity.QuestionEntity;
import github.io.forum.domain.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class ForumApplication {

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired QuestionRepository questionRepository) {
        return args -> {
            QuestionEntity question = new QuestionEntity("Pra que serve a annotation @Controller ?", "Fulano");
            questionRepository.save(question);
        };

    }

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

//	@GetMapping("/")
//	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return String.format("Hello %s!", name);
//	}

}
