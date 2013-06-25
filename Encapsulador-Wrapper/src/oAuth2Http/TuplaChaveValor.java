package oAuth2Http;

import java.util.Map;

/**
 * Para a manipulalção do par chave-valor foi escolhido implementar a interface
 * Map.Entry<String,String> formando um ente da matemática conhecido como tupla.
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
	 * Método privado criado para auxiliar o método setValue.
	 * @param novoValor
	 * @return valorAntigo
	 */
	private String atualizaValor(String novoValor) {
		String valorAntigo = this.valor;
		this.valor = novoValor;
		return valorAntigo;
	}

	/**
	 * Método que atualiza o valor no atributo de mesmo nome.
	 * Em seguida retorna o valor antigo.
	 */
	@Override
	public String setValue(String valor) {
		return this.atualizaValor(valor);
	}

	/**
	 * Método que recupera a chave.
	 */
	@Override
	public String getKey() {
		return this.chave;
	}

	/**
	 * Método que recupera o valor.
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