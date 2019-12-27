package ubs.com.br.route;

import javax.sql.DataSource;

import org.apache.camel.builder.ExpressionBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;
import ubs.com.br.domain.Product;
import ubs.com.br.process.BuildSQLProcessor;

@Component
@Slf4j
public class RouteFileJson extends RouteBuilder {

	@Autowired
	Environment environment;

	@Qualifier("DSPostgres")
	@Autowired
	DataSource dataSource;

    @Autowired
    BuildSQLProcessor buildSQLProcessor;
    
	@Override
	public void configure() throws Exception {
		log.info("Start the Camel Route");

		// JSON Data Format
		JacksonDataFormat jdf = new JacksonDataFormat(Product.class);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
		mapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, true);
		jdf.setObjectMapper(mapper);
		
	
		from("timer:lerJson?period=10s")
		  .log("Timer Invoked and the body - " + environment.getProperty("message"))
		  .pollEnrich("file:data/input?delete=true&readLock=none&moveFailed=error")
		  .split(ExpressionBuilder.languageExpression("jsonpath","$"))
		  		.convertBodyTo(String.class)
		  		.unmarshal(jdf)
		  		.process(buildSQLProcessor)
		  .log("Execução")
		  .to("file:data/output");
		 

		/*
		 * from("timer:lerJson?period=10s") .log("Timer Invoked and the body - " +
		 * environment.getProperty("message"))
		 * .pollEnrich("file:data/input?delete=true&readLock=none&moveFailed=error")
		 * .to("direct:result");
		 */
	}

}
