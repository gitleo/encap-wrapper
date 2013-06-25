package oAuth2Http;

/**
 * Pelo fato dos métodos put e deletar lançarem exeção foi criada esta classe.
 * Por questões de simplicidade as exeções citadas foram centralizadas aqui.
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