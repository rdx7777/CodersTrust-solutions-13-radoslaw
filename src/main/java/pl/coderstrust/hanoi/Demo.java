package pl.coderstrust.hanoi;

import java.util.Stack;

public class Demo {

    public static void main(String[] args) {
        Stack<Integer> towerA = new Stack<>();
        Stack<Integer> towerB = new Stack<>();
        Stack<Integer> towerC = new Stack<>();
        int numberOfDiscs = 4;
        pl.coderstrust.hanoi.v1.HanoiTowers.fillTowerAWithNumbers(numberOfDiscs, towerA);
        pl.coderstrust.hanoi.v1.HanoiTowers.hanoiRunner(towerA, towerB, towerC);
        System.out.println();
        pl.coderstrust.hanoi.v2.HanoiTowers.hanoiRunner(numberOfDiscs);
    }
}
