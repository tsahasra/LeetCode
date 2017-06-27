public class ZigZag {
    public static String convert(String s, int numRows) {
    int len = s.length() , index = 0;
    if(len <= 1 || numRows >= len)
        return s;
        
    StringBuilder sb = new StringBuilder();
    
    while(index < len){
     sb.append(s.charAt(index));
     index += ((2 *numRows) - 2);
    }
    
    boolean flag = false;
    int in1=0,in2=0;
    for(int i = 1;i<=(numRows-2);i++){
        flag = false;
        in1 = i;
        in2 = i+((2 *numRows) - 2) - (2*i);
        while(index < len){
            if(flag){
                sb.append(s.charAt(in2));
                in2 += ((2 *numRows) - 2);
                flag = false;
            }
            else{
                sb.append(s.charAt(in1));
                in1 += ((2 *numRows) - 2);
                flag = true;
            }
            
        }
    }
    
    index = numRows - 1;
    while(index < len){
     sb.append(s.charAt(index));
     index += ((2 *numRows) - 2);
    }
    
     return sb.toString();
    }
   
   public static void main(String[] args){
     System.out.println(convert("PAYPALISHIRING",5));
}   
}