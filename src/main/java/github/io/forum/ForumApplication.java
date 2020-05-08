package github.io.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/hello")
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

	@GetMapping("/test")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

//	outra forma de ser usado
//	@GetMapping("/test/{name}")
//	public String hello(@PathVariable("name") String name) {
//		return String.format("Hello %s!", name);
//	}

}
