package br.com.produban;

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
    	
    	System.out.println(event.getWebhookEvent());
	}
}
