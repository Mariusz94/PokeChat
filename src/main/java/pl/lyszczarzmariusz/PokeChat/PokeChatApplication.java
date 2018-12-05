package pl.lyszczarzmariusz.PokeChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(
		basePackageClasses = {PokeChatApplication.class, Jsr310JpaConverters.class}
)
public class PokeChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeChatApplication.class, args);
	}
}
