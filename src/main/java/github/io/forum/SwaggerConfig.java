package github.io.forum;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(Collections.singleton("application/json")).consumes(Collections.singleton("application/json"))
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("github.io.forum"))
                .paths(PathSelectors.any()).build().apiInfo(this.informacoesApi().build());
    }

    private ApiInfoBuilder informacoesApi() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("Forum");
        apiInfoBuilder.description("API de um forum de perguntas e respostas para um desafio");
        apiInfoBuilder.version("1.0.0.0");
        apiInfoBuilder.termsOfServiceUrl("https://github.com/felipenaf");
        return apiInfoBuilder;
    }

}
