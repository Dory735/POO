package zoo;

public class App {
	private Zoo zoo;
	 public App(Zoo z) {
		 zoo=z;
	 }
	
	public static void main(String args[]) throws AnimalDansMauvaisSecteurException, LimiteVisiteurException {
		Zoo zoo=new Zoo(15);
		App app=new App(zoo);
		Animal poisson=new Animal(TypeAnimal.AMPHIBIEN);
		
		
		
		zoo.ajouterSecteur(TypeAnimal.CANIDE);
		zoo.ajouterSecteur(TypeAnimal.FELIN);
		
		zoo.nouvelAnimal(new Chat());
		zoo.nouvelAnimal(new Chien());
		
		for(int i=0;i<30;i++) {
			zoo.nouveauVisiteur();
		}
		
		System.out.println(zoo.getNombreVisiteurs());
		
		zoo.nouveauVisiteur();
		
		
		

		
		
		
		
		
	}

}
