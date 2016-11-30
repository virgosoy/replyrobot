package com.soy.replyrobot.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TransactionalService {
	
	void transactionalOpeation();
	
}
