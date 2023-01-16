package zoo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class TestNombreVisiteur {
	
	@Test
	void test() {
		assertThrows(LimiteVisiteurException.class, ()->{
			Zoo zoo=new Zoo(2);
			zoo.ajouterSecteur(TypeAnimal.FELIN);
			for(int i=0;i<3;i++) {
				zoo.nouveauVisiteur();
			}
		
		
		});
	}

}
