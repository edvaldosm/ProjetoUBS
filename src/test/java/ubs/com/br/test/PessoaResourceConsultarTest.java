package ubs.com.br.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ubs.com.br.Mensagem;
import ubs.com.br.controller.CalculoController;
import ubs.com.br.services.ServiceResponse;

public class PessoaResourceConsultarTest {

}

/*
 * @RunWith(SpringRunner.class)
 * 
 * @WebMvcTest(CalculoController.class) public class PessoaResourceConsultarTest
 * extends PessoaTestBase {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean private PessoaService pessoaService;
 * 
 *//**
	 * Inicialização dos objetos.
	 */
/*
 * @Before public void setUp() { this.gerarMapper(); this.gerarPessoa();
 * this.gerarPessoaFisica(); }
 * 
 *//**
	 * Teste do consultar pessoa com sucesso.
	 * 
	 * @throws Exception - Utilizada para capturar exceções.
	 * 
	 */
/*
 * @Test public void consultar_pessoa_sucesso() throws Exception { final
 * ServiceResponse<Pessoa> serviceResponse = new ServiceResponse<>();
 * serviceResponse.addMessage(Mensagem.SUCESSO);
 * serviceResponse.setResult(getPessoa());
 * serviceResponse.setStatus(HttpStatus.OK);
 * 
 * Mockito.when(this.pessoaService.consultar(super.getPessoaFisica().
 * getSiglaEmissor(), super.getPessoaFisica().getCnpjCpf()))
 * .thenReturn(serviceResponse);
 * 
 * this.mockMvc .perform(get(URL_CAMINHO_PESSOA_RECURSO,
 * super.getPessoaFisica().getCnpjCpf()) .header(AUTH, TOKEN)
 * .header(CAMPO_SIGLA_EMISSOR,
 * super.getPessoaFisica().getSiglaEmissor())).andExpect(status().isOk()); }
 * 
 *//**
	 * Teste do consultar pessoa com falha.
	 * 
	 * @throws Exception - Utilizada para capturar exceções.
	 * 
	 */
/*
 * @Test public void consultar_erro_silga_invalida() throws Exception {
 * 
 * this.mockMvc.perform(get(URL_CAMINHO_PESSOA_RECURSO,
 * super.getPessoaFisica().getCnpjCpf()) .header(AUTH, TOKEN)
 * .header(CAMPO_SIGLA_EMISSOR,
 * VL_SIGLA_EMISSOR_INVALIDO)).andExpect(status().isBadRequest()); }
 * 
 *//**
	 * Teste do consultar pessoa com falha.
	 * 
	 * @throws Exception - Utilizada para capturar exceções.
	 * 
	 *//*
		 * @Test public void consultar_erro_cnpjCpf_invalido() throws Exception {
		 * 
		 * this.mockMvc.perform(get(URL_CAMINHO_PESSOA_RECURSO, "4555491408023")
		 * .header(AUTH, TOKEN) .header(CAMPO_SIGLA_EMISSOR,
		 * VL_SIGLA_EMISSOR)).andExpect(status().isBadRequest()); }
		 * 
		 * }
		 */