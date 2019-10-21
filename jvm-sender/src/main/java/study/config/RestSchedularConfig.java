package study.config;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import study.model.ResultForm;
import study.model.SendForm;

@Configuration
public class RestSchedularConfig {
	@Value("${test.user}")
	private int user;

	@Value("${test.count}")
	private int count;
	
	Logger logger = getLogger(this.getClass());

	@Scheduled(fixedDelayString = "${test.interval}")
	private void setUp() {
		IntStream.range(0, user).parallel().forEach(u -> {
			RestTemplate restTemplate = new RestTemplate();
			for (int i = 0; i < count; i++) {
				SendForm sendForm = new SendForm();
				sendForm.setData("test");
				restTemplate.postForObject("http://localhost:8081/insert", sendForm, ResultForm.class);
				logger.info("call");
			}
		});
	}
}
