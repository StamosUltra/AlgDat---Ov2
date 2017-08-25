/**
 * Created by joaki on 24.08.2017.
 *
 * This class contains one static method that works recursively
 */
public class Calculator {
    public static double exponentAlgorithm(int x, int n) {
        if (n == 0) return 1L;
        else return x * exponentAlgorithm(x, n-1);
    }

    public static double exponentAlgorithm2(int x, int n) {
        if (n == 0) return 1;
        else if (n % 2 != 0) { // checks to see if it's an odd number
            return x * exponentAlgorithm2(x, (n-1)/2) * exponentAlgorithm2(x, (n-1)/2);

        }
        else { // else it's a even number
            return exponentAlgorithm2(x, n/2) * exponentAlgorithm2(x, n/2);
        }
    }
}
