package study.config;

import java.util.concurrent.ConcurrentLinkedDeque;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StackConfig {
	@Bean
	public ConcurrentLinkedDeque<String> concurrentLinkedDeque() {
		return new ConcurrentLinkedDeque<String>();
	}
}
