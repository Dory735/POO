package tp3.example.tp3.controller;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;

import aj.org.objectweb.asm.Type;
import tp3.example.tp3.model.AddressRepository;
import tp3.example.tp3.model.Foo;
import tp3.example.tp3.model.Meteo;
import tp3.example.tp3.model.Features;

@Controller
public class MeteoController {
	
	RestTemplate template;
	
	public MeteoController(RestTemplate rt) {
		template = rt;
	}
	@PostMapping("/meteo")
	public String showMeteo( HttpServletRequest request,Model model) throws RestClientException {
		String content=request.getParameter("address");
		String adress_parts=content.replaceAll("\\s","+");
		model.addAttribute("address", content);
		String url="https://api-adresse.data.gouv.fr/search/?q="+adress_parts;

		
		model.addAttribute("url",url);
		Foo foo=template.getForObject(url, Foo.class);
		model.addAttribute("foo",foo);
		System.out.println(foo.getType());
		System.out.println(foo.getFeatures()[0].getProperties().getLabel());
		for(int i=0;i<foo.getFeatures().length;i++){
		 	System.out.println(foo.getFeatures()[i].getProperties().getLabel());
		 }
		//String result=restTemplate.getForObject(url,String.class);
		
		//curl 'https://api-adresse.data.gouv.fr/search/?q=10&type=housenumber&autocomplete=1'
		//curl 'https://api-adresse.data.gouv.fr/search/?q=10%20rue%201700%20La%20Rochelle&type=housenumber&autocomplete=1'
		
		return "meteo";
	}
	

}
