package br.com.mod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mod.model.DeputadoResponse;
import br.com.mod.service.DeputadoService;

@Controller
@RequestMapping("deputados")
public class ListDeputadosController {
	
	@Autowired
	private DeputadoService dsr;
	private DeputadoResponse dpr = null;
	
	
	@GetMapping("/{pagina}")
	
	public ModelAndView listDeputados(@PathVariable("pagina") Integer pagina) throws InterruptedException{
		if(pagina == null || pagina == 0){
			pagina = 1;
		}
		this.dpr = dsr.getDeputados(pagina);
		//this.dpr = rld.getDeputados(pagina);
		ModelAndView mv = new ModelAndView("list_deputados");
		mv.addObject("deputados", dpr.getDados());
		
		mv.addObject("first", this.dpr.first());
		mv.addObject("current", this.dpr.current());
		mv.addObject("next", this.dpr.next());
		mv.addObject("previous", this.dpr.previous());
		mv.addObject("last", this.dpr.last());
		
		return mv;
	}
	
	@GetMapping
	//@Cacheable("deputados")
	public ModelAndView listDeputados() throws InterruptedException{
		//this.dpr = rld.getDeputados(1);
		this.dpr = dsr.getDeputados(1);
		ModelAndView mv = new ModelAndView("list_deputados");
		mv.addObject("deputados", dpr.getDados());
		
		mv.addObject("first", this.dpr.first());
		mv.addObject("current", this.dpr.current());
		mv.addObject("next", this.dpr.next());
		mv.addObject("previous", this.dpr.previous());
		mv.addObject("last", this.dpr.last());
		
		
		return mv;
	}
	
	@GetMapping("/despesa/{idDeputado}")
	public ModelAndView despesa(@PathVariable("idDeputado") Integer idDeputado) throws InterruptedException{
		this.dpr = dsr.getDespesaMes(idDeputado);
		ModelAndView mv = new ModelAndView("detalha_despesa");
		mv.addObject("deputado", this.dpr.getDados().get(0));
		
		return mv;
	}

}
