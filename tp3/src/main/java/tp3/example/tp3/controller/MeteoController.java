package tp3.example.tp3.controller;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;

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
import tp3.example.tp3.model.IconManager;
import tp3.example.tp3.model.Meteo;

import tp3.example.tp3.model.Features;

@Controller
public class MeteoController {
	
	RestTemplate template;
	String meteoimport="0	Soleil\r\n"
			+ "1	Peu nuageux\r\n"
			+ "2	Ciel voilé\r\n"
			+ "3	Nuageux\r\n"
			+ "4	Très nuageux\r\n"
			+ "5	Couvert\r\n"
			+ "6	Brouillard\r\n"
			+ "7	Brouillard givrant\r\n"
			+ "10	Pluie faible\r\n"
			+ "11	Pluie modérée\r\n"
			+ "12	Pluie forte\r\n"
			+ "13	Pluie faible verglaçante\r\n"
			+ "14	Pluie modérée verglaçante\r\n"
			+ "15	Pluie forte verglaçante\r\n"
			+ "16	Bruine\r\n"
			+ "20	Neige faible\r\n"
			+ "21	Neige modérée\r\n"
			+ "22	Neige forte\r\n"
			+ "30	Pluie et neige mêlées faibles\r\n"
			+ "31	Pluie et neige mêlées modérées\r\n"
			+ "32	Pluie et neige mêlées fortes\r\n"
			+ "40	Averses de pluie locales et faibles\r\n"
			+ "41	Averses de pluie locales\r\n"
			+ "42	Averses locales et fortes\r\n"
			+ "43	Averses de pluie faibles\r\n"
			+ "44	Averses de pluie\r\n"
			+ "45	Averses de pluie fortes\r\n"
			+ "46	Averses de pluie faibles et fréquentes\r\n"
			+ "47	Averses de pluie fréquentes\r\n"
			+ "48	Averses de pluie fortes et fréquentes\r\n"
			+ "60	Averses de neige localisées et faibles\r\n"
			+ "61	Averses de neige localisées\r\n"
			+ "62	Averses de neige localisées et fortes\r\n"
			+ "63	Averses de neige faibles\r\n"
			+ "64	Averses de neige\r\n"
			+ "65	Averses de neige fortes\r\n"
			+ "66	Averses de neige faibles et fréquentes\r\n"
			+ "67	Averses de neige fréquentes\r\n"
			+ "68	Averses de neige fortes et fréquentes\r\n"
			+ "70	Averses de pluie et neige mêlées localisées et faibles\r\n"
			+ "71	Averses de pluie et neige mêlées localisées\r\n"
			+ "72	Averses de pluie et neige mêlées localisées et fortes\r\n"
			+ "73	Averses de pluie et neige mêlées faibles\r\n"
			+ "74	Averses de pluie et neige mêlées\r\n"
			+ "75	Averses de pluie et neige mêlées fortes\r\n"
			+ "76	Averses de pluie et neige mêlées faibles et nombreuses\r\n"
			+ "77	Averses de pluie et neige mêlées fréquentes\r\n"
			+ "78	Averses de pluie et neige mêlées fortes et fréquentes\r\n"
			+ "100	Orages faibles et locaux\r\n"
			+ "101	Orages locaux\r\n"
			+ "102	Orages fort et locaux\r\n"
			+ "103	Orages faibles\r\n"
			+ "104	Orages\r\n"
			+ "105	Orages forts\r\n"
			+ "106	Orages faibles et fréquents\r\n"
			+ "107	Orages fréquents\r\n"
			+ "108	Orages forts et fréquents\r\n"
			+ "120	Orages faibles et locaux de neige ou grésil\r\n"
			+ "121	Orages locaux de neige ou grésil\r\n"
			+ "122	Orages locaux de neige ou grésil\r\n"
			+ "123	Orages faibles de neige ou grésil\r\n"
			+ "124	Orages de neige ou grésil\r\n"
			+ "125	Orages de neige ou grésil\r\n"
			+ "126	Orages faibles et fréquents de neige ou grésil\r\n"
			+ "127	Orages fréquents de neige ou grésil\r\n"
			+ "128	Orages fréquents de neige ou grésil\r\n"
			+ "130	Orages faibles et locaux de pluie et neige mêlées ou grésil\r\n"
			+ "131	Orages locaux de pluie et neige mêlées ou grésil\r\n"
			+ "132	Orages fort et locaux de pluie et neige mêlées ou grésil\r\n"
			+ "133	Orages faibles de pluie et neige mêlées ou grésil\r\n"
			+ "134	Orages de pluie et neige mêlées ou grésil\r\n"
			+ "135	Orages forts de pluie et neige mêlées ou grésil\r\n"
			+ "136	Orages faibles et fréquents de pluie et neige mêlées ou grésil\r\n"
			+ "137	Orages fréquents de pluie et neige mêlées ou grésil\r\n"
			+ "138	Orages forts et fréquents de pluie et neige mêlées ou grésil\r\n"
			+ "140	Pluies orageuses\r\n"
			+ "141	Pluie et neige mêlées à caractère orageux\r\n"
			+ "142	Neige à caractère orageux\r\n"
			+ "210	Pluie faible intermittente\r\n"
			+ "211	Pluie modérée intermittente\r\n"
			+ "212	Pluie forte intermittente\r\n"
			+ "220	Neige faible intermittente\r\n"
			+ "221	Neige modérée intermittente\r\n"
			+ "222	Neige forte intermittente\r\n"
			+ "230	Pluie et neige mêlées\r\n"
			+ "231	Pluie et neige mêlées\r\n"
			+ "232	Pluie et neige mêlées\r\n"
			+ "235	Averses de grêle";
	
	public MeteoController(RestTemplate rt) {
		template = rt;
	}
	@PostMapping("/meteo")
	public String showMeteo( HttpServletRequest request,Model model) throws RestClientException {
		String content=request.getParameter("address");
		String adress_parts=content.replaceAll("\\s","+");
		model.addAttribute("address", content);
		IconManager icon=new IconManager();
		model.addAttribute("urlicon",icon);
		String url="https://api-adresse.data.gouv.fr/search/?q="+adress_parts;
		String urlmeteo="";
		String meteosp1[]=meteoimport.split("\n");
		String line[];
		
		HashMap<Integer,String> temps=new HashMap<Integer,String>();
		System.out.println(meteosp1[0]);
		for(int i=0;i<meteosp1.length;i++) {
			line=meteosp1[i].split("	");
			System.out.println(line[0]);
			temps.put(Integer.parseInt(line[0]),line[1]);
		}
		

		model.addAttribute("temps",temps);
		model.addAttribute("url",url);
		Foo foo=template.getForObject(url, Foo.class);
		ArrayList<Meteo> meteos=new ArrayList<Meteo>();
		model.addAttribute("foo",foo);
		model.addAttribute("stat",0);
		System.out.println(foo.getType());
		System.out.println(foo.getFeatures()[0].getProperties().getLabel());
		for(int i=0;i<foo.getFeatures().length;i++){
		 	System.out.println(foo.getFeatures()[i].getProperties().getLabel());
		 	urlmeteo="https://api.meteo-concept.com/api/forecast/daily?token=4ea2db3512e8b93c884651b5e7fda1b6ff603bbb323418e3652a68bfc25b06d8&latlng="+foo.getFeatures()[i].getGeometry().getCoordinates()[1]+","+foo.getFeatures()[i].getGeometry().getCoordinates()[0];
		 	meteos.add(template.getForObject(urlmeteo, Meteo.class));
		 }
		model.addAttribute("meteos",meteos);
		//String result=restTemplate.getForObject(url,String.class);
		
		//curl 'https://api-adresse.data.gouv.fr/search/?q=10&type=housenumber&autocomplete=1'
		//curl 'https://api-adresse.data.gouv.fr/search/?q=10%20rue%201700%20La%20Rochelle&type=housenumber&autocomplete=1'
		
		return "meteo";
	}
	

}
