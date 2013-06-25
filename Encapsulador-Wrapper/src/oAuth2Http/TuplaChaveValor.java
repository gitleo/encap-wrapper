package oAuth2Http;

import java.util.Map;

/**
 * Para a manipulal��o do par chave-valor foi escolhido implementar a interface
 * Map.Entry<String,String> formando um ente da matem�tica conhecido como tupla.
 * Neste caso, mais especificamente, um 2-tupla.
 * @author Leonardo
 *
 */
public final class TuplaChaveValor implements Map.Entry<String, String> {

	private final String chave;
	private String valor;

	/**
	 * Construtor que ao inicializar um objeto do tipo TuplaChaveValor
	 * solicita uma chave e um valor.
	 * @param chave
	 * @param valor
	 */
	public TuplaChaveValor(String chave, String valor) {
		this.chave = chave;
		this.valor = valor;
	}

	/**
	 * M�todo privado criado para auxiliar o m�todo setValue.
	 * @param novoValor
	 * @return valorAntigo
	 */
	private String atualizaValor(String novoValor) {
		String valorAntigo = this.valor;
		this.valor = novoValor;
		return valorAntigo;
	}

	/**
	 * M�todo que atualiza o valor no atributo de mesmo nome.
	 * Em seguida retorna o valor antigo.
	 */
	@Override
	public String setValue(String valor) {
		return this.atualizaValor(valor);
	}

	/**
	 * M�todo que recupera a chave.
	 */
	@Override
	public String getKey() {
		return this.chave;
	}

	/**
	 * M�todo que recupera o valor.
	 */
	@Override
	public String getValue() {
		return this.valor;
	}

	@Override
	public String toString(){
		return ("(" + this.chave + ": " + this.valor + ")");
	}

}