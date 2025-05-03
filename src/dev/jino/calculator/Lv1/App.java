package dev.jino.calculator.Lv1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc;
        long num1, num2;
        char op;

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
                System.out.printf("두 번째 입력 숫자: %d\n", num2);
                break;
            } catch (NumberFormatException e) {
                System.out.println("범위를 벗어나는 숫자는 입력할 수 없습니다.");
            }
        }

        while (true) {
            sc = new Scanner(System.in); // 버퍼 초기화
            System.out.print("사칙연산 기호를 입력해주세요.(+, -, *, /): ");

            String input3 = sc.nextLine().trim();
            if (input3.length() != 1 || !"+-*/".contains(input3)) {
                System.out.println("잘못된 사칙연산 기호입니다.");
                continue;
            }

            op = input3.charAt(0);
            System.out.printf("입력한 연산자: %c\n", op);
            break;
        }

        long result = 0L;
        boolean isPossible = true;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    isPossible = false;
                    break;
                }
                System.out.println("나눗셈의 경우 소수점이하는 버린 결과가 출력됩니다.");
                result = num1 / num2;
                break;
        }

        if (isPossible) {
            System.out.printf("%d %c %d = %d\n", num1, op, num2, result);
        }

    }
}