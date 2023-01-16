package zoo;

public interface IZooService {
	public void addSetLimiteVisiteur(int nbv);
	public int addGetNombreVisiteurs();
	public void addAjouterSecteur(TypeAnimal type);
	public void addNouveauVisiteur() throws LimiteVisiteurException ;
	public int addGetLimiteVisiteur() ;
	public void addNouvelAnimal(Animal pet) throws AnimalDansMauvaisSecteurException ;
	public int addNombreAnimaux() ;
	

}
