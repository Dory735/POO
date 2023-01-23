package tp3.example.tp3.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import tp3.example.tp3.model.AddressRepository;
import tp3.example.tp3.model.Meteo;

@Controller

public class FormController {
	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping("/adresse")
	public String showForm(Model model) {
	//model.addAttribute("allAddresses", addressRepository.findAll());
	return "addresse";
	}
	

}
