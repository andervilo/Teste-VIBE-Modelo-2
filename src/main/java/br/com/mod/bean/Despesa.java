package br.com.mod.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class Despesa implements Serializable{	
	private String tipoDespesa;
	private String tipoDocumento;
	private String dataDocumento;
	private double valorLiquido;
	
	Despesa() {
	}

	public Despesa(String tipoDespesa, String tipoDocumento, String dataDocumento, double valorLiquido) {
		this.tipoDespesa = tipoDespesa;
		this.tipoDocumento = tipoDocumento;
		this.dataDocumento = dataDocumento;
		this.valorLiquido = valorLiquido;
	}

	public String getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDataDocumento() {
		
		return dataDocumento;
	}

	public void setDataDocumento(String dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	@Override
	public String toString() {
		return "Despesa [tipoDespesa=" + tipoDespesa + ", tipoDocumento=" + tipoDocumento + ", dataDocumento="
				+ dataDocumento + ", valorLiquido=" + valorLiquido + "]";
	}
	
	 
	
	

}
