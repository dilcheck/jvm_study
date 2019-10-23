package study.config;

import java.util.concurrent.ConcurrentLinkedDeque;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import study.util.Consumer;

@Configuration
public class ConsumerConfig {
	@Value("${test.user}")
	private int user;

	@Value("${test.count}")
	private int count;

	@Value("${test.interval}")
	private int interval;
	
	@Autowired
	ConcurrentLinkedDeque<String> concurrentLinkedDeque;

	@Autowired
	Consumer consumer;

	@PostConstruct
	private void consumerSetUp() {
		for (int j = 0; j < user; j++) {
			consumer.create()
			.setCount(count - 1) // 10초에 4개씩 저장 (40 개중 36개 pop)
			.setInterval(interval)
			.setConcurrentLinkedDeque(concurrentLinkedDeque)
			.start();
		}
	}
}
