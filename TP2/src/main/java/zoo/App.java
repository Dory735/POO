package zoo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	
	public static void main(String args[]) throws AnimalDansMauvaisSecteurException, LimiteVisiteurException {
		
		
			
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		//AnnotationConfigApplicationContext aac= new AnnotationConfigApplicationContext() ;

		IZooService iz= (IZooService) context.getBean("ZooService");
		//IZooService iz=(IZooService) aac.getBean("ZooService");
		
		
		
		iz.addAjouterSecteur(TypeAnimal.CANIDE);
		iz.addSetLimiteVisiteur(10);
		iz.addNouveauVisiteur();
		System.out.println(iz.addGetNombreVisiteurs());
		
			}

}
