public class _10findOccurences{
    public static void main(String[] args) {
        String s="This is an academic paper discussing the importance of algorithms in computer science.algorithms play a crucial role in various applications, including plagiarism detection. algorithm ";

        String lastStr=lastWord(s);

        int i=s.indexOf(lastStr,0),count=-1;
        while(i!=-1){
            count++;
            i=s.indexOf(lastStr,i+1);
        }
        System.out.println(count);
    }
    public static String lastWord(String  s) {
        String words[]=s.split(" ");
        return words[words.length-1];
    }
}