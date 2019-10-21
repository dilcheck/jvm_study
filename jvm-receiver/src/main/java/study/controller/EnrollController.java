package study.controller;

import java.util.concurrent.ConcurrentLinkedDeque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import study.model.ResultForm;
import study.model.SendForm;

@RestController
public class EnrollController extends AbstractController {
	@Autowired
	ConcurrentLinkedDeque<String> concurrentLinkedDeque;
	
	@PostMapping("/insert")
	public ResultForm insert(@RequestBody SendForm sendForm) {
		logger.info(sendForm.getData());
		
		concurrentLinkedDeque.push(sendForm.getData());
		
		ResultForm resultForm = new ResultForm();
		return resultForm;
	}
}
