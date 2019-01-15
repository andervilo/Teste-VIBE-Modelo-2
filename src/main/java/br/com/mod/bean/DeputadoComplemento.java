package br.com.mod.bean;

public class DeputadoComplemento {
	private String nomeCivil;
    private String dataNascimento;
    private String sexo;
    
    public DeputadoComplemento() {
	}

	public DeputadoComplemento(String nomeCivil, String dataNascimento, String sexo) {
		this.nomeCivil = nomeCivil;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

	public String getNomeCivil() {
		return nomeCivil;
	}

	public void setNomeCivil(String nomeCivil) {
		this.nomeCivil = nomeCivil;
	}

	public String getDataNascimento() {
		return dataNascimento;
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

	@Override
	public String toString() {
		return "DeputadoComplemento [nomeCivil=" + nomeCivil + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
				+ "]";
	}
    
    
}
