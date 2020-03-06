import controller.GamesHelper;
import model.Games;

//program used to add games to database, to test connection, and before add-game avaliable.

public class TestProgram {

	public static void main(String[] args) {
		
		Games game1 = new Games("Call Of Duty", 52.99);
		
		GamesHelper gh= new GamesHelper();
		
		gh.insertGame(game1);

	}

}
