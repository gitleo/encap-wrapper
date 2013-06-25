package oAuth2Http;

import java.util.Map;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * Classe que possui métodos além dos extendidos da classe ClienteProtoHttp.
 * Dentre suas funcionalidades está o serviço de protocolo de autenticação.
 * @author Leonardo
 *
 */
public class ClienteProtoHttpConcreto extends ClienteProtoHttpAbstrato {

	private Token tokenDeAcesso;
	private OAuthService servicoDoOAuth;

	/**
	 * Construtor que através da palavra reservada super se usa do construtor
	 * da classe ClienteProtoHttpAbstrato e, que torna necessário
	 * o acréscimo do pin.
	 * @param chaveConsumidora
	 * @param consumidorSecreto
	 * @param sequenciaPin
	 */
	public ClienteProtoHttpConcreto(String chaveConsumidora, String consumidorSecreto, String sequenciaPin){
		super(chaveConsumidora, consumidorSecreto);
		this.inicializaOServicoOAuth();
		this.tokenDeAcesso = this.servicoDoOAuth.getAccessToken(null, new Verifier(sequenciaPin));
	}

	/**
	 * Construtor que através da palavra reservada super se usa do construtor
	 * da classe ClienteProtoHttpAbstrato. Dispensa o pin.
	 * @param chaveConsumidora
	 * @param consumidorSecreto
	 */
	public ClienteProtoHttpConcreto(String chaveConsumidora, String consumidorSecreto){
		super(chaveConsumidora, consumidorSecreto);
		this.inicializaOServicoOAuth();

	}

	@Override
	public void iniciaCliente(String sequenciaPin) {
		this.tokenDeAcesso = this.servicoDoOAuth.getAccessToken(null, new Verifier(sequenciaPin));
	}

	@Override
	public String getUrlDoAuth() {
		return this.servicoDoOAuth.getAuthorizationUrl(null);
	}

	@Override
	public void put(String url, byte[] payload, Map.Entry<String, String>... parametros) {
		OAuthRequest requisicao = new OAuthRequest(Verb.PUT, url);
		if(parametros != null){
			/* Trecho que preenche o body com seus parâmetros necessessários */
			for(Map.Entry<String, String> doisTupla : parametros){
				requisicao.addBodyParameter(doisTupla.getKey(), doisTupla.getValue());
			}
		}
		requisicao.addPayload(payload);
		requisicao.addHeader("Content-Type", "application/json");
		this.servicoDoOAuth.signRequest(this.tokenDeAcesso, requisicao);
		if(requisicao.send().getCode() != 200){
			throw new ExcecaoDuplaDelEPut("Código de Retorno Inválido", requisicao.send().getCode());
		}
	}

	@Override
	public String get(String url, Map.Entry<String, String>... parametros) {
		Response resposta = null;
		String respostaFinal = new String();

		try{
			OAuthRequest requisicao = new OAuthRequest(Verb.GET, url);
			if(parametros != null){
				/* Este trecho de código preenche os parâmetros da url */
				for (Map.Entry<String, String> doisTupla : parametros){
					requisicao.addQuerystringParameter(doisTupla.getKey(), doisTupla.getValue());
				}
			}
			this.servicoDoOAuth.signRequest(this.tokenDeAcesso, requisicao);
			resposta = requisicao.send();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		respostaFinal = resposta.getBody();
		return respostaFinal;
	}

	@Override
	public void deletar(String url, Map.Entry<String, String>... parametros) {
		OAuthRequest requisicao = new OAuthRequest(Verb.DELETE, url);
		if(parametros != null){
			/* Este trecho de código preenche os parâmetros da url */
			for (Map.Entry<String, String> pair : parametros){
				requisicao.addQuerystringParameter(pair.getKey(), pair.getValue());
			}
		}
		this.servicoDoOAuth.signRequest(this.tokenDeAcesso, requisicao);
		if (requisicao.send().getCode() != 200){
			throw new ExcecaoDuplaDelEPut("Código Retornado Inválido", requisicao.send().getCode());
		}
	}

	@Override
	public String post(String url, Map.Entry<String, String>... parametros) {
		Response resposta = null;
		String respostaFinal = new String();
		try{
			OAuthRequest requisicao = new OAuthRequest(Verb.POST, url);
			if(parametros != null){
				/* Trecho que preenche o body com seus parâmetros necessessários */
				for(Map.Entry<String, String> doisTupla : parametros){
					requisicao.addBodyParameter(doisTupla.getKey(), doisTupla.getValue());
				}
			}
			this.servicoDoOAuth.signRequest(this.tokenDeAcesso, requisicao);
			resposta = requisicao.send();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		respostaFinal = resposta.getBody(); 
		return  respostaFinal;
	}

	@Override
	public String post(String url, byte[] payload, Map.Entry<String, String>... parametros) {
		Response resposta = null;
		String respostaFinal = new String();
		try{
			OAuthRequest requisicao = new OAuthRequest(Verb.POST, url);
			if(parametros != null){
				/* Trecho que preenche o body com seus parâmetros necessessários */
				for(Map.Entry<String, String> doisTupla : parametros){
					requisicao.addBodyParameter(doisTupla.getKey(), doisTupla.getValue());
				}
			}
			requisicao.addPayload(payload);
			requisicao.addHeader("Content-Type", "application/json");
			this.servicoDoOAuth.signRequest(this.tokenDeAcesso, requisicao);
			resposta = requisicao.send();
		}catch(Exception e){
			e.printStackTrace();
		}
		respostaFinal = resposta.getBody();
		return respostaFinal;
	}

	/** 
	 * Este atributo, ao contrário do tokenDeAcesso, aparece nos dois construtores
	 * o que tornou viável a ciração deste método privado.
	 * Serve para inicializa o serviço do Auth.
	 */
	private void inicializaOServicoOAuth(){
		this.servicoDoOAuth = new ServiceBuilder().provider(OAuth2DoRedu.class)
				.apiKey(this.getChaveConsumidora())
				.apiSecret(this.getConsumidorSecreto())
				.callback("").build();

	}

}