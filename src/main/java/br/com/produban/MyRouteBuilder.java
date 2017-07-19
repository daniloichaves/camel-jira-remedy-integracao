package br.com.produban;

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
    	
//    	create a process with exchange
//    	from("direct:test").convertBodyTo(String.class)
//      .to("file:dest?fileName=restoutput.json").process(new Processor(){
//    	  public void process(Exchange exchange) throws Exception {
////    		  	String body = exchange.getIn().getBody().toString();
//    		  
//    	    	Gson gson = new Gson();
//    	    	String path = new File(".").getCanonicalPath();
//    	    	WebhookEvent event = gson.fromJson(new FileReader(path + "/dest/restoutput.json"), WebhookEvent.class);
//    	    	
//    	    	System.out.println(event.getWebhookEvent());
//    	  }
//      });
    	
//    	Call an existent process
    	from("direct:test").convertBodyTo(String.class)
    	.choice()
    		.when(body().startsWith("<")).log("xml")
    		.when(body().startsWith("{")).to("file:dest?fileName=restoutput.json").process(new MyProcessor())
    		.otherwise().log("erro")
    	.end();
    	
//    	Gson gson = new Gson();
//    	
//    	WebhookEvent webhookEvent = gson.fromJson(new FileReader("/dest/restoutput.json"), WebhookEvent.class);
//    	System.out.println(webhookEvent.getWebhookEvent());
    	
    }

}
