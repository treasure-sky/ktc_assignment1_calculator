package dev.jino.calculator.Lv3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArithmeticCalculator {

    private static final List<BigInteger> resultList = new ArrayList<>();

    /**
     * 두 정수와 연산자를 받아 연산을 진행하는 메서드
     *
     * @param num1     피연산자1
     * @param num2     피연산자2
     * @param opSymbol 연산자
     * @return num1 opSymbol num2 결과를 반환함
     */
    public static BigInteger calculate(BigInteger num1, BigInteger num2, char opSymbol) {
        BigInteger result = BigInteger.ZERO;
        OperatorType op = OperatorType.find(opSymbol);
        switch (op) {
            case PLUS:
                result = num1.add(num2);
                break;

            case MINUS:
                result = num1.subtract(num2);
                break;

            case MULTIPLY:
                result = num1.multiply(num2);
                break;

            case DIVIDE:
                if (num2.equals(BigInteger.ZERO)) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                result = num1.divide(num2);
                break;
        }
        resultList.add(result);
        return result;

    }


    public static BigInteger getResultByIdx(int idx) {
        return resultList.get(idx);
    }

    public static List<BigInteger> getResultList() {
        return Collections.unmodifiableList(resultList);
    }

    /**
     * 결과 수정 메서드
     *
     * @param idx 수정하려는 결과 인덱스
     * @param num 수정된 결과
     */
    public static void setResultByIdx(int idx, BigInteger num) {
        try {
            resultList.set(idx, num);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("존재하지 않는 결과 번호 입니다.");
        }
    }

    /**
     * 가장 처음 입력된 결과 삭제 메서드
     *
     * @return 삭제된 결과값
     */
    public static BigInteger removeResult() {
        return resultList.remove(0);
    }
}