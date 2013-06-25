package oAuth2Http;

/**
 * Pelo fato dos m�todos put e deletar lan�arem exe��o foi criada esta classe.
 * Por quest�es de simplicidade as exe��es citadas foram centralizadas aqui.
 * @author Leonardo
 *
 */
@SuppressWarnings("serial")
public class ExcecaoDuplaDelEPut extends RuntimeException {

	//private static final long serialVersionUID = 1L;
	private int codigoDoStatus;

	public ExcecaoDuplaDelEPut(String erro, int codigoDoStatus){
		super(erro);
		this.codigoDoStatus = codigoDoStatus;
	}

	public int getCodigoDoStatus(){
		return this.codigoDoStatus;
	}

}