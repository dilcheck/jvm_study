package study.util;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.concurrent.ConcurrentLinkedDeque;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Consumer extends Thread {
	Logger logger = getLogger(this.getClass());

	private int count;
	private int interval;
	private ConcurrentLinkedDeque<String> concurrentLinkedDeque;

	public Consumer setCount(int count) {
		this.count = count;
		return this;
	}

	public Consumer setInterval(int interval) {
		this.interval = interval;
		return this;
	}

	public Consumer setConcurrentLinkedDeque(ConcurrentLinkedDeque<String> concurrentLinkedDeque) {
		this.concurrentLinkedDeque = concurrentLinkedDeque;
		return this;
	}

	public Consumer create() {
		return new Consumer();
	}

	@Override
	public void run() {
		while (true) {

			for (int i = 0; i < this.count; i++) {
				if (concurrentLinkedDeque.isEmpty()) {
					continue;
				}
				logger.info("pop " + i);
				concurrentLinkedDeque.pop();
			}

			try {
				Thread.sleep(this.interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
