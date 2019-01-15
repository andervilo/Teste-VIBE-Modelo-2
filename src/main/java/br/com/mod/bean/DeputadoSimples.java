package br.com.mod.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import br.com.mod.model.ProcessaDespesas;

public class DeputadoSimples implements Serializable{
	private int id;
	private String uri;
	private String nome;
	private String siglaPartido;
	private String uriPartido;
	private String siglaUf;
    private int idLegislatura;
    private String urlFoto;
    private ProcessaDespesas procDesp;
    private double totalDespesas;
    private List<Mes> despesasMeses;
    private String nomeCivil;
    private String dataNascimento;
    private String sexo;
    
    
    public DeputadoSimples() {
	}

	public DeputadoSimples(int id, String uri, String nome, String siglaPartido, String uriPartido, String siglaUf,
			int idLegislatura, String urlFoto, String nomeCivil, String dataNascimento, String sexo ) {
		super();
		this.id = id;
		this.uri = uri;
		this.nome = nome;
		this.siglaPartido = siglaPartido;
		this.uriPartido = uriPartido;
		this.siglaUf = siglaUf;
		this.idLegislatura = idLegislatura;
		this.urlFoto = urlFoto;
		
		this.nomeCivil = nomeCivil;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSiglaPartido() {
		return siglaPartido;
	}

	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
	}

	public String getUriPartido() {
		return uriPartido;
	}

	public void setUriPartido(String uriPartido) {
		this.uriPartido = uriPartido;
	}

	public String getSiglaUf() {
		return siglaUf;
	}

	public void setSiglaUf(String siglaUf) {
		this.siglaUf = siglaUf;
	}

	public int getIdLegislatura() {
		return idLegislatura;
	}

	public void setIdLegislatura(int idLegislatura) {
		this.idLegislatura = idLegislatura;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	@Override
	public String toString() {
		return "DeputadoSimples [id=" + id + ", uri=" + uri + ", nome=" + nome + ", siglaPartido=" + siglaPartido
				+ ", uriPartido=" + uriPartido + ", siglaUf=" + siglaUf + ", idLegislatura=" + idLegislatura
				+ ", urlFoto=" + urlFoto + "]";
	}
	
	public double setTotalDespesas(){
		this.procDesp = new ProcessaDespesas(this.id, this.idLegislatura);
		this.totalDespesas = this.procDesp.getTotalDespesas();
		return this.totalDespesas;
	}
	
	public double getTotalDespesas(){
		return this.totalDespesas;
	}
	
	public void setDespesasMeses(){
		this.procDesp = new ProcessaDespesas(this.id, this.idLegislatura);
		this.despesasMeses = this.procDesp.getTotalDespesasMes();
	}

	public List<Mes> getDespesasMeses() {
		return this.despesasMeses;
	}

	public String getNomeCivil() {
		return nomeCivil;
	}

	public void setNomeCivil(String nomeCivil) {
		this.nomeCivil = nomeCivil;
	}

	public String getDataNascimento() {
		LocalDate data = LocalDate.parse(this.dataNascimento);
		return data.getDayOfMonth()+"/"+data.getMonthValue()+"/"+data.getYear();
	}

	public void setDataNascimento(String dataNascimento) {
		
		
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
    
}
