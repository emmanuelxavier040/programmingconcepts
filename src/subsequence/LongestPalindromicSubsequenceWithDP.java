package subsequence;

import java.util.HashMap;
import java.util.Objects;

public class LongestPalindromicSubsequenceWithDP {

    private class NewKey {
        private Integer i;
        private Integer j;

        public NewKey(Integer i, Integer j) {
            this.i=i;
            this.j=j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NewKey newKey = (NewKey) o;
            return newKey.i == this.i && newKey.j == this.j;
        }

        @Override
        public int hashCode() {
            return i.hashCode()*31+j.hashCode();
        }
    }


    private String LPS(String text, int i, int j, HashMap<NewKey, String> map ) {
        if(i > j) return "";
        if(i == j) {
            Character a = text.charAt(i);
            return a.toString();
        }
        if(text.charAt(i) == text.charAt(j)) {
            String a =((Character)text.charAt(i)).toString();
            String memory = map.get(new NewKey(i+1,j-1));
            if(memory != null && !memory.isEmpty()) {
                return a.concat(memory).concat(a);
            }
            else {
                String newMemory =a.concat(LPS(text, i+1, j-1, map)).concat(a);
                map.put(new NewKey(i+1, j-1), newMemory);
                return newMemory;
            }

        }
        else {
            String memory1 = map.get(new NewKey(i,j-1));
            if(memory1 == null || memory1.isEmpty()) {
                memory1 = LPS(text, i, j-1, map);
                map.put(new NewKey(i,j-1), memory1);
            }
            String memory2 = map.get(new NewKey(i+1,j));
            if(memory2 == null || memory2.isEmpty()) {
                memory2 = LPS(text, i+1, j, map);
                map.put(new NewKey(i+1,j), memory2);
            }
            if(memory1.length() > memory2.length()) return memory1;
            else return memory2;
        }
    }


    private String findLPS(String text) {
        HashMap<NewKey, String> map = new HashMap<>();
        return LPS(text, 0, text.length()-1, map);
    }


    public static void  main(String args[]) {

        System.out.println(new LongestPalindromicSubsequenceWithDP().findLPS("EMMANUELXAVIER"));
    }
}
