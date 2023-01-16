package zoo;

import java.util.ArrayList;

public class Secteur {
	private TypeAnimal typeAnimauxDansSecteur;
	private ArrayList<Animal> animauxDansSecteur=new ArrayList<Animal>();
	
	public Secteur(TypeAnimal type) {
		typeAnimauxDansSecteur=type;
		
	}
	
	public void ajouterAnimal(Animal pet) throws AnimalDansMauvaisSecteurException {
		
		if(pet.getTypeAnimal()==typeAnimauxDansSecteur) {
			animauxDansSecteur.add(pet);
		}else {
			throw new AnimalDansMauvaisSecteurException("secteur non adapte a l'animal");
			
		}
		
	}
	public int getNombreAnimaux() {
		return animauxDansSecteur.size();
	}
	public TypeAnimal obtenirType() {
		return typeAnimauxDansSecteur;
	}

}
