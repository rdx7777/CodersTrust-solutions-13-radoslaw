package pl.coderstrust.hanoi;

import java.util.Stack;

public class Demo {

    public static void main(String[] args) {
        Stack<Integer> listA = new Stack<>();
        Stack<Integer> listB = new Stack<>();
        Stack<Integer> listC = new Stack<>();
        int numberOfDiscs = 4;
        pl.coderstrust.hanoi.v1.HanoiTowers.hanoiRunner(numberOfDiscs, listA, listB, listC);
        System.out.println();
        pl.coderstrust.hanoi.v2.HanoiTowers.hanoiRunner(numberOfDiscs);
    }
}
