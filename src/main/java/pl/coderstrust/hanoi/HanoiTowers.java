package pl.coderstrust.hanoi;

import java.util.Stack;

public class HanoiTowers {

    public static void main(String[] args) {
        Stack<Integer> listA = new Stack<>();
        Stack<Integer> listB = new Stack<>();
        Stack<Integer> listC = new Stack<>();
        int n = 4;
        fillListAWithNumbers(n, listA);
        System.out.println("Original stack A: " + listA.toString() + "; (size: " + listA.size() + ")");
        hanoiWithShowingProcess(n, listA, listB, listC);
        System.out.println();
        System.out.println("Original stack A: " + listA.toString() + "; (size: " + listA.size() + ")");
        System.out.println("Result stack C: " + listC.toString() + "; (size: " + listC.size() + ")");
    }

    public static void hanoiWithShowingProcess(int numberOfDiscs, Stack<Integer> listA, Stack<Integer> listB, Stack<Integer> listC) {
        if (numberOfDiscs > 0) {
            hanoiWithShowingProcess(numberOfDiscs - 1, listA, listC, listB);
            int disc = listA.peek();
            System.out.println("Moving disc nr " + disc + " from " + listA.toString() + " to " + listC.toString());
            disc = listA.pop();
            listC.push(disc);
            hanoiWithShowingProcess(numberOfDiscs - 1, listB, listA, listC);
        }
    }

    public static void fillListAWithNumbers(int numberOfDiscs, Stack<Integer> listA) {
        for (int i = numberOfDiscs; i > 0; i--) {
            listA.push(i);
        }
    }

    public static void hanoi(int numberOfDiscs, Stack<Integer> listA, Stack<Integer> listB, Stack<Integer> listC) {
        if (numberOfDiscs > 0) {
            hanoi(numberOfDiscs - 1, listA, listC, listB);
            listC.push(listA.pop());
            hanoi(numberOfDiscs - 1, listB, listA, listC);
        }
    }
}
