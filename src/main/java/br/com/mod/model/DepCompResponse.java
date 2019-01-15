package br.com.mod.model;


import br.com.mod.bean.DeputadoComplemento;

public class DepCompResponse {
	
	private DeputadoComplemento dados;
	
	public DepCompResponse() {
	}

	DepCompResponse(DeputadoComplemento dados) {
		this.dados = dados;
	}

	public DeputadoComplemento getDados() {
		return dados;
	}

	public void setDados(DeputadoComplemento dados) {
		this.dados = dados;
	}
	

}
