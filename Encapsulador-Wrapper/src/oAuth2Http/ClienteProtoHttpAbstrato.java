package oAuth2Http;

import java.util.Map;

/**
 * Classe com caracter�stica abstrata, justamente, para gerar uma abstra��o da classe que 
 * a implementa.
 * @author Leonardo
 *
 */
public abstract class ClienteProtoHttpAbstrato {

	private String chaveConsumidora;
	private String consumidorSecreto;

	/**
	 * Construtor da classe abstrata. Associa os atributos chaveConsumidora e 
	 * consumidorSecreto aos seus respectivos par�metros.
	 * @param chaveConsumidora
	 * @param consumidorSecreto
	 */
	public ClienteProtoHttpAbstrato(String chaveConsumidora, String consumidorSecreto){
		this.chaveConsumidora = chaveConsumidora;
		this.consumidorSecreto = consumidorSecreto;
	}
	
	/**
	 * M�todo get que retorna a chave consumidora.
	 * @return String - chaveConsumidora
	 */
	public String getChaveConsumidora() {
		return this.chaveConsumidora;
	}
	
	/**
	 * M�todo get que retorna o consumidor secreto.
	 * @return String - consumidorSecreto
	 */
	public String getConsumidorSecreto(){
		return this.consumidorSecreto;
	}
	//As retic�ncias representam um array de par�metros opcionais

	public abstract void iniciaCliente(String sequenciaPin);

	public abstract String getUrlDoAuth();
	
	/* 
	 * Os m�todos que se seguem a partir daqui possuem, em seus par�metros, alguns 
	 * obrigat�rios e outros opcionais, ficando claro o motivo das retic�ncias
	 * 
	 */

	public abstract void put(String url, byte[] payload,  Map.Entry<String, String>... parametros);

	public abstract String get(String url, Map.Entry<String, String>... parametros);

	public abstract void deletar(String url, Map.Entry<String, String>... parametros);

	/* Este m�todo post dispensa o payload dando mais op��es na hora da implementa��o */
	public abstract String post(String url,Map.Entry<String, String>... parametros);

	/* Este, ao contr�rio do anterior, torna o acr�scimo do payload obrigat�rio */
	public abstract String post(String url, byte[] payload, Map.Entry<String, String>... parametros);

}
