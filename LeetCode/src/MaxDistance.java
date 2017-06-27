import java.util.ArrayList;
import java.util.List;

public class MaxDistance {
    public static  int maxDistance(List<List<Integer>> arrays) {
        List<Integer> temp = (List<Integer>)arrays.get(0);
        Integer min=temp.get(0) , max = temp.get(temp.size()-1) ;
        int maxi =0 , mini = 0 , in = 0;
        for(List<Integer> t : arrays)
            {
                 Integer i1 = t.get(t.size()-1);   
                    if(i1 > max){
                        max = i1;
                        maxi = in;
                    }
                  Integer i2 = t.get(0);   
                    if(i2 < min){
                        min = i2;
                        mini = in;
                    }
                    
                    in++;
            }
            
          if(mini != maxi)
            return max - min;
         
          if(mini > 0)
        	  min = arrays.get(0).get(0);
          else
        	  min = arrays.get(1).get(0);
          
          in = 0;
          
         for(List<Integer> t : arrays)
            {
                 if(mini != in){
                  Integer i2 = t.get(0);   
                    if(i2 < min){
                        min = i2;
                        mini = in;
                    }
                 }
                 
                    in++;
            }
        
        return max - min;
    }

public static void main(String[] args){
	List<List<Integer>> li  = new ArrayList<List<Integer>>();
	List<Integer> l1 = new ArrayList<Integer>();
	List<Integer> l2 = new ArrayList<Integer>();
	l1.add(1);
	l1.add(4);
	l2.add(0);
	l2.add(5);
	li.add(l1);
	li.add(l2);
     System.out.println(maxDistance(li));
}   


}