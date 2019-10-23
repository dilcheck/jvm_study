package study.exec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("study.*")
public class JvmReceiverApplication {
	public static void main(String[] args) {
		SpringApplication.run(JvmReceiverApplication.class, args);
	}
}
