import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ConcatenatedWords {
	
	public static class TrieNode{
		Map<Character,TrieNode> m = new HashMap<Character,TrieNode>();
		boolean eos;
		
		public TrieNode(HashMap<Character,TrieNode> h , boolean ef){
			this.m = h;
			this.eos = ef;
		}
	}
	
    public static  List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words.length <= 1)
            return new ArrayList<String>();
        
        int wlen = words.length;    
        Map<Integer,List<String>> hm = new TreeMap<Integer,List<String>>();
        
        for(int i =0;i<wlen;i++){
            int ss = words[i].length();
            if(hm.containsKey(ss)){
                List tl1 = hm.get(ss);
                tl1.add(words[i]);
            }
            else{
                List tl2 = new ArrayList<String>();
                tl2.add(words[i]);
                hm.put(ss,tl2);
            }
        }
        
        Set<Integer> sl = hm.keySet();
        List<String> result = new ArrayList<String>();
        TrieNode t1 = new TrieNode(new HashMap<Character,TrieNode>(),false) , t2 = new TrieNode(new HashMap<Character,TrieNode>(),false);
        boolean insertflag = false;
        
        for(Integer i1: sl){
        	List<String> tl = hm.get(i1);
        	int si = 0;
        	for(String st : tl){
        		insertflag = false;
        		int temps=0;
        		while(si < i1){
        			temps = searchSubString(t1,st,si);
        		if(temps > 0){
        				si += temps;
        			}
        		else{
        			insertString(t1,st);
        			insertflag = true;
        			break;
        			}
        		}
        		
        		if(insertflag)
        			continue;
        		
        		if(!searchString(t2,st)){
        			result.add(st);
        			insertString(t2,st);
        		}
        	}
        	
        }
        
        return result;
    }

   
	private static int searchSubString(TrieNode t, String st, int si) {
		// TODO Auto-generated method stub
		int len = st.length(),i=0;
		TrieNode tt = t;
		for(i=si;i<len;i++)
			if(tt.m.containsKey(st.charAt(i)))
					tt = tt.m.get(st.charAt(i));
			else
				break;
		
			if(tt.eos)
				return i-si;
			else
				return 0;
		
	}
	
	private static boolean searchString(TrieNode t, String st) {
		// TODO Auto-generated method stub
		int len = st.length(),i=0;
		TrieNode tt = t;
		for(i=0;i<len;i++)
			if(tt.m.containsKey(st.charAt(i)))
					tt = tt.m.get(st.charAt(i));
			else
				return false;
		
		return true;
	}


	private static void insertString(TrieNode t, String st) {
		// TODO Auto-generated method stub
		int len = st.length(),i=0;
		TrieNode tt = t;
		for(i=0;i<len;i++){
			if(!tt.m.containsKey(st.charAt(i)))
				if(i == len -1)
					tt.m.put(st.charAt(i), new TrieNode(new HashMap<Character,TrieNode>(),true));
				else
					tt.m.put(st.charAt(i), new TrieNode(new HashMap<Character,TrieNode>(),false));
			tt = tt.m.get(st.charAt(i));
		}
	}



public static void main(String[] args){
    System.out.println(findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
}
     


}