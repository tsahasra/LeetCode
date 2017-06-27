
public class substringPalindrome {

public static boolean flag;
public static String str;    
	public static boolean isPalindrome(String p1,int start , int end)
	{
		flag = false;
		Character c1 = new Character(p1.charAt(start));
		Character c2 = new Character(p1.charAt(end));
		//System.out.println(c1+" "+c2);
		while(start <= end && c1.equals(c2) && !flag)
		{
		    
			end--;
			start++;
			if(start > end)
			{
				end ++;
				start --;
						
				flag = true;
			}
			else
			{
				c1 =  p1.charAt(start);
				c2 = p1.charAt(end);
				
			}
		}
		
		
		return flag;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub//
		
		String p1 ="abbcccbbd";
		str = String.valueOf((p1.charAt(p1.length() / 2)));
		boolean verdict = false;
		int i = 0;
		int j= p1.length() - 1;
		while(str.length() <= (j-i) && i < (p1.length() - 1))
		{
			while(j>i && verdict == false)
		{
			
			verdict = isPalindrome(p1,i,j);
			//System.out.println(verdict);
			if(verdict == false)
				j--;
		}
			if(verdict == true && str.length() <= (j - i))
			{
				System.out.println(i + " " + j);
				str = p1.substring(i,j+1);
				System.out.println(str);
				verdict = false;
			}
			i++;
			verdict = false;
		    j=p1.length() - 1;
		}
		
		//System.out.println(i + " " + j);
		System.out.println(str);
		
		
	}
	
	
	
}
