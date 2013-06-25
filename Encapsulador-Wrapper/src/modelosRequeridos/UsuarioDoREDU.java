package modelosRequeridos;

import java.util.List;

/**
 * Segundo o nome da classe, descreve um usuário da plataforma Redu. Não possui todos os 
 * itens possíveis, pois visa seguir a especificação do projeto.
 * @author Leonardo
 *
 */
public class UsuarioDoREDU {

    public String logIn;
    public String celular;
    public String eMail;
    public String localizacao;
    public int quantosAmigos;
    public int id;
    public String primeiroNome;
    public String ultimoNome;
    public String aniversario;
    public String localDeNascimento;
    public List<LinkRedu> links;
    
    /**
     * Construtor default
     */
    public UsuarioDoREDU() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public String toString(){
        String str1 = "login: " + this.logIn;
        String str2 = "mobile: " + this.celular;
        String str3 = "email: " + this.eMail;
        String str4 = "localization: " + this.localizacao;
        String str5 = "friends_count: " + this.quantosAmigos;
        String str6 = "id: " + this.id;
        String str7 = "first_name: " + this.primeiroNome;
        String str8 = "last_name: " + this.ultimoNome;
        String str9 = "birthday: " + this.aniversario;
        String str10 = "birth_localization: " + this.localDeNascimento;
        String str11 = "links: " + this.links;
        return (str1 + "\n" + str2 + "\n" + str3 + "\n" + str4 + "\n" + str5 + "\n" + str6 + "\n" + str7
        		+ "\n" + str8 + "\n" + str9 + "\n" + str10 + "\n" + str11);
    }

}
