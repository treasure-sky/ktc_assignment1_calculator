package dev.jino.calculator.Lv2;

import static dev.jino.calculator.Lv2.Calculator.calculate;
import static dev.jino.calculator.Lv2.Calculator.getResultByIdx;
import static dev.jino.calculator.Lv2.Calculator.getResultList;
import static dev.jino.calculator.Lv2.Calculator.removeResult;
import static dev.jino.calculator.Lv2.Calculator.setResultByIdx;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc;
        BigInteger num1, num2; // 모든 범위의 양의 정수를 입력 가능하도록 하기 위해 Lv2 부터 BigInteger를 사용하였음.
        char op;

        while (true) {
            while (true) {
                sc = new Scanner(System.in);

                List<BigInteger> resultList = getResultList();
                if (resultList.isEmpty()) {
                    break;
                }

                System.out.println("<현재까지의 계산 결과 목록>");
                for (int i = 0; i < resultList.size(); i++) {
                    System.out.printf("%d. %d\n", (i + 1), resultList.get(i));
                }
                System.out.print(
                    """
                        위 결과를 수정하시려면 modify 와 결과 번호, 수정값을 입력해주세요. (e.g. modify 1 100)
                        가장 먼저 저장된 결과를 삭제하기를 원하신다면 remove 를 입력해주세요.
                        계산을 원하시는 경우 아무 문자나 입력해주세요.:\s""");
                String input = sc.next();
                if (input.equals("modify")) {
                    int idx = -1;
                    BigInteger num = BigInteger.ZERO;
                    try {
                        idx = sc.nextInt();
                        num = sc.nextBigInteger();
                    } catch (InputMismatchException e) {
                        System.out.println("modify 형식이 맞지 않습니다. 처음단계로 이동합니다.");
                        continue;
                    }

                    try {
                        setResultByIdx(idx - 1, num); // idx는 0부터 시작하므로 -1
                        System.out.printf("%d번째 결과가 %d로 수정완료 되었습니다.\n", idx,
                            getResultByIdx(idx - 1));
                        continue;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (input.equals("remove")) {
                    BigInteger removedNum = removeResult();
                    System.out.printf("1번째 결과 %d가 삭제되었습니다.\n", removedNum);
                    continue;
                }
                break;


            }

            while (true) {
                sc = new Scanner(System.in);
                System.out.print("첫 번째 숫자를 입력하세요.(0을 포함한 양의 정수 이어야 합니다.): ");

                try {
                    num1 = sc.nextBigInteger();
                } catch (InputMismatchException e) {
                    System.out.println("정수의 형태로 입력해주세요.");
                    continue;
                }

                if (num1.compareTo(BigInteger.ZERO) < 0) {
                    System.out.println("음수는 입력할 수 없습니다.");
                    continue;
                }

                System.out.printf("첫 번째 입력 숫자: %d\n", num1);
                break;
            }

            while (true) {
                sc = new Scanner(System.in);
                System.out.print("두 번째 숫자를 입력하세요.(0을 포함한 양의 정수 이어야 합니다.): ");

                try {
                    num2 = sc.nextBigInteger();
                } catch (InputMismatchException e) {
                    System.out.println("정수의 형태로 입력해주세요.");
                    continue;
                }

                if (num2.compareTo(BigInteger.ZERO) < 0) {
                    System.out.println("음수는 입력할 수 없습니다.");
                    continue;
                }

                System.out.printf("두 번째 입력 숫자: %d\n", num2);
                break;
            }

            while (true) {
                sc = new Scanner(System.in); // 버퍼 초기화
                System.out.print("사칙연산 기호를 입력해주세요.(+, -, *, /): ");

                String inputOp = sc.nextLine().trim();
                if (inputOp.length() != 1 || !"+-*/".contains(inputOp)) {
                    System.out.println("잘못된 사칙연산 기호입니다.");
                    continue;
                }

                op = inputOp.charAt(0);
                System.out.printf("입력한 연산자: %c\n", op);
                break;
            }

            try {
                BigInteger result = calculate(num1, num2, op);
                System.out.printf("%d %c %d = %d\n", num1, op, num2, result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            sc = new Scanner(System.in);
            System.out.print("종료하시려면 exit 를 입력해주세요. 계속 진행을 원하는 경우 아무 입력을 해주세요: ");
            if (sc.next().equals("exit")) {
                break;
            }

        }
        System.out.println("시스템을 종료합니다.");
    }
}