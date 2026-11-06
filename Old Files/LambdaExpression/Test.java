public class Test {
    public static void main(String[] args) {
        int n = 9, div = 0;

        // wrong logic
        // number is divided by 0,
        // so this program abnormally terminates
        div = n / 0;
        System.out.println(div);
    }
}
