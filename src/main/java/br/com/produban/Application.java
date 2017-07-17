package br.com.produban;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.camel.main.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.produban.repository.WebhookEventDAORepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
		Main main = new Main();
		main.addRouteBuilder(new MyRouteBuilder());
		main.run(args);
	}

	@Autowired
	private WebhookEventDAORepository repostiory;

	@PostConstruct
	public void insertWebhook() throws Exception {

		repostiory.deleteAll();

		WebhookEvent entity = new WebhookEvent();
		String text = "text inserti mongo";
		entity.setWebhookEvent(text);
		repostiory.save(entity);

		System.out.println("country: " + entity);

		List<WebhookEvent> list = repostiory.findByWebhookEvent(text);
		for (WebhookEvent webhookEvent : list) {

			System.out.println("webhook" + webhookEvent.toString());

		}

	}
}