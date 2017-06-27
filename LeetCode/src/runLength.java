/**
 * 
 */

/**
 * @author Tejas
 *
 */
public class runLength {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "rrrrr7yyytooo";
		int count = 1 , i=0;
		StringBuilder sb = new StringBuilder();
	
		
		for(i=0;i< input.length();i++)
		{
			char temp = input.charAt(i);
			
			while(i+1 < input.length() && Character.valueOf(input.charAt(i+1)).equals(temp))
			{
				count++;
				i++;
			}
			sb.append(count);
			sb.append(temp);
			count = 1;
				
		}
		
		System.out.println(sb.toString());
		
		}

}
