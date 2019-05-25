package pl.coderstrust.hanoi;

import java.util.Stack;

public class Demo {

    public static void main(String[] args) {

        HanoiTowers scenario1 = new HanoiTowers();
        Stack<Integer> listA = new Stack<>();
        Stack<Integer> listB = new Stack<>();
        Stack<Integer> listC = new Stack<>();
        int numberOfDiscs = 4;
        scenario1.hanoiRunner(numberOfDiscs, listA, listB, listC);
        System.out.println();

        HanoiTowers2 scenario2 = new HanoiTowers2();
        scenario2.hanoiRunner(numberOfDiscs);
    }
}
