package br.com.produban.test;

import org.apache.camel.builder.RouteBuilder;
import org.junit.Test;

import br.com.produban.MyProcessor;

public class ProcessorTest extends RouteBuilder{

	@Test
	public void configure() throws Exception {
		// TODO Auto-generated method stub	  	
    	from("{\"timestamp\":1499797498920,\"webhookEvent\":\"jira:issue_updated\"}").convertBodyTo(String.class)
    	.choice()
    		.when(body().startsWith("<")).log("xml")
    		.when(body().startsWith("{")).to("file:dest?fileName=restoutput.json").process(new MyProcessor())
    		.otherwise().log("erro")
    	.end();    	
  }
};