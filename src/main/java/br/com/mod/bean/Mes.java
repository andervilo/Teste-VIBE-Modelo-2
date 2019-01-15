package br.com.mod.bean;

import java.util.ArrayList;
import java.util.List;

public class Mes {
	
	private int numero;
	private String nome;
	private double total;
	private List<Despesa> despesasMes;
	
	public Mes(int numero, String nome, double total, List<Despesa> despesasMes) {
		this.numero = numero;
		this.nome = nome;
		this.total = total;
		//this.despesasMes = new ArrayList<>();
		this.despesasMes = despesasMes;
	}

	public Mes() {
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Despesa> getDespesasMes() {
		return despesasMes;
	}

	public void setDespesasMes(List<Despesa> despesasMes) {
		this.despesasMes = despesasMes;
	}
	
	

}
