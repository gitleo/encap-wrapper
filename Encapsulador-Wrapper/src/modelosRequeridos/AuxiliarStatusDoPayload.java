package modelosRequeridos;

/**
 * Classe cria apenas para auxiliar a classe StatusPayload.
 * @author Leonardo
 *
 */
public class AuxiliarStatusDoPayload {

	public String texto;
	public String tipo;

	/**
	 * Construtor que guarda o texto criado pelo primeiro construtor do StatusPayload.
	 * @param texto
	 */
	public AuxiliarStatusDoPayload(String texto){
		this.texto = texto;
	}

	/**
	 * Construtor que guarda o texto e o tipo criados pelo segundo construtor do 
	 * StatusPayload.
	 * @param texto
	 * @param tipo
	 */
	public AuxiliarStatusDoPayload(String texto, String tipo){
		this.texto = texto;
		this.tipo = tipo;
	}

}