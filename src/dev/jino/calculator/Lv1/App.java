package dev.jino.calculator.Lv1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc;
        int num1, num2;

        while (true) {
            sc = new Scanner(System.in);
            System.out.print("첫 번째 정수를 입력하세요(0 - 2147483647): ");

            String input1 = sc.nextLine().trim();
            if (!input1.matches("\\d+")) {
                System.out.println("문자/음수/소수/2개 이상의 숫자는 입력할 수 없습니다.");
                continue;
            }

            try {
                num1 = Integer.parseInt(input1);
                System.out.printf("첫 번째 입력 숫자: %d\n", num1);
                break;
            } catch (NumberFormatException e) {
                System.out.println("범위를 벗어나는 숫자는 입력할 수 없습니다.");
            }
        }

        while (true) {
            sc = new Scanner(System.in); // 버퍼 초기화
            System.out.print("두 번째 정수를 입력하세요(0 - 2147483647): ");

            String input2 = sc.nextLine().trim();
            if (!input2.matches("\\d+")) {
                System.out.println("문자/음수/소수/2개 이상의 숫자는 입력할 수 없습니다.");
                continue;
            }

            try {
                num2 = Integer.parseInt(input2);
                System.out.printf("첫 번째 입력 숫자: %d\n", num2);
                break;
            } catch (NumberFormatException e) {
                System.out.println("범위를 벗어나는 숫자는 입력할 수 없습니다.");
            }
        }

    }
}