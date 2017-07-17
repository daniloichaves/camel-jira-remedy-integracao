package br.com.produban.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import br.com.produban.WebhookEvent;

@Component
public interface WebhookEventDAORepository extends MongoRepository<WebhookEvent, String> {

	// public WebhookEvent findByWebhookEvent1(String text);

	public List<WebhookEvent> findByWebhookEvent(String text);

}