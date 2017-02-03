/**
 * 
 */
package br.com.makersweb.vinhos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.makersweb.vinhos.enums.TipoVinho;
import br.com.makersweb.vinhos.model.Vinho;
import br.com.makersweb.vinhos.repository.IVinhosRepository;

/**
 * @author andersonorionearistides
 */
@Controller
public class VinhosController {
	
	@Autowired
	private IVinhosRepository vinhoRepository;
	
	@GetMapping("/vinhos/novo")
	public ModelAndView novo(Vinho vinho) {
		ModelAndView mav = new ModelAndView("vinho/cadastro-vinho");
		mav.addObject("tipos", TipoVinho.values());
		return mav;
	}
	
	@PostMapping("/vinhos/novo")
	public ModelAndView salvar(@Valid Vinho vinho, BindingResult result) {
		if (result.hasErrors()) {
			return novo(vinho);
		}
		vinhoRepository.save(vinho);
		return new ModelAndView("redirect:/vinhos/novo");
	}

}
