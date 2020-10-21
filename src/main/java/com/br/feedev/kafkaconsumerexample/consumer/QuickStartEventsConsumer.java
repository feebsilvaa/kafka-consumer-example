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
    
	@KafkaListener(topics = "${kafka.topicName}", groupId = "${kafka.groupId}", containerFactory = "kafkaListenerContainerFactory")
	public void listenGroupFoo(String message) throws InterruptedException {
		log.info("Received Message in group {}: {}", groupId, message);
//		log.info("Processing...");
//		long timeout = Math.round(Math.random() * 10000);
//		timeout = timeout < 1000 ? timeout * 10 : timeout;
//		Thread.sleep(timeout);
//		log.info("Finished in {} miliseconds!", timeout);
	}
	
}
