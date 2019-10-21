package study.exec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan("study.*")
public class JvmSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JvmSenderApplication.class, args);
	}

}
