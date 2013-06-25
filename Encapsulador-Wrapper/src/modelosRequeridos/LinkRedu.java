package modelosRequeridos;

/**
 * Semelhante ao funcionamento das páginas da internet, o Redu possui referências (links) que apontam para
 * os demais recursos que dispõe. O principal objetivo dessa classe é gerar abstração das urls usadas pelas 
 * futuras aplicações. Não será necessários que elas saibam sobre as urls existentes.
 * As urls ficam disponíneis pela propriedade 'links'.
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