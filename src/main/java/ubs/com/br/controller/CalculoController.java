package ubs.com.br.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import ubs.com.br.domain.Product;
import ubs.com.br.services.ServiceResponse;

@Api(value = "pessoa", tags = "pessoa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {
		@ApiResponse(code = org.apache.http.HttpStatus.SC_BAD_REQUEST, message = "Quando a operação retornar '400 - Bad Request' será apresentado no corpo do "
				+ "retorno o JSON abaixo com as mensagens de negócio apresentadas no campo \"messages\".", response = ServiceResponse.class),
		@ApiResponse(code = org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR, message = "Quando a operação retornar '500 - Internal Server Error' será apresentado no corpo do "
				+ "retorno o JSON abaixo com as mensagens de negócio apresentadas no campo \"messages\".", response = ServiceResponse.class) })

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class CalculoController {

	@ApiOperation(value = "Método responsável por retornar uma lista de Pessoas.", nickname = "ListarPessoa")

	@ApiResponses(value = {
			@ApiResponse(code = org.apache.http.HttpStatus.SC_OK, message = "Quando a operação ocorrer com sucesso será apresentado no corpo do "
					+ "retorno o JSON abaixo com as mensagens de negócio apresentadas no campo \"messages\".") })
	@GetMapping("/exemplo/{product}")
	public ResponseEntity<ServiceResponse<Product>> getAllEmployees(
			@PathVariable(name = "product", required = true) String product) {

		log.debug("Sigla emissor: {}", "Teste");

		final ServiceResponse<Product> serviceResponse = null; // this.pessoaService.consultar(siglaEmissor, cnpjCpf);

		return new ResponseEntity<>(serviceResponse, HttpHeaders.EMPTY, serviceResponse.getStatus());
	}
}
