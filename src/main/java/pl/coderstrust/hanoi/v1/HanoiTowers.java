package pl.coderstrust.hanoi.v1;

import java.util.Stack;

public class HanoiTowers {

    private static class HanoiState {

        private Stack<Integer> towerA;
        private Stack<Integer> towerB;
        private Stack<Integer> towerC;

        private HanoiState(Stack<Integer> towerA, Stack<Integer> towerB, Stack<Integer> towerC) {
            this.towerA = towerA;
            this.towerB = towerB;
            this.towerC = towerC;
        }

        private void printState() {
            System.out.println(towerA.toString() + "; " + towerB.toString() + "; " + towerC.toString());
        }
    }

    public static void hanoiRunner(Stack<Integer> source, Stack<Integer> auxiliary, Stack<Integer> target) {
        HanoiState state = new HanoiState(source, auxiliary, target);
        state.printState();
        hanoi(source.size(), source, auxiliary, target, state);
    }

    private static void hanoi(int numberOfDiscs, Stack<Integer> source, Stack<Integer> auxiliary, Stack<Integer> target, HanoiState hanoiState) {
        if (numberOfDiscs > 0) {
            hanoi(numberOfDiscs - 1, source, target, auxiliary, hanoiState);
            target.push(source.pop());
            hanoiState.printState();
            hanoi(numberOfDiscs - 1, auxiliary, source, target, hanoiState);
        }
    }

    public static void fillTowerAWithNumbers(int numberOfDiscs, Stack<Integer> towerA) {
        for (int i = numberOfDiscs; i > 0; i--) {
            towerA.push(i);
        }
    }
}
