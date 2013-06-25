package modelosRequeridos;

/**
 * Semelhante ao funcionamento das p�ginas da internet, o Redu possui refer�ncias (links) que apontam para
 * os demais recursos que disp�e. O principal objetivo dessa classe � gerar abstra��o das urls usadas pelas 
 * futuras aplica��es. N�o ser� necess�rios que elas saibam sobre as urls existentes.
 * As urls ficam dispon�neis pela propriedade 'links'.
 * @author Leonardo
 *
 */
public class LinkRedu {

	public String rel;
	public String href;

	/**
	 * Construtor default.
	 */
	public LinkRedu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString(){
		String str1 = "rel: " + this.rel;
		String str2 = " href: " + this.href;
		return (str1 + "\n" + str2);
	}

}