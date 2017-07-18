package br.com.produban;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.google.gson.Gson;

public class MyProcessor implements Processor{
	public void process(Exchange exchange) throws Exception {
    	Gson gson = new Gson();
    	String path = new File(".").getCanonicalPath();
    	WebhookEvent event = gson.fromJson(new FileReader(path + "/dest/restoutput.json"), WebhookEvent.class);
    	assertEquals("jira:issue_updated", event.getWebhookEvent());
    	System.out.println(event.getWebhookEvent());
	}
}
