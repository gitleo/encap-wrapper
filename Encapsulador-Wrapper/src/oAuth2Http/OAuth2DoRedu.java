package oAuth2Http;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Verb;
import org.scribe.utils.OAuthEncoder;

/**
 * Com o intuito de construir de construir os serviços referentes ao OAuthService é que 
 * esta classe foi criada.
 * @author Leonardo
 *
 */
public class OAuth2DoRedu extends DefaultApi20 {

	private String URL_REDU_CODIGO_AUTORIZACAO = "http://redu.com.br/oauth/token?grant_type=authorization_code";
	private static final String URL_REDU_DE_AUTORIZACAO = "http://www.redu.com.br/oauth/authorize?client_id=%s";

	/**
	 * Construtor default sem parâmetros.
	 */
	public OAuth2DoRedu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AccessTokenExtractor getAccessTokenExtractor() {
		JsonTokenExtractor jsonExtractor = new JsonTokenExtractor();
		return jsonExtractor;
	}

	@Override
	public Verb getAccessTokenVerb() {
		Verb verb = Verb.POST;
		return verb;
	}

	@Override
	public String getAuthorizationUrl(OAuthConfig configuracaoOAuth) {
		return String.format(URL_REDU_DE_AUTORIZACAO, 
				configuracaoOAuth.getApiKey(),
				OAuthEncoder.encode(configuracaoOAuth.getCallback())
				);
	}

	@Override
	public String getAccessTokenEndpoint() {
		return this.URL_REDU_CODIGO_AUTORIZACAO;
	}

}