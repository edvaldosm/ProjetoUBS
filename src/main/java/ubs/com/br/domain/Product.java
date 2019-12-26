package ubs.com.br.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private Integer id;
	private String product;
	private Integer quantity;
	private BigDecimal price;
	private String type;
	private String industry;
	private String origin;

}
