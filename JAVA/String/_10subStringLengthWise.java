public class _10subStringLengthWise{
    public static void main(String[] args) {
        String str = "racecar";

        for(int len=1;len<=str.length();len++){
            for(int i=0;i<=str.length()-len;i++){
                int j=i+len;
                if(palindrom(str.substring(i,j))&&str.substring(i,j).length()>2){
                    System.out.println(str.substring(i,j)+" "+returnIdx(str.substring(i,j), str));
                }
            }
        }



    }

    public static boolean palindrom(String s) {
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j))return false;
        }
        return true;
    }

    public static String returnIdx(String s,String parent) {
        String ans="";
        int i=parent.indexOf(s);
        int j=i+s.length()-1;
        return i+"-"+j;
    }
}  