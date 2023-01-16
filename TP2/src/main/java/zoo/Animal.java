package zoo;

public class Animal {
	private String nomAnimal;
	protected TypeAnimal typeAnimal;
	
	
	
	public Animal(TypeAnimal type) {
		typeAnimal=type;
	}
	
	public String getNomAnimal() {
		return nomAnimal;
	}
	public TypeAnimal getTypeAnimal() {
		return typeAnimal;
	}

}
