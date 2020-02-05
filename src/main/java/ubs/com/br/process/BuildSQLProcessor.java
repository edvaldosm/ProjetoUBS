package ubs.com.br.process;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import ubs.com.br.domain.Product;

@Component
@Slf4j
public class BuildSQLProcessor implements Processor {
	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {				
		exchange.getIn().setBody(gerarSQL(gerarObj((LinkedHashMap<String, Object>) exchange.getIn().getBody())));
		
	}

	private Product gerarObj(LinkedHashMap<String, Object> obj) {
		Product p = Product.builder()
				.product((String)obj.get("product"))
				.quantity((Integer)obj.get("quantity"))
				.price(obj.get("price") == null?new BigDecimal("0"): new BigDecimal(((String)obj.get("price")).replace("$", "")))
				.type((String)obj.get("type"))
				.industry((String)obj.get("industry"))
				.origin((String)obj.get("origin"))
				.build();
		return p;
	}
	

	private String gerarSQL (Product product) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO public.\"Product\" ");
		sb.append("(product, quantity, price, type, industry, origin)");
		sb.append("VALUES('"+product.getProduct()+ "', ");
		sb.append(product.getQuantity()+", ");
		sb.append(product.getPrice() + ", ");
		sb.append("'" +product.getType() + "', ");
		sb.append("'" +product.getIndustry() + "', ");
		sb.append("'" +product.getOrigin() + "')");

		log.info("Valor do exchange: -> " + sb.toString());
		return sb.toString();
	}

}