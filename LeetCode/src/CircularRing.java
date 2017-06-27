import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CircularRing {
    
    static int circularWalk(int n, int s, int t, int r_0, int g, int seed, int p){
        // Complete this function
        
        if(s == t)
            return 0;
        
        HashMap<Integer,Integer> ht = new HashMap<Integer,Integer>();
        int r=r_0;
        for(int i=0;i<n;i++){
            ht.put(i,r);
            r = (r * g + seed) % p;
         }
        
        
        int acd = s < t ? n - t + s : s - t;
        int cd = s < t ? t - s : n - s + t;
        int dist = 0;
        char mode = 'n';
        
        if(cd <= acd){
            mode = 'c';
            dist = cd;
        }
        else{
            mode = 'a';
            dist = acd;
        }
            
        
        int pos = s , time = 0;
        int rval = ht.get(pos);
        
        boolean flag = false;
        
        while(rval != 0){
                
            for(int i=rval;i>0;i--){
              switch(mode){
                case 'a': {
                      if(pos == 0)
                        pos = n - 1;
                      else
                        pos -= 1;
                }break;
                
                case 'c': {
                      if(pos == n-1)
                        pos = 0;
                      else
                        pos += 1;
                }break;
              } 
                  if(pos == t){
                	time++;  
                    return time; 
                  }
            }
            
            time++;
            rval = ht.get(pos); 
             
            if(rval == 0 && !flag)
             {
            	pos = s;
            	switch(mode){
                    case 'c': 
                        mode = 'a';
                        dist = acd;
                        break;
                    case 'a':
                        mode = 'c';
                        dist = cd;
                        break;
                }
                rval = ht.get(pos);
                time = 0;
                flag = true;
             }
            else if(rval != 0){
            	acd = pos < t ? n - t + pos : pos - t;
                cd = pos < t ? t - pos : n - pos + t;
                                
                if(cd <= acd){
                    mode = 'c';
                    dist = cd;
                }
                else{
                    mode = 'a';
                    dist = acd;
                }
            }
        }
            return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        int r_0 = in.nextInt();
        int g = in.nextInt();
        int seed = in.nextInt();
        int p = in.nextInt();
        int result = circularWalk(n, s, t, r_0, g, seed, p);
        System.out.println(result);
    }
}
