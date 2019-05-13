package pl.coderstrust.sieve;

public class SieveOfEratosthenes {
    public static int[] sieve(int maximumNumber) {
        if (maximumNumber < 2) {
            return new int[0];
        }
        int[] array = createInitialArray(maximumNumber);
        markNonePrimeNumbers(array);
        return extractPrimesNumbers(array);
    }

    private static int[] createInitialArray(int maximumNumber) {
        int[] array = new int[maximumNumber];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    private static void markNonePrimeNumbers(int[] array) {
        for (int i = 2; i < array.length; i++) {
            for (int j = i * 2; j < array.length; j += i) {
                array[j] = 0;
            }
        }
    }

    private static int[] extractPrimesNumbers(int[] array) {
        int numberOfPrimes = getCountOfPrimeNumbers(array);
        int[] arrayOfPrimes = new int[numberOfPrimes];
        int indexOfArrayOfPrimes = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 1) {
                arrayOfPrimes[indexOfArrayOfPrimes] = array[i];
                indexOfArrayOfPrimes++;
            }
        }
        return arrayOfPrimes;
    }

    private static int getCountOfPrimeNumbers(int[] array) {
        int numberOfPrimes = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 1) {
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }
}
