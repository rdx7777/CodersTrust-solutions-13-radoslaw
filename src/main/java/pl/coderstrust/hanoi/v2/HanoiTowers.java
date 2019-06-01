package pl.coderstrust.hanoi.v2;

import java.util.Stack;

public class HanoiTowers {

    private static Stack<Integer> towerA = new Stack<>();
    private static Stack<Integer> towerB = new Stack<>();
    private static Stack<Integer> towerC = new Stack<>();

    private HanoiTowers() {}

    public static void hanoiRunner(int numberOfDiscs) {
        HanoiTowers towers = new HanoiTowers();
        towerC.clear();
        towers.fillTowerAWithNumbers(numberOfDiscs);
        towers.printState();
        towers.hanoi(numberOfDiscs, towerA, towerB, towerC);
    }

    private void hanoi(int numberOfDiscs, Stack<Integer> source, Stack<Integer> auxiliary, Stack<Integer> target) {
        if (numberOfDiscs > 0) {
            hanoi(numberOfDiscs - 1, source, target, auxiliary);
            target.push(source.pop());
            printState();
            hanoi(numberOfDiscs - 1, auxiliary, source, target);
        }
    }

    private void fillTowerAWithNumbers(int numberOfDiscs) {
        for (int i = numberOfDiscs; i > 0; i--) {
            towerA.push(i);
        }
    }

    private void printState() {
        System.out.println(towerA.toString() + "; " + towerB.toString() + "; " + towerC.toString());
    }
}
