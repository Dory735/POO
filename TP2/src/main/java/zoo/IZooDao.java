package zoo;

public interface IZooDao {
	
	public void setLimiteVisiteur(int nbv);
	public int getNombreVisiteurs();
	public void ajouterSecteur(TypeAnimal type);
	public void nouveauVisiteur() throws LimiteVisiteurException ;
	public int getLimiteVisiteur() ;
	public void nouvelAnimal(Animal pet) throws AnimalDansMauvaisSecteurException ;
	public int nombreAnimaux() ;

}
