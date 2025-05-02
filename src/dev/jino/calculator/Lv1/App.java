package dev.jino.calculator.Lv1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num1, num2;
        do {
            System.out.print("첫 번째 숫자를 입력하세요(0 - 2147483647): ");
            num1 = sc.nextLong();
            if (num1 < 0 || num1 > 2147483647) {
                System.out.printf("%d는 음수 입니다.\n", num1);
            }
        } while (num1 < 0);

        do {
            System.out.print("두 번째 숫자를 입력하세요(0 - 2147483647): ");
            num2 = sc.nextLong();
            if (num2 < 0 || num1 > 2147483647) {
                System.out.printf("%d는 음수 입니다.\n", num1);
            }
        } while (num2 < 0);

    }
}