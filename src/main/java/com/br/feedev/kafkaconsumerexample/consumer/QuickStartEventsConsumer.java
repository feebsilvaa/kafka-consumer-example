package com.br.feedev.kafkaconsumerexample.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class QuickStartEventsConsumer {
	
	private static final Logger log = LoggerFactory.getLogger(QuickStartEventsConsumer.class);

	@Value(value = "${kafka.groupId}")
	private String groupId;
    
	@KafkaListener(topics = "${kafka.topicName}", groupId = "${kafka.groupId}")
	public void listenGroupFoo(String message) {
		log.info("Received Message in group {}: {}", groupId, message);
	}
	
}
