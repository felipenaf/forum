package github.io.forum.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController
{
    @GetMapping("/{question}")
    public String hello(@PathVariable("question") String question)
    {
        return String.format("Hello %s ", question);
    }
}
