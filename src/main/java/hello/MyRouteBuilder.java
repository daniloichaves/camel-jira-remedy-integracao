package hello;

import java.io.FileReader;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

// Example to copy a file into dest/ folder
//        from("file:src/data?noop=true")
//        	.process(Utils.javascript("convert.js"))
//        	.log("${body}").to("file:dest");
    	
// Setting a local server to listen
    	from("jetty:http://localhost:9000/api/camel").to("direct:test");
    	
    	
    	from("direct:test").convertBodyTo(String.class)
      .to("file:dest?fileName=restoutput-${date:now:yyyyMMdd_HHmmss_SSS}.json");
    	
//    	Gson gson = new Gson();
//    	
//    	WebhookEvent webhookEvent = gson.fromJson(new FileReader("/dest/restoutput.json"), WebhookEvent.class);
//    	System.out.println(webhookEvent.getWebhookEvent());
    	
    }

}
