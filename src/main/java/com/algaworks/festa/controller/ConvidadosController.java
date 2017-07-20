package com.algaworks.festa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.model.ConvidadoView;
import com.algaworks.festa.model.Pesquisa;
import com.algaworks.festa.repository.Convidados;

//Classe com @Controller indicando que é um controlador no Spring Boot.

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	//@Autowired que serve para dar o New do objeto, instanciar.
	
	@Autowired
	private Convidados convidados;	
	
	//Anotação @GetMapping indica mapeamento da URL -> http://www.blablabla.com /convidados
	
	@GetMapping
	public ModelAndView listar(@ModelAttribute("pesquisa") Pesquisa pesquisa) {	
		String pesquisado;

		if(pesquisa.getPalavra()==null){
			pesquisado = "%";
		}else{
			pesquisado = pesquisa.getPalavra();
		}
		List<Convidado> ListaConvidados = convidados.findByNomeContaining(pesquisado);
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject(new ConvidadoView());
		modelAndView.addObject("convidados", ListaConvidados);
		return modelAndView;	
	}
	
	
	@PostMapping
	public String salvar(ConvidadoView convidadoView) {
		Convidado convidado = new Convidado(convidadoView.getNome(),Integer.parseInt(convidadoView.getNum()));
		this.convidados.save(convidado);
		return "redirect:/convidados";
	}
	
	
	
	
	
	
}
