package br.com.mod.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.mod.bean.DeputadoComplemento;
import br.com.mod.model.DeputadoResponse;
import br.com.mod.repository.RepositoryListDeputados;

@Service
public class DeputadoService {
	
	private RepositoryListDeputados rld;
	private DeputadoResponse dpr;
	
	public DeputadoService() {
		this.rld = new RepositoryListDeputados();
		this.dpr = new DeputadoResponse();
	}
	
	@Cacheable("deputados")
	public DeputadoResponse getDeputados(int page) throws InterruptedException{
		this.dpr = this.rld.getDeputados(page);	
		return this.dpr;
		
	}
	
	@Cacheable("despesas")
	public DeputadoResponse getDespesaMes(int idDeputado) throws InterruptedException{
		DeputadoComplemento dc = this.getDeputadoComplemento(idDeputado);
		this.dpr = this.rld.getDeputado(idDeputado);		
		this.dpr.getDados().get(0).setNomeCivil(dc.getNomeCivil());
		this.dpr.getDados().get(0).setSexo(dc.getSexo());;
		this.dpr.getDados().get(0).setDataNascimento(dc.getDataNascimento());
		return this.dpr;
	}
	
	private DeputadoComplemento getDeputadoComplemento(int idDeputado) throws InterruptedException{
		return this.rld.getDeputadoComplemento(idDeputado).getDados();
		
	}

}
