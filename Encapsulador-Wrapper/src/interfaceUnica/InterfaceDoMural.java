package interfaceUnica;

import java.util.List;

/**
 * Interface com os métodos para o Mural
 * @author Leonardo
 *
 * @param <R> -> Parâmetro desta interface, a qual, refere-se ao status: Log, Help, 
 * Activity, Answer.
 */
public interface InterfaceDoMural <R> {


	/**
	 * Método que cria status tipo Answer em relação Activity ou Help e só para eles.
	 * Onde é necessário um texto (vide parâmetro) também relacionado a Activity ou 
	 * Help. Segundo regras do Redu, tamanho máximo requerido de 800 caracteres.
	 * @param idDoStatus
	 * @param texto
	 * @return objeto do tipo T
	 */
	public R postResposta(String idDoStatus, String texto);

	/**
	 * Método para os tipos Activity e Help. Recupera respostas do status.
	 * @param idDoStatus
	 * @return lista do tipo T
	 */
	public List <R> getResposta(String idDoStatus);

	/**
	 * Método que cria status tipo Activity no Mural do usuário segundo o id passado.
	 * O status no pode exceder os 800 caracteres.
	 * @param idDoUsuario
	 * @param status
	 * @return objeto do tipo T
	 */
	public R postStatusDoUsuario(String idDoUsuario, String status);

	/**
	 * Recupera os status(es) referente ao usuário. Entretanto se o tipo não for 
	 * especificado, Activity, Log do usuário e Help são recuperados. Pagina possui 
	 * mínimo um de entradas e máximo de 25.
	 * @param idDoUsuario
	 * @param tipo
	 * @param pagina
	 * @return lista do tipo T
	 */
	public List <R> getStatusesPorUsuario(String idDoUsuario, String tipo, String pagina);

	/**
	 * Método que cria status, limitado a 800 caracteres, no mural da disciplina 
	 * especificada no parâmetro correspondente.
	 * @param idDoEspaco
	 * @param status
	 * @return objeto do tipo T
	 */
	public R postStatusDoEspaco(String idDoEspaco, String texto);

	/**
	 * Recupera os status do mural referente a disciplina em questão. A informação 
	 * recuperada está presa à disciplina. Pode sofrer seleção pelo tipo Activity, 
	 * Log ou Help. O parâmetro pagina possui limite mínimo 1 entrada e máximo de 25.
	 * @param idDoEspaco - ID do space
	 * @param tipo
	 * @param pagina
	 * @return lista do tipo T
	 */

	public List <R> getStatusPorEspaco(String idDoEspaco, String tipo, String pagina);

	/**
	 * Método que cria um status, limitado a 800 caracteres, no Mural da aula. Porém, 
	 * nesse caso em específico está autorizada a criação de um Help.
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
	 * Recupera os status(es) referentes ao usuário. Este método mostras as ações 
	 * interessantes ao usuário semelhante à pàgina inicial do Redu. Existe a 
	 * possibilidade de escolher o tipo, recuperando Activity, Log e Help se não 
	 * especificado tipo.
	 * @param idDoEspaco
	 * @param tipo
	 * @param pagina
	 * @return lista do tipo T
	 */

	public List <R> getStatusesLinhaTempoPorUsuario(String idDoEspaco, String tipo, String pagina);

	/**
	 * Recupera os status da disciplina visitada acrescido de suas respectivas aulas.
	 * Semelhante ao mural da disciplina, pode sofrer seleção pelo tipo Activity, Log 
	 * ou Help. O parâmetro pagina possui limite mínimo 1 entrada e máximo de 25.
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
	 * Deleta status pelo id informado no parâmetro.
	 * @param idDoStatus
	 */
	public void delStatus(String idDoStatus);
}
