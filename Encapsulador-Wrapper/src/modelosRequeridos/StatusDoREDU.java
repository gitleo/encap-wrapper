package modelosRequeridos;

import java.util.List;

/**
 * Como o próprio nome já diz, esta classe se refere aos itens mostrados no mural do Redu. Ou como na primeira 
 * parte do nome o status.
 * @author Leonardo
 *
 */
public class StatusDoREDU {

	public int id;
	public String tipo;
	public String criadoA;
	public String texto;
	public UsuarioDoREDU usuario;
	public List<LinkRedu> links;

	/**
	 * Construtor default.
	 */
	public StatusDoREDU() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString(){
		String str1 = "id: " + this.id;
		String str2 = "type: " + this.tipo;
		String str3 = "created_at: " + this.criadoA;
		String str4 = "text: " + this.texto;
		String str5 = "user: " + this.usuario;
		String str6 = "links: " + this.links;
		return str1 + "\n" + str2 + "\n" + str3 + "\n" + str4 + "\n" + str5 + "\n" + str6;
	}

}