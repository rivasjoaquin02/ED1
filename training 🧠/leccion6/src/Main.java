import java.util.Stack;

public class Main {
    public static boolean Bingo(String s) {
        PilaSE <Character> P = new PilaSE<>();

        for (int i = 0; i < s.length(); i++) {
            if ( i < s.length() - 1 &&  s.charAt(i) == 'b' && s.charAt(i+1) == 'a')
                return false;
            if (s.charAt(i) == 'a')
                P.push('a');
            else {
                if (P.isEmpty()) return false;

                try {
                    P.pop();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return P.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}