package ubs.com.br.route;

import javax.sql.DataSource;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.ExpressionBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import ubs.com.br.process.BuildSQLProcessor;
import ubs.com.br.route.exceptions.DataException;

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

		onException(DataException.class).log(LoggingLevel.ERROR, "DataException in the route ${body}");
		
		from("timer:lerJson?period=10s")
			.log("Timer Invoked and the body - " + environment.getProperty("message"))
			.pollEnrich("file:data/input?delete=true&readLock=none&moveFailed=error")
			.split(ExpressionBuilder.languageExpression("jsonpath", "$"))
				.process(buildSQLProcessor)
				.to("jdbc:dataSource")
				.log("${body}")
				.end()
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
