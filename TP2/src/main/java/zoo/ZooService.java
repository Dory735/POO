package zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ZooService implements IZooService{
	
	@Autowired
	IZooDao zooDao;
	public void addSetLimiteVisiteur(int nbv) {
		zooDao.setLimiteVisiteur(nbv);
	}
	
	public int addGetNombreVisiteurs() {
		return zooDao.getNombreVisiteurs();
	}
	public void addAjouterSecteur(TypeAnimal type) {
		zooDao.ajouterSecteur(type);
	}
	public void addNouveauVisiteur() throws LimiteVisiteurException {
		zooDao.nouveauVisiteur();
	}
	public int addGetLimiteVisiteur() {
		return zooDao.getLimiteVisiteur();
	}
	public void addNouvelAnimal(Animal pet) throws AnimalDansMauvaisSecteurException{
		zooDao.nouvelAnimal(pet);
	}
	public int addNombreAnimaux() {
		return zooDao.nombreAnimaux();
	}

	public IZooDao getZooDao() {
		return zooDao;
	}

	public void setZooDao(IZooDao zooDao) {
		this.zooDao = zooDao;
	}
	

}
