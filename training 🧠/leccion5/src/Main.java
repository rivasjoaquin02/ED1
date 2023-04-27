public class Main {
    public static int numberOfDigits(int n) {
        if (n == 0) return 0;
        return numberOfDigits(n/10) + 1;
    }

    public static int mcd(int a,int b){
        if (b == 0) return a;
        return mcd(b, a%b);
    }

    public static void main(String[] args) {

    }
}