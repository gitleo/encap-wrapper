package modelosRequeridos;

/**
 * Classe simples com apenas dois construtores para definir as possibilidades de 
 * um objeto deste tipo.
 * @author Leonardo
 *
 */
public class StatusDoPayload {

	public AuxiliarStatusDoPayload auxiliarStatus;

	/**
	 * Primeira possibilidade de construtor. Este recebe apenas o texto.
	 * @param texto
	 */
	public StatusDoPayload(String texto){
		this.auxiliarStatus = new AuxiliarStatusDoPayload(texto);
	}

	/**
	 * Segunda possibilidade de construtor. Recebe o texto seguido do tipo.
	 * @param texto
	 * @param tipo
	 */
	public StatusDoPayload(String texto, String tipo){
		this.auxiliarStatus = new AuxiliarStatusDoPayload(texto, tipo);
	}

}