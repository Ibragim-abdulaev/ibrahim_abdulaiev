package ua.abdulaiev.modul1;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        System.out.println("Ход коня в формате 'b1-c3' или 'x' для выхода");
        String  currPos;
        String  nextPos;
        String muve = inputUser.next();
        while (!"x".equals(muve)) {
            currPos = muve.split("-")[0].toLowerCase();
            nextPos = muve.split("-")[1].toLowerCase();
            if (isRightMuve(currPos.charAt(0), Character.digit(currPos.charAt(1),10),
                    nextPos.charAt(0), Character.digit(nextPos.charAt(1),10))) {
                System.out.println("Ход верный");
            } else System.out.println("Так конь не ходит!");
            System.out.println("?");
            muve = inputUser.next();
        }
    }
    private static boolean isRightPositionOnBoard(char letter, int num) {
        return (letter < 'a' || letter > 'h') || (num < 1 || num > 8);
    }

    private static boolean isRightMuve(char letCurrPos, int numCurrPos, char letNewPos, int numNewPos) {
        return (!isRightPositionOnBoard(letCurrPos, numCurrPos) ||
                !isRightPositionOnBoard(letNewPos, numNewPos)) &&
                Math.abs(letCurrPos - letNewPos) + Math.abs(numCurrPos - numNewPos) == 3;
    }
}