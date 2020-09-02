package subsequence;

public class LongestPalindromicSubsequence {

    private String LPS(String text, int i, int j) {
        if(i > j) return "";
        if(i == j) {
            Character a = text.charAt(i);
            return a.toString();
        }
        if(text.charAt(i) == text.charAt(j)) {
            String a =((Character)text.charAt(i)).toString();
            return a.concat(LPS(text, i+1, j-1)).concat(a);
        }
        else {
            String a = LPS(text, i, j-1);
            String b = LPS(text, i+1, j);
            if(a.length() > b.length()) return a;
            else return b;
        }
    }


    private String findLPS(String text) {
        return LPS(text, 0, text.length()-1);
    }


    public static void  main(String args[]) {

        System.out.println(new LongestPalindromicSubsequence().findLPS("GEEKSFORGEEKS"));
    }
}
