import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
	
	
    public static int leastInterval(char[] tasks, int n) {
    	if(tasks.length == 0)  
            return 0;
        int len = tasks.length ,size = 0,count=0,prevsize = 0;
        int[] c = new int[26];
        
        for(int i=0;i<len;i++){
           if(c[(int)tasks[i] - 65] == 0)
                    size++;
            c[(int)tasks[i] - 65]++;
        }
            
        Arrays.sort(c);
        
        int li = 26-size , ti = -1;
        char f = '-';
        while(size != 0){
            for(int i=25;c[i]>0;i--){
                if(size > n){
                    count++;
                    c[i]--;
                    if(c[i] == 0){
                        if(ti != li){
                            ti = i+1;
                            li = ti;
                    }
                    }
                }else if(size == n){
                    if(i == 26-size)
                        count+= 2;
                    else
                        count++;
                    c[i]--;
                    if(c[i] == 0){
                        if(ti != li){
                            ti = i+1;
                            li = ti;
                        }
                    }
                    f = 'e';
                }else{
                    if(i == 26-size)
                        count+= (1 + n-size);
                    count++;
                    c[i]--;
                    if(c[i] == 0){
                        if(ti != li){
                            ti = i+1;
                            li = ti;
                        }
                    }
                    f = 'l';
                }
                     
            }
             
             prevsize = size; 
             size = 26 - li;
             ti = -1;
        }       
        
        if(f == 'e')
            count--;
        else if(f == 'l')
            count -= n-prevsize;
        
        
        return count;
    }

public static void main(String[] args){
    System.out.println( leastInterval(new char[]{'A','A','A','B','A','B'},3));
}

}