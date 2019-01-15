package br.com.mod.repository;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.mod.model.DepCompResponse;
import br.com.mod.model.DeputadoResponse;
import br.com.mod.model.DespesaResponse;

public class RepositoryListDeputados {
	RestTemplate restTemplate = new RestTemplate();
	
	
	public DeputadoResponse getDeputados(int pagina) throws InterruptedException{
		int itens = 5;
		String url = "https://dadosabertos.camara.leg.br/api/v2/deputados?&pagina="+pagina+"&itens="+itens+"&ordem=ASC&ordenarPor=nome";
		DeputadoResponse deputadoResponse = null;
				
		ResponseEntity<DeputadoResponse> response = restTemplate.getForEntity(url, DeputadoResponse.class);
		
		if(response.getStatusCodeValue() == 200){
			deputadoResponse = response.getBody();
			deputadoResponse.getDados().forEach((dep)-> dep.setTotalDespesas());
		}
				
		return deputadoResponse;
		
	}
	
	public DeputadoResponse getDeputado(int idDeputado) throws InterruptedException{
		String url = "https://dadosabertos.camara.leg.br/api/v2/deputados?id="+idDeputado;
		DeputadoResponse deputadoResponse = null;
				
		ResponseEntity<DeputadoResponse> response = restTemplate.getForEntity(url, DeputadoResponse.class);
		
		if(response.getStatusCodeValue() == 200){
			deputadoResponse = response.getBody();
			deputadoResponse.getDados().forEach((dep)-> dep.setDespesasMeses());
		}
				
		return deputadoResponse;
		
	}
	
	public DepCompResponse getDeputadoComplemento(int idDeputado) throws InterruptedException{
		String url = "https://dadosabertos.camara.leg.br/api/v2/deputados/"+idDeputado;
		DepCompResponse deputadoResponse = null;
				
		ResponseEntity<DepCompResponse> response = restTemplate.getForEntity(url, DepCompResponse.class);
		
		if(response.getStatusCodeValue() == 200){
			deputadoResponse = response.getBody();
		}
				
		return deputadoResponse;
		
	}
}
