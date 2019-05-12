package pl.coderstrust.sieve;

public class SieveOfEratosthenes {
    public static int[] sieve(int maximumNumber) {

        int[] array = new int[maximumNumber];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        for (int i = 2; i < array.length; i++) {
            for (int j = i * 2; j < array.length; j += i) {
                array[j] = 0;
            }
        }
        int numberOfPrimes = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 1) {
                numberOfPrimes++;
            }
        }
        int[] arrayOfPrimes = new int[numberOfPrimes];
        int indexOfArrayOfPrimes = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 1) {
                arrayOfPrimes[indexOfArrayOfPrimes] = array[i];
                indexOfArrayOfPrimes++;
            }
        }
        System.out.print(indexOfArrayOfPrimes + " / " + maximumNumber + " ---> ");
        return arrayOfPrimes;
    }
}
