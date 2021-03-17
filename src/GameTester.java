import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.Games;
import model.ListDetails;
import model.User;

public class GameTester {
	
	public static void main(String[] args) {
		
		User me = new User("Alex", "Ryberg", 23);
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		LocalDate ld1 = LocalDate.of(1998, 11, 1);		
		LocalDate ld2 = LocalDate.of(2000, 1, 1);
		
		Games mario = new Games(ld1, "Super Mario World1", "Adventure", 1);
		Games yoshi = new Games(ld2, "Yoshi's Island", "Adventure", 1);
		
		List<Games> myGames = new ArrayList<Games>();
		
		myGames.add(mario);
		myGames.add(yoshi);
		
		ListDetails myList = new ListDetails("Alex's Games", me, myGames);
		
		ldh.insertNewListDetails(myList);
		
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a : allLists) {
			System.out.println(a.toString());
		}
		
		System.out.println(myList);
	
	}

}
