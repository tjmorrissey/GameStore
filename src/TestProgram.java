import controller.GamesHelper;
import model.Games;

//program used to add games to database, to test connection, and before add-game avaliable.

public class TestProgram {

	public static void main(String[] args) {
		
		Games game1 = new Games("Destiny 2", 29.99);
		
		GamesHelper gh= new GamesHelper();
		
		gh.insertGame(game1);

	}

}
