package ubs.com.br.domain;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

	private Integer id;
	private String product;
	private Integer quantity;
	private BigDecimal price;
	private String type;
	private String industry;
	private String origin;

}
