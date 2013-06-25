package Fachada;

import interfaceUnica.InterfaceDoMural;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import oAuth2Http.ClienteProtoHttpAbstrato;
import oAuth2Http.ClienteProtoHttpConcreto;
import oAuth2Http.TuplaChaveValor;

import modelosRequeridos.StatusDoREDU;
import modelosRequeridos.StatusDoPayload;
import modelosRequeridos.UsuarioDoREDU;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * Classe principal do projeto. É através desta que se utiliza as implementações feitas ao longo do 
 * Encapsulador/Wrapper. Na verdade, trata-se de uma classe concreta (parametrizada) que implementa a 
 * interface chamada InterfaceDoMural. Explicação sobre ela na própria interface. 
 * @author Leonardo
 *
 * @param <R> -> Parâmetro desta classe, a qual, refere-se ao status: Log, Help, Activity, Answer. 
 */
public class FachadaDoREDU <R> implements InterfaceDoMural <R> {

	@SuppressWarnings("unchecked")
	protected Class<R> objStatus = (Class<R>) StatusDoREDU.class;
	protected Type ListaDoStatus = new TypeToken<List<StatusDoREDU>>() {}.getType();	

	@SuppressWarnings("unchecked")
	private Class<R> usuario = (Class<R>) UsuarioDoREDU.class;
	private ClienteProtoHttpAbstrato cliente; // inicializado no construtor
	private final String URL_REDU = "http://www.redu.com.br/api/";
	private Gson objGson;

	/**
	 * Construtor da classe FachadaDoREDU que necessita do pin.
	 * @param chaveConsumidora
	 * @param consumidorSecreto
	 * @param SequenciaPin
	 */
	public FachadaDoREDU(String chaveConsumidora, String consumidorSecreto, String SequenciaPin) {
		this.cliente = new ClienteProtoHttpConcreto(chaveConsumidora, consumidorSecreto, SequenciaPin);
		this.objGson = new Gson();
	}

	/**
	 * Construtor da classe FachadaDoREDU, porém, este não requer o pin.
	 * @param chaveConsumidora
	 * @param chaveScreta
	 */
	public FachadaDoREDU(String chaveConsumidora, String chaveScreta) {
		this.cliente = new ClienteProtoHttpConcreto(chaveConsumidora, chaveScreta);
		this.objGson = new Gson();
	}

	/**
	 * Método get para recuperar url de autorização.
	 * @param inexistente
	 * @return String
	 */
	public String getUrlDeAutorização(){
		return this.cliente.getUrlDoAuth();
	}

	/**
	 * Método para inicializar o cliente.
	 * @param pin
	 * @return inexistente
	 */
	public void iniciaCliente(String pin){
		this.cliente.iniciaCliente(pin);
	}

	/**
	 * Método para dar post.
	 * @param url
	 * @param classeDeTipoT
	 * @param payload
	 * @param args
	 * @return objeto do tipo R
	 */
	@SuppressWarnings("hiding")
	private <R> R postUrl(String url, Class<R> classeDeTipoT, String payload, Map.Entry<String, String>... args){
		return this.objGson.fromJson(this.cliente.post(url, payload.getBytes(), args), classeDeTipoT);
	}

	/**
	 * Recupera informações do usuário
	 * @param inexistente
	 * @return objeto do tipo R
	 */
	public R getEu() {
		return this.getUrl(this.URL_REDU + "me", this.usuario);
	}

	/* Métodos para obter a url onde ocorre variação de parâmetros */

	/**
	 * Método (um) que recupera a url. Veja quantidade de parâmetros.
	 * @param url
	 * @param classeDeTipoT
	 * @return objeto do tipo T
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	private <R> R getUrl(String url, Class<R> classeDeTipoT){
		return this.objGson.fromJson(this.cliente.get(url), classeDeTipoT);
	}

	/**
	 * Método (dois) que recupera a url. Veja quantidade de parâmetros.
	 * @param url
	 * @param classeDeTipoT
	 * @param args
	 * @return objeto do tipo T
	 */
	@SuppressWarnings({ "unused", "hiding" })
	private <R> R getUrl(String url, Class<R> classeDeTipoT, Map.Entry<String, String>... args){
		return this.objGson.fromJson(this.cliente.get(url, args), classeDeTipoT);
	}

	/**
	 * Método (três) que recupera a url. Veja quantidade de parâmetros.
	 * @param url
	 * @param tipoDeT
	 * @param mapE
	 * @return
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	private <R> R getUrl(String url, Type tipoDeT, Map.Entry<String, String>... mapE){
		List <Map.Entry<String, String>> novos = new ArrayList<Map.Entry<String, String>>();
		for(Map.Entry<String, String> m : mapE){
			if(m.getValue() != null){ novos.add(m); }
		}
		String json = new String();
		if(novos.isEmpty()){
			json = this.cliente.get(url);
		}else{
			json = this.cliente.get(url, novos.toArray(new TuplaChaveValor[mapE.length]));
		}
		return this.objGson.fromJson(json, tipoDeT);
	}

	/**
	 * Método (quatro) que recupera a url. Veja quantidade de parâmetros.
	 * @param url
	 * @param tipoDeT
	 * @return
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	private <R> R getUrl(String url, Type tipoDeT){
		return this.objGson.fromJson(this.cliente.get(url), tipoDeT);
	}

	/*************************
	 * Segue abaixo as implementações da interface que esta classe implementa. Funcões relativas ao Mural.
	 * Métodos implementados na mesma ordem em que aparecem na respectiva interface.
	 * @see interfaceUnica.InterfaceDoMural#getStatus(java.lang.String)
	 *************************/

	@SuppressWarnings("unchecked")
	@Override
	public R postResposta(String idDoStatus, String texto) {
		String url = this.URL_REDU + "statuses/" + idDoStatus + "/answers";
		return this.postUrl(url, this.objStatus, this.objGson.toJson(new StatusDoPayload(texto)));
	}

	@Override
	public List <R> getResposta(String idDoStatus) {
		return this.getUrl(this.URL_REDU + "statuses/" + idDoStatus + "/answers", this.ListaDoStatus);
	}

	@SuppressWarnings("unchecked")
	@Override
	public R postStatusDoUsuario(String idDoUsuario, String status) {
		return this.postUrl(this.URL_REDU + "users/" + idDoUsuario + "/statuses", this.objStatus, 
				this.objGson.toJson(new StatusDoPayload(status)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List <R> getStatusesPorUsuario(String idDoUsuario, String tipo, String pagina) {
		return this.getUrl(this.URL_REDU + "users/" + idDoUsuario + "/statuses", this.ListaDoStatus, 
				new TuplaChaveValor("type", tipo), new TuplaChaveValor("page", pagina));
	}

	@SuppressWarnings("unchecked")
	@Override
	public R postStatusDoEspaco(String idDoEspaco, String texto) {
		return this.postUrl(this.URL_REDU + "spaces/" + idDoEspaco + "/statuses", this.objStatus, 
				this.objGson.toJson(new StatusDoPayload(texto)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List <R> getStatusPorEspaco(String idDoEspaco, String tipo, String pagina) {
		return this.getUrl(this.URL_REDU + "spaces/" + idDoEspaco + "/statuses", this.ListaDoStatus, 
				new TuplaChaveValor("type", tipo), new TuplaChaveValor("page", pagina));
	}

	@SuppressWarnings("unchecked")
	@Override
	public R postStatusDaAula(String idDaAula, String status, String tipo) {
		return this.postUrl(this.URL_REDU + "lectures/" + idDaAula + "/statuses", this.objStatus, 
				this.objGson.toJson(new StatusDoPayload(status, tipo)));
	}
	
	@Override
	public List <R> getStatusesPorAula(String idDaAula) {
		return this.getUrl(this.URL_REDU + "lectures/" + idDaAula + "/statuses", this.ListaDoStatus);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List <R> getStatusesLinhaTempoPorUsuario(String idDoEspaco, String tipo, String pagina) {
		return this.getUrl(this.URL_REDU + "users/" + idDoEspaco + "/statuses/timeline", this.ListaDoStatus, 
				new TuplaChaveValor("type", tipo), new TuplaChaveValor("page", String.valueOf(pagina)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List <R> getStatusesLinhaTempoPorEspaco(String idDoEspaco, String tipo, String pagina) {
		return this.getUrl(this.URL_REDU + "spaces/" + idDoEspaco + "/statuses/timeline", this.ListaDoStatus, 
				new TuplaChaveValor("type", tipo), new TuplaChaveValor("page", pagina));
		
	}

	@Override
	public R getStatus(String idDoStatus) {
		return this.getUrl(this.URL_REDU + "statuses/" + idDoStatus, this.objStatus);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delStatus(String idDoStatus) {
		this.cliente.deletar(this.URL_REDU + "statuses/" + idDoStatus);
	}

}