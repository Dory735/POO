package zoo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppSpringJava {
	public static void main(String args[]) throws AnimalDansMauvaisSecteurException, LimiteVisiteurException {
		
		
		
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		AnnotationConfigApplicationContext aac= new AnnotationConfigApplicationContext(AppConfig.class) ;

		//IZooService iz= (IZooService) context.getBean("ZooService");
		//aac.refresh();
		IZooService iz=(IZooService) aac.getBean(IZooService.class);
		
		
		
		iz.addAjouterSecteur(TypeAnimal.CANIDE);
		iz.addSetLimiteVisiteur(10);
		iz.addNouveauVisiteur();
		System.out.println(iz.addGetNombreVisiteurs());
		
			}

}
