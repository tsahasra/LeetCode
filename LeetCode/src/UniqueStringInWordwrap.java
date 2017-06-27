/**
 * 
 */

/**
 * @author Tejas
 *
 */
public class UniqueStringInWordwrap {

	/**
	 * @param args
	 * 
	 */
	
	public static int findSubstringWraparound(String p){
		if(p.length() == 0)
			return 0;
		
		int count = 1 , a[] = new int[26];
		a[(int)p.charAt(0)]++;
		
		
		for(int i=1;i<p.length();i++){
			int c = (int)p.charAt(i);
			if(a[c] == 0){
				a[c]++;
				count++;
			}
			
			
					
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSubstringWraparound("zab"));
	}

}
