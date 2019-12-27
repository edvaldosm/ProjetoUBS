package ubs.com.br.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import ubs.com.br.domain.Product;

@Component
@Slf4j
public class BuildSQLProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		
		Product p = (Product)exchange.getIn().getBody();
		log.info("Valor do exchange: -> " +p.toString());
		

	}

}
