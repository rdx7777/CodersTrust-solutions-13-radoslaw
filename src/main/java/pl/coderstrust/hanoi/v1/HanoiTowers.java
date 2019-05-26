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

    private HanoiTowers() {}

    public static void hanoiRunner(int numberOfDiscs, Stack<Integer> source, Stack<Integer> auxiliary, Stack<Integer> target) {
        HanoiTowers towers = new HanoiTowers();
        HanoiState state = new HanoiState(source, auxiliary, target);
        towers.fillListAWithNumbers(numberOfDiscs, source);
        state.printState();
        towers.hanoi(source.size(), source, auxiliary, target, state);
    }

    private void hanoi(int numberOfDiscs, Stack<Integer> source, Stack<Integer> auxiliary, Stack<Integer> target, HanoiState hanoiState) {
        if (numberOfDiscs > 0) {
            hanoi(numberOfDiscs - 1, source, target, auxiliary, hanoiState);
            target.push(source.pop());
            hanoiState.printState();
            hanoi(numberOfDiscs - 1, auxiliary, source, target, hanoiState);
        }
    }

    private void fillListAWithNumbers(int numberOfDiscs, Stack<Integer> towerA) {
        for (int i = numberOfDiscs; i > 0; i--) {
            towerA.push(i);
        }
    }
}
