package hello;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.google.gson.Gson;

public class MyProcessor implements Processor{
	public void process(Exchange exchange) throws Exception {
    	Gson gson = new Gson();
    	
    	WebhookEvent event = gson.fromJson("/dest/restoutput.json", WebhookEvent.class);
    	
    	System.out.println(event);
	}
}
