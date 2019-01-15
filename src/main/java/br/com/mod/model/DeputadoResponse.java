package br.com.mod.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.mod.bean.DeputadoSimples;
import br.com.mod.bean.Link;

public class DeputadoResponse {
	
	private List<DeputadoSimples> dados;
	private List<Link> links;
	
	public DeputadoResponse() {
		dados = new ArrayList<>();
		links =  new ArrayList<>();
	}

	DeputadoResponse(List<DeputadoSimples> dados, List<Link> links) {
		super();
		this.dados = dados;
		this.links = links;
	}

	public List<DeputadoSimples> getDados() {
		return dados;
	}

	public void setDados(List<DeputadoSimples> dados) {
		this.dados = dados;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	
	public int next(){
		return this.getPage("next");
	}
	
	public int previous(){
		return this.getPage("self")-1;
	}
	
	public int last(){
		return this.getPage("last");
	}
	
	public int first(){
		return this.getPage("first");
	}
	
	public int current(){
		return this.getPage("self");
	}
	
	private int getPage(String labelLink){
		int page = 0;
		
		for(Link link : this.getLinks()){
			if(link.getRel().equals(labelLink)){
				Pattern p = Pattern.compile("pagina=(.*)$");
				Matcher m = p.matcher(link.getHref());
				if(m.find()){					
					page = Integer.parseInt(m.group(1).substring(0, m.group(1).indexOf("&")));
				}				
			}
		}
		return page;
	}
	
	public int getIdLegislatura(){
		int legislatura = 0;
		if(this.getDados().size() > 0){
			legislatura = this.getDados().get(1).getIdLegislatura();
		}
		return legislatura;
	}
	

}
