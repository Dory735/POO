package zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
	private int visiteurs;
	private ArrayList<Secteur> secteursAnimaux=new ArrayList<Secteur>();
	private int nbvisiteurMaxParSecteur;
	
	public Zoo(int nbv) {
		this.nbvisiteurMaxParSecteur=nbv;
	}
	
	public int getNombreVisiteurs() {
		return visiteurs;
	}
	public void ajouterSecteur(TypeAnimal type) {
		secteursAnimaux.add(new Secteur(type));
		
	}
	public void nouveauVisiteur() throws LimiteVisiteurException {
		if(visiteurs<nbvisiteurMaxParSecteur*secteursAnimaux.size()) {
			visiteurs++;
		}else {
			throw new LimiteVisiteurException("La limite de visiteur a été atteinte");
		}
		
	}
	public int getLimiteVisiteur() {
		return secteursAnimaux.size()*nbvisiteurMaxParSecteur;
	}
	public void nouvelAnimal(Animal pet) throws AnimalDansMauvaisSecteurException {
		int i=0;
		while(i<secteursAnimaux.size() && pet.getTypeAnimal()!=secteursAnimaux.get(i).obtenirType()) {
			i++;
		}
		if(i<secteursAnimaux.size()) {
			if(secteursAnimaux.get(i).obtenirType()==pet.getTypeAnimal()) {
				secteursAnimaux.get(i).ajouterAnimal(pet);
			}
			
		}else {
			throw new AnimalDansMauvaisSecteurException("Pas de secteur adapte a l'animal");
			
		}
		
		
	}
	public int nombreAnimaux() {
		int nb=0;
		for(Secteur e:secteursAnimaux) {
			nb+=e.getNombreAnimaux();
		}
		return nb;
	}
	
	

}
