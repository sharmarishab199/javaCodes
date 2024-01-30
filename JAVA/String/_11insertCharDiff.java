import java.util.Scanner;

public class _11insertCharDiff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();
        
        String result = insertAsciiDifferences(inputString);
        
        System.out.println("Result: " + result);
    }

    private static String insertAsciiDifferences(String s) {
        StringBuilder result = new StringBuilder();
        boolean flag=false;

        for (int i = 0; i < s.length() - 1; i++) {
            char currentChar = s.charAt(i);
            char nextChar = s.charAt(i + 1);

            int asciiDifference = nextChar - currentChar;
            System.out.println("asciiDifference "+ asciiDifference+" of "+currentChar+" and "+nextChar);

            if(!flag){
                result.append(currentChar).append(asciiDifference).append(nextChar);
                flag=true;
            }
            else result.append(asciiDifference).append(nextChar);
        }

        return result.toString();
    }
}
