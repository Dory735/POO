package zoo;

public class Chien extends Animal{
	
	public Chien() {
		super(TypeAnimal.CANIDE);
		//this.typeAnimal=TypeAnimal.CANIDE;
	}
	
	@Override
	public String getNomAnimal() {
		return "chien";
	}

}
