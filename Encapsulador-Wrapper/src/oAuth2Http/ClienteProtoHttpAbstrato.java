package oAuth2Http;

import java.util.Map;

/**
 * Classe com característica abstrata, justamente, para gerar uma abstração da classe que 
 * a implementa.
 * @author Leonardo
 *
 */
public abstract class ClienteProtoHttpAbstrato {

	private String chaveConsumidora;
	private String consumidorSecreto;

	/**
	 * Construtor da classe abstrata. Associa os atributos chaveConsumidora e 
	 * consumidorSecreto aos seus respectivos parâmetros.
	 * @param chaveConsumidora
	 * @param consumidorSecreto
	 */
	public ClienteProtoHttpAbstrato(String chaveConsumidora, String consumidorSecreto){
		this.chaveConsumidora = chaveConsumidora;
		this.consumidorSecreto = consumidorSecreto;
	}
	
	/**
	 * Método get que retorna a chave consumidora.
	 * @return String - chaveConsumidora
	 */
	public String getChaveConsumidora() {
		return this.chaveConsumidora;
	}
	
	/**
	 * Método get que retorna o consumidor secreto.
	 * @return String - consumidorSecreto
	 */
	public String getConsumidorSecreto(){
		return this.consumidorSecreto;
	}
	//As reticências representam um array de parâmetros opcionais

	public abstract void iniciaCliente(String sequenciaPin);

	public abstract String getUrlDoAuth();
	
	/* 
	 * Os métodos que se seguem a partir daqui possuem, em seus parâmetros, alguns 
	 * obrigatórios e outros opcionais, ficando claro o motivo das reticências
	 * 
	 */

	public abstract void put(String url, byte[] payload,  Map.Entry<String, String>... parametros);

	public abstract String get(String url, Map.Entry<String, String>... parametros);

	public abstract void deletar(String url, Map.Entry<String, String>... parametros);

	/* Este método post dispensa o payload dando mais opções na hora da implementação */
	public abstract String post(String url,Map.Entry<String, String>... parametros);

	/* Este, ao contrário do anterior, torna o acréscimo do payload obrigatório */
	public abstract String post(String url, byte[] payload, Map.Entry<String, String>... parametros);

}
