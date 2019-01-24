package isep.web.moviesep.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "isep.web.moviesep" })
@EntityScan("isep.web.moviesep.jpa.entities")
@EnableJpaRepositories("isep.web.moviesep.dao.repositories")
public class MvcConfig implements WebMvcConfigurer {

}