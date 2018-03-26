import java.util.Comparator;


/*  Java class used to override the compare function in the comparator package 
 *  which will be used in the collections method in Players.java */
public class TurnComparator implements Comparator<Player> {
   @Override
	public int compare(Player o1, Player o2) {
		Integer first=o1.getTurnNum();
		Integer second=o2.getTurnNum();
		  return first.compareTo(second);
		
	}

}
