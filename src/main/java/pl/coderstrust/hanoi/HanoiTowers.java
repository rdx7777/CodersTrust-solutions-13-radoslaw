package pl.coderstrust.hanoi;

import java.util.Stack;

public class HanoiTowers {

    private static class HanoiState {

        private Stack<Integer> listA;
        private Stack<Integer> listB;
        private Stack<Integer> listC;

        private HanoiState(Stack<Integer> listA, Stack<Integer> listB, Stack<Integer> listC) {
            this.listA = listA;
            this.listB = listB;
            this.listC = listC;
        }

        private void printState() {
            System.out.println(listA.toString() + "; " + listB.toString() + "; " + listC.toString());
        }
    }

    public void hanoiRunner(int numberOfDiscs, Stack<Integer> source, Stack<Integer> auxiliary, Stack<Integer> target) {
        HanoiState state = new HanoiState(source, auxiliary, target);
        fillListAWithNumbers(numberOfDiscs, source);
        state.printState();
        hanoi(source.size(), source, auxiliary, target, state);
    }

    private void hanoi(int numberOfDiscs, Stack<Integer> listA, Stack<Integer> listB, Stack<Integer> listC, HanoiState hanoiState) {
        if (numberOfDiscs > 0) {
            hanoi(numberOfDiscs - 1, listA, listC, listB, hanoiState);
            listC.push(listA.pop());
            hanoiState.printState();
            hanoi(numberOfDiscs - 1, listB, listA, listC, hanoiState);
        }
    }

    private void fillListAWithNumbers(int numberOfDiscs, Stack<Integer> listA) {
        for (int i = numberOfDiscs; i > 0; i--) {
            listA.push(i);
        }
    }
}
