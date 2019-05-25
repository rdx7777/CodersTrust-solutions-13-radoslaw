package pl.coderstrust.hanoi;

import java.util.Stack;

public class HanoiTowers2 {

    private Stack<Integer> listA = new Stack<>();
    private Stack<Integer> listB = new Stack<>();
    private Stack<Integer> listC = new Stack<>();

    public void hanoiRunner(int numberOfDiscs) {
        listC.clear();
        fillListAWithNumbers(numberOfDiscs);
        printState();
        hanoi(numberOfDiscs, listA, listB, listC);
    }

    private void hanoi(int numberOfDiscs, Stack<Integer> A, Stack<Integer> B, Stack<Integer> C) {
        if (numberOfDiscs > 0) {
            hanoi(numberOfDiscs - 1, A, C, B);
            C.push(A.pop());
            printState();
            hanoi(numberOfDiscs - 1, B, A, C);
        }
    }

    private void fillListAWithNumbers(int numberOfDiscs) {
        for (int i = numberOfDiscs; i > 0; i--) {
            listA.push(i);
        }
    }

    private void printState() {
        System.out.println(listA.toString() + "; " + listB.toString() + "; " + listC.toString());
    }
}
