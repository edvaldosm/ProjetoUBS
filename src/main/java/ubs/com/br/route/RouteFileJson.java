package ubs.com.br.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RouteFileJson extends RouteBuilder {

	@Autowired
	Environment environment;

	@Override
	public void configure() throws Exception {
		log.info("Start the Camel Route");
        
		from("{{startRoute}}").log("Execução");
		
	}

}
