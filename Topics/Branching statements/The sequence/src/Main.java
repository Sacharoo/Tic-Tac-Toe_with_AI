import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;

        for (int i = 1; i <= num; i++) {

            for (int j = 0; j < i; j++) {

                if(count == num) {
                    break;

                } else {
                    count++;
                    System.out.print(i + " ");}
            }
        }

    }
}