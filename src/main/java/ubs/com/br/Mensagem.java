package ubs.com.br;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public enum Mensagem {


	    /**
	     * Mensagem utilizada quando comando realizado com sucesso para alteração, inativação, ativação e consulta.
	     */
	    SUCESSO("0", "Operação realizada com sucesso.", HttpStatus.OK);

	
	    @Getter
	    private final String codigo;

	    @Getter
	    private String descricao;

	    @Getter
	    private final HttpStatus httpStatus;

	    /**
	     * Constrói o objeto Mensagem com um código e uma descrição.
	     * 
	     * @param codigo
	     *          String - Código da mensagem.
	     * 
	     * @param descricao
	     *          String - Descrição da mensagem.
	     */
	    Mensagem(final String codigo, final String descricao, final HttpStatus httpStatus) {
	        this.codigo = codigo;
	        this.descricao = descricao;
	        this.httpStatus = httpStatus;
	    }

	    /**
	     * Metodo responsavel por receber a mensagem e trocar por valores passados.
	     * 
	     * @param params
	     *          String... - parametros para realizar troca da referência por valor.
	     * 
	     * @return String
	     *          Texto do enum de mensagem, com os devidos replaces.
	     */
	    public String show(String... params) {
	        Integer i = 0;
	        String retorno = this.descricao;

	        for (String param : params) {
	            retorno = retorno.replace("${" + i + "}", param);
	            i += 1;
	        }

	        return retorno;
	    }

	    /**
	     * Método responsavel por receber a mensagem e trocar por valores passados,
	     * concatenando com o código da Mensagem.
	     * 
	     * @param params
	     *            String... - parâmetros para realizar troca da referência por
	     *            valor.
	     * 
	     * @return Texto com os replaces, concatenado com o código de erro.
	     */
	    public String showCode(String... params) {
	        final String delimitador = "||";

	        return this.codigo + delimitador + this.show(params);
	    }
	    
	    /**
	     * Método para recupear o HttpStatus correspondente a mensagem.
	     * 
	     * @param code String do codigo de negócio da mensagem.
	     * 
	     * @return HttpStatus encontrado.
	     */
	    public static HttpStatus getStatus(String code) {
	        for (Mensagem item : values()) {
	            if (item.codigo.equalsIgnoreCase(code)) {
	                return item.getHttpStatus();
	            }
	        }
	        return HttpStatus.OK;
	    }

}
