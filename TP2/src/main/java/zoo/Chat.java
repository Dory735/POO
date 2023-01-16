package zoo;

public class Chat extends Animal{
	public Chat() {
		super(TypeAnimal.FELIN);
		//this.typeAnimal=TypeAnimal.FELIN;
	}
	@Override
	public String getNomAnimal() {
		return "chat";
	}

}
