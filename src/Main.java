public class Main {

    // Time complexity O(n * sqrt(n))
    // The naive solution
    // Not efficient
    public static int countPrimesNaive(int n) {
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    // helper method
    // checks if a number is prime
    public static boolean isPrime(int n) {

        if (n == 1) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i <= Math.sqrt(n) ; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }

        }

        return true;
    }

    // Sieve of Eratosthenes
    // The efficient method
    // Time complexity - O(n * log (log n))
    public static int countPrimesSieve(int n) {
        int count = 0;

        if (n == 0 || n == 1 || n == 2) {
            return count;
        }

        if (n == 3) {
            return 1;
        }

        // creating an boolean[]
        // false == unmarked
        //true == marked
        boolean[] primes = new boolean[n + 1]; // we want the index to correspond to the numbers


        for (int i = 2; i < n; i++) {
            if (primes[i] == false) {
                for (int j = i * 2 ; j < n; j += i) { // j += i so that j is the next multiple of i
                    primes[j] = true; // marking all the multiples
                }
            }
        }

        for (int i = 2; i < primes.length - 1; i++) {
            if (primes[i] == false) {
                count++;
            }
        }

        return count;
    }

    // Sieve of Eratosthenes
    // The efficient method with a small optimization
    // we start from the first unmarked multiple instead of the first multiple
    // and only iterate till i <= Math.sqrt(n);
    // Time complexity - O(sqrt(n) * log (log n)) --> O(sqrt(n))
    public static int countPrimesSieve2(int n) {
        int count = 0;

        if (n == 0 || n == 1 || n == 2) {
            return count;
        }

        if (n == 3) {
            return 1;
        }

        // creating an boolean[]
        // false == unmarked
        //true == marked
        boolean[] primes = new boolean[n + 1]; // we want the index to correspond to the numbers


        for (int i = 2; i < Math.sqrt(n); i++) { // if i > Math.sqrt(n) --> j = i * i will be greater than n
            if (primes[i] == false) {
                for (int j = i * i ; j < n; j += i) { // j += i so that j is the next multiple of i
                    primes[j] = true; // marking all the multiples
                }
            }
        }

        for (int i = 2; i < primes.length - 1; i++) {
            if (primes[i] == false) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 89999;

        System.out.println(countPrimesNaive(n));
        System.out.println(countPrimesSieve(n));
        System.out.println(countPrimesSieve2(n));



    }
}