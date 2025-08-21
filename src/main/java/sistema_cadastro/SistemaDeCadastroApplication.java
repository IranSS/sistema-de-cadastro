package sistema_cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "sistema_cadastro/repository")
public class SistemaDeCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeCadastroApplication.class, args);
	}

}
