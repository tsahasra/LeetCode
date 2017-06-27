import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * 
 */

/**
 * @author Tejas
 *
 */
public class FirstUniqueChar {
	 public static void main(String[] args) {
		 String input = "mariecurie";
		 HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		int pos = 0;
		while(pos < input.length())
		{
			if(hm.containsKey(input.charAt(pos)))
			{
				hm.remove(input.charAt(pos));
				pos++;
			}
			else
			{
				hm.put(input.charAt(pos), pos);
				pos++;
			}
				 }
		
		Iterator<Entry<Character, Integer>> it = hm.entrySet().iterator();
		Character temp = '/';
		
		while(it.hasNext())
		{
			temp = it.next().getKey();
			
		}
		
		System.out.println(temp);
}
	 }
