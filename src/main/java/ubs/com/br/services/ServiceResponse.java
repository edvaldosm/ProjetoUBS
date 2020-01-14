package ubs.com.br.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import springfox.documentation.annotations.ApiIgnore;
	/**
	 * Objeto genérico responsável pelo encapsulamento de retorno do serviço.
	 * Possui um objeto genérico e uma lista de mensagens de retono.
	 * 
	 * @author Verity
	 *
	 * @param <T>
	 *          Object - Objeto genérico a ser retornado pelo serviço.
	 */
	@EqualsAndHashCode
	@ToString
	public class ServiceResponse<T extends Object> {

	    private static final String MESSAGE_DELIMITER = "||";

	    @Getter
	    @Setter
	    private T result;

	    @JsonProperty("messages")
	    private List<Message> messages = new ArrayList<>();

	    @JsonIgnore
	    @Setter
	    private HttpStatus status;

	    /**
	     * Classe para retorno de code e mensagem.
	     * 
	     * @author Verity
	     *
	     */
	    @Data
	    @AllArgsConstructor
	    private class Message {
	        private String code;
	        private String description;
	    }

	    /**
	     * Retorna todas as mensagens.
	     * 
	     * @return List Message
	     */
	    @ApiIgnore
	    @JsonIgnore
	    public List<Message> getAll() {
	        return this.messages;
	    }

	    /**
	     * Verifica se a mensagem esta vazia.
	     * 
	     * @return Boolean
	     */
	    @ApiIgnore
	    @JsonIgnore
	    public Boolean isEmpty() {
	        return this.messages.isEmpty();
	    }

	    /**
	     * Adiciona uma mensagem através de objeto Mensagem.
	     * 
	     * @param mensagemCalculo
	     *          Mensagem - Objeto conténdo o código e a descrição de retorno.
	     * 
	     * @see Mensagem
	     */
	    public void addMessage(final Mensagem mensagemCalculo) {
	        this.addMessage(mensagemCalculo.getCodigo(), mensagemCalculo.getDescricao());
	        this.status = mensagemCalculo.getHttpStatus();
	    }

	    /**
	     * Adiciona uma mensagem através de mensagem detalhada.
	     * 
	     * @param message
	     *          String - Mensagem detalhada de retorno do serviço, contendo o código e a descrição,
	     *          separados por um delimitador.
	     */
	    public void addMessage(final String message) {
	        final String[] toSplit = StringUtils.split(message, MESSAGE_DELIMITER);

	        if (!StringUtils.isEmpty(toSplit)) {
	            this.addMessage(toSplit[0], toSplit[1]);
	        }
	        else {
	            //Se o separador não foi encontrado então não é possível encontrar o código.
	            this.addMessage(null, message);
	        }
	    }

	    /**
	     * Adiciona uma mensagem através de mensagem detalhada.
	     * 
	     * @param code
	     *          String - Código de retorno do serviço.
	     * 
	     * @param description
	     *          String - Descrição de retorno do serviço.
	     */
	    public void addMessage(final String code, final String description) {
	        this.messages.add(new Message(code, description));
	        if (Objects.isNull(code)) {
	            this.status = HttpStatus.INTERNAL_SERVER_ERROR;
	        }
	        else {
	            this.status = Mensagem.getStatus(code);
	        }
	    }

	    @ApiIgnore
	    @JsonIgnore
	    public HttpStatus getStatus() {
	        return status;
	    }
}
