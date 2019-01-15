package br.com.mod.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.mod.model.DespesaResponse;

public class RepositoryDespesas {
RestTemplate restTemplate = new RestTemplate();
	
	public DespesaResponse getDespesas(int ano, int mes, int idDeputado, int idLegislatura){
		//
		int itens = 100;
		String url = "https://dadosabertos.camara.leg.br/api/v2/deputados/"+idDeputado+
				     "/despesas?idLegislatura="+idLegislatura+
				     "&ano="+ano+
				     "&mes="+mes+
				     "&itens="+itens+
				     "&ordem=ASC&ordenarPor=mes";
		
		ResponseEntity<DespesaResponse> response = restTemplate.exchange(
		  url,
		  HttpMethod.GET,
		  null,
		  new ParameterizedTypeReference<DespesaResponse>(){});
		DespesaResponse despesaResponse = response.getBody();
		return despesaResponse;
		
	}
	
	public DespesaResponse getDespesas(int idDeputado, int idLegislatura, int page){
		//
		int itens = 100;
		String url = "https://dadosabertos.camara.leg.br/api/v2/deputados/"+idDeputado+
				     "/despesas?idLegislatura="+idLegislatura+
				     "&itens="+itens+
				     "&pagina="+page+
				     "&ordem=ASC&ordenarPor=mes";
		
		ResponseEntity<DespesaResponse> response = restTemplate.exchange(
		  url,
		  HttpMethod.GET,
		  null,
		  new ParameterizedTypeReference<DespesaResponse>(){});
		DespesaResponse despesaResponse = response.getBody();
		return despesaResponse;
		
	}
	
	
	public DespesaResponse getDespesasAno(int idDeputado, int idLegislatura, int page, int ano){
		//
		int itens = 100;
		DespesaResponse despesaResponse = null;
		String url = "https://dadosabertos.camara.leg.br/api/v2/deputados/"+idDeputado+"/despesas?"+
				     "ano="+ano+
				     "&itens="+itens+
				     "&pagina="+page;
		ResponseEntity<DespesaResponse> response = restTemplate.getForEntity(url, DespesaResponse.class);
		if(response.getStatusCodeValue() == 200){
			despesaResponse = response.getBody();
		}
		System.out.println("Chamou: "+idDeputado);	
		return despesaResponse;
		
	}
	
	public DespesaResponse getDespesasMes(int idDeputado, int idLegislatura, int page, int mes, int ano){
		//
		int itens = 100;
		DespesaResponse despesaResponse = null;
		String url = "https://dadosabertos.camara.leg.br/api/v2/deputados/"+idDeputado+"/despesas?"+
				     "mes="+mes+
				     "&ano="+ano+
				     "&itens="+itens+
				     "&pagina="+page;
		ResponseEntity<DespesaResponse> response = restTemplate.getForEntity(url, DespesaResponse.class);
		if(response.getStatusCodeValue() == 200){
			despesaResponse = response.getBody();
		}
			
		return despesaResponse;
		
	}

}
