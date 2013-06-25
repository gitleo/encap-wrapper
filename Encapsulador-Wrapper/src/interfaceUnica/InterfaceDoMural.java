package interfaceUnica;

import java.util.List;

/**
 * Interface com os m�todos para o Mural
 * @author Leonardo
 *
 * @param <R> -> Par�metro desta interface, a qual, refere-se ao status: Log, Help, 
 * Activity, Answer.
 */
public interface InterfaceDoMural <R> {


	/**
	 * M�todo que cria status tipo Answer em rela��o Activity ou Help e s� para eles.
	 * Onde � necess�rio um texto (vide par�metro) tamb�m relacionado a Activity ou 
	 * Help. Segundo regras do Redu, tamanho m�ximo requerido de 800 caracteres.
	 * @param idDoStatus
	 * @param texto
	 * @return objeto do tipo T
	 */
	public R postResposta(String idDoStatus, String texto);

	/**
	 * M�todo para os tipos Activity e Help. Recupera respostas do status.
	 * @param idDoStatus
	 * @return lista do tipo T
	 */
	public List <R> getResposta(String idDoStatus);

	/**
	 * M�todo que cria status tipo Activity no Mural do usu�rio segundo o id passado.
	 * O status no pode exceder os 800 caracteres.
	 * @param idDoUsuario
	 * @param status
	 * @return objeto do tipo T
	 */
	public R postStatusDoUsuario(String idDoUsuario, String status);

	/**
	 * Recupera os status(es) referente ao usu�rio. Entretanto se o tipo n�o for 
	 * especificado, Activity, Log do usu�rio e Help s�o recuperados. Pagina possui 
	 * m�nimo um de entradas e m�ximo de 25.
	 * @param idDoUsuario
	 * @param tipo
	 * @param pagina
	 * @return lista do tipo T
	 */
	public List <R> getStatusesPorUsuario(String idDoUsuario, String tipo, String pagina);

	/**
	 * M�todo que cria status, limitado a 800 caracteres, no mural da disciplina 
	 * especificada no par�metro correspondente.
	 * @param idDoEspaco
	 * @param status
	 * @return objeto do tipo T
	 */
	public R postStatusDoEspaco(String idDoEspaco, String texto);

	/**
	 * Recupera os status do mural referente a disciplina em quest�o. A informa��o 
	 * recuperada est� presa � disciplina. Pode sofrer sele��o pelo tipo Activity, 
	 * Log ou Help. O par�metro pagina possui limite m�nimo 1 entrada e m�ximo de 25.
	 * @param idDoEspaco - ID do space
	 * @param tipo
	 * @param pagina
	 * @return lista do tipo T
	 */

	public List <R> getStatusPorEspaco(String idDoEspaco, String tipo, String pagina);

	/**
	 * M�todo que cria um status, limitado a 800 caracteres, no Mural da aula. Por�m, 
	 * nesse caso em espec�fico est� autorizada a cria��o de um Help.
	 * @param idDaAula
	 * @param status
	 * @param tipo
	 * @return objeto do tipo T
	 */
	public R postStatusDaAula(String idDaAula, String status, String tipo);

	/**
	 * Recupera uma lista com os status do mural da aula (lecture) segundo o id da mesma. 
	 * @param idDaAula
	 * @return lista do tipo T
	 */
	public List<R> getStatusesPorAula(String idDaAula);

	/**
	 * Recupera os status(es) referentes ao usu�rio. Este m�todo mostras as a��es 
	 * interessantes ao usu�rio semelhante � p�gina inicial do Redu. Existe a 
	 * possibilidade de escolher o tipo, recuperando Activity, Log e Help se n�o 
	 * especificado tipo.
	 * @param idDoEspaco
	 * @param tipo
	 * @param pagina
	 * @return lista do tipo T
	 */

	public List <R> getStatusesLinhaTempoPorUsuario(String idDoEspaco, String tipo, String pagina);

	/**
	 * Recupera os status da disciplina visitada acrescido de suas respectivas aulas.
	 * Semelhante ao mural da disciplina, pode sofrer sele��o pelo tipo Activity, Log 
	 * ou Help. O par�metro pagina possui limite m�nimo 1 entrada e m�ximo de 25.
	 * @param idDoEspaco - ID do space
	 * @param tipo
	 * @param pagina
	 * @return lista do tipo T
	 */
	public List <R> getStatusesLinhaTempoPorEspaco(String idDoEspaco, String tipo, String pagina);

	/**
	 * Recupera o status do ID passado como argumento.
	 * @param idDoStatus
	 * @return objeto do tipo T
	 */
	public R getStatus(String idDoStatus);

	/**
	 * Deleta status pelo id informado no par�metro.
	 * @param idDoStatus
	 */
	public void delStatus(String idDoStatus);
}
