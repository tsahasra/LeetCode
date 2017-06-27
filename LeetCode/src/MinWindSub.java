import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MinWindSub {
    
	public static class cnode implements Comparable{
		public int index;
		public char c;
		
		public cnode(char c1,int in){
			this.c = c1;
			this.index = in;
		}

		
		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.index, ((cnode)o).index);
		}
		
		
	}
	
	public static String minWindow(String s, String t) {
		if(s.length() < t.length())
			return "";
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(int i=0;i<t.length();i++){
        Character c = new Character(t.charAt(i));
            if(hm.containsKey(c))
                hm.put(c,hm.get(c)+1);
            else
                hm.put(c,1);
        }
        
        int slen = s.length(), sti=0,ei=0 , tsti=0 , tei = 0 ,wlen = 0;
        HashMap<Character,Integer> hcopy = new HashMap<Character,Integer>(hm);
        HashMap<Character,Integer> hi = new HashMap<Character,Integer>();
        PriorityQueue<cnode> pq = new PriorityQueue<cnode>();
        
        int i =0;
        for(i=0;i<slen;i++){
            Character c = new Character(s.charAt(i));
            if(hcopy.containsKey(c)){
                sti = i;
                Integer i1 = hcopy.get(c);
                if(i1 == 1)
                    hcopy.remove(c);
                else
                    hcopy.put(c,hcopy.get(c)-1);
                
                if(hi.containsKey(c))
                	hi.put(c,hcopy.get(c)+1);
                else
                	hi.put(c,1);
                	
                if(hcopy.isEmpty() && t.length() == 1)
                    return c.toString();
                
                cnode n = new cnode(c,i);
                pq.add(n);
                
                break;
            }
        }
        
        for(int j=i+1;j<slen;j++){
        	Character c = new Character(s.charAt(j));
            if(hcopy.containsKey(c) || hm.containsKey(c)){
                
            	if(hcopy.containsKey(c)){
            	Integer i1 = hcopy.get(c);
                if(i1 == 1)
                    hcopy.remove(c);
                else
                    hcopy.put(c,hcopy.get(c)-1);
            	}
                
                if(hi.containsKey(c))
                	hi.put(c,hi.get(c)+1);
                else
                	hi.put(c,1);
                
                cnode n = new cnode(c,j);
                pq.add(n);
                
                if(hcopy.isEmpty()){
                	while(!pq.isEmpty()){
                		cnode cn = (cnode)pq.peek();
                		Character c2 = cn.c;
                		if(hi.get(c2) >= hm.get(c2)){
                			tsti = cn.index;
                			tei = j;
                			if(wlen == 0 || tei - tsti < wlen){
                			sti = tsti;
                			ei = tei;
                			wlen = tei - tsti;
                			}
                			if(hi.get(c2) == 1)
                                hi.remove(c2);
                            else
                                hi.put(c2,hi.get(c2)-1);
                			
                			if(!hi.containsKey(c2) || hi.get(c2) < hm.get(c2)){
                				hcopy.put(c2,1);
                			pq.remove();
                			break;
                			}
                			
                			pq.remove();
                		}
                		
                			
                	}
                			
                }
                
                
            }
            
        }
        
        String fs = wlen == 0 ? "":s.substring(sti,ei+1);
        return fs;
    }

    public static void main(String[] args){
     System.out.println(minWindow("a","b")); 
    }
}