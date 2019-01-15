package br.com.mod.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.com.mod.bean.Despesa;
import br.com.mod.bean.Mes;
import br.com.mod.repository.RepositoryDespesas;
import br.com.mod.utils.MesDescricao;

public class ProcessaDespesas {
	
	private int idDeputado;
	private int idLegislatura;
	private int ano;
	private int mes;
	private RepositoryDespesas repodesp;
	
	public ProcessaDespesas() {
		this.repodesp = new RepositoryDespesas();
	}

	public ProcessaDespesas(int idDeputado, int idLegislatura, int ano) {
		this.idDeputado = idDeputado;
		this.idLegislatura = idLegislatura;
		this.ano = ano;
		this.repodesp = new RepositoryDespesas();
	}
	
	public ProcessaDespesas(int idDeputado, int idLegislatura, int ano, int mes) {
		this.idDeputado = idDeputado;
		this.idLegislatura = idLegislatura;
		this.ano = ano;
		this.mes = mes;
		this.repodesp = new RepositoryDespesas();
	}
	
	public ProcessaDespesas(int idDeputado, int idLegislatura) {
		this.idDeputado = idDeputado;
		this.idLegislatura = idLegislatura;
		this.repodesp = new RepositoryDespesas();
	}

	public int getIdDeputado() {
		return idDeputado;
	}

	public void setIdDeputado(int idDeputado) {
		this.idDeputado = idDeputado;
	}

	public int getIdLegislatura() {
		return idLegislatura;
	}

	public void setIdLegislatura(int idLegislatura) {
		this.idLegislatura = idLegislatura;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public double getTotalDespesas(){
		double total = 0.0;
		int total_pages = this.repodesp.getDespesasAno(idDeputado, idLegislatura, 1, 2018).last();
		List<Despesa> despesas = new ArrayList<>();
		List<Integer> range = IntStream.rangeClosed(1, total_pages).boxed().collect(Collectors.toList());
		
		range.forEach((page)-> despesas.addAll(this.repodesp.getDespesasAno(this.idDeputado, this.idLegislatura, page, 2018).getDados()));
		
		total = this.somaDespesas(despesas);
		return total;
	}
	
	public List<Mes> getTotalDespesasMes(){
		
		List<Mes> meses = new ArrayList<>();
		List<Integer> listMeses = IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toList());		
		
		listMeses.forEach((mes) -> {
			int total_pages = this.repodesp.getDespesasMes(idDeputado, idLegislatura, 1, mes, 2018).last();				
			List<Integer> range = IntStream.rangeClosed(1, total_pages).boxed().collect(Collectors.toList());
			double total = 0.0;
			List<Despesa> despesas = new ArrayList<>();
			range.forEach((page)-> despesas.addAll(this.repodesp.getDespesasMes(this.idDeputado, this.idLegislatura, page, mes, 2018).getDados()));
			total = this.somaDespesas(despesas);
			System.out.println(MesDescricao.values()[mes-1].toString() + ": " + despesas.size());
			meses.add(new Mes(mes, MesDescricao.values()[mes-1].toString(), total, despesas));				
		});		
		
		return meses;
	}
	
	
	
	private double somaDespesas(List<Despesa> list){
		double total = 0.0;
		
		total = list.stream().mapToDouble(o -> o.getValorLiquido()).sum();
		
		return total;
	}
	
	/*List<Integer> streamRange(int from, int limit) {
	    return IntStream.range(from, from+limit)
	            .boxed()
	            .collect(toList());
	}*/

}








