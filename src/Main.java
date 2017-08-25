/**
 * Created by joaki on 24.08.2017.
 *
 * This program tests exponent calculator algorithms
 * Oppg 2-1-1:
 *
 * +------------+------------------------------+----------+----------+-----------+----------+------------+
 * | Expression | Result                       |Time Alg1 | Expected | Time Alg2 | Expected | Math.pow() |
 * +------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 2^3        | 8                            | 551110   | log(n)   | 2766      |          | 24889      |
 * +------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 2^10       | 1024                         | 790      | 790      | 1185      | 1185     | 790        |
 * +------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 2^20       | 1048576                      | 790      | 1027     | 1976      | 1422     | 395        |
 * +------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 2^30       | 1073741824                   | 790      | 1166     | 1975      | 1422     | 395        |
 * +------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 2^40       | 1099511627776                | 1185     | 1265     | 3556      | 1649     | 395        |
 * +------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 2^50       | 1125899906842624             | 1185     | 1342     | 3950      | 1649     | 395        |
 * +------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 2^60       | 1152921504606846976          | 1580     | 1404     | 3951      | 1649     | 395        |
 * +------------+------------------------------+----------+----------+-----------+----------+------------+
 *
 * Oppg 2-2-1
 * Ved å gjøre kompleksistetsanalyse kommer jeg frem til at:
 * T(0)  =             1
 * T(1)  = 1 + T(0)  = 2
 * T(2)  = 1 + T(1)  = 3
 * T(3)  = 1 + T(1)  = 3
 * T(4)  = 1 + T(2)  = 4
 * T(5)  = 1 + T(2)  = 4
 * T(6)  = 1 + T(3)  = 4
 * T(7)  = 1 + T(3)  = 4
 * T(10) = 1 + T(5)  = 5
 * T(12) = 1 + T(6)  = 5
 * T(15) = 1 + T(7)  = 5
 * T(20) = 1 + T(10) = 6
 * T(25) = 1 + T(12) = 6
 * T(30) = 1 + T(15) = 6
 * T(40) = 1 + T(20) = 7
 * T(50) = 1 + T(25) = 7
 * T(60) = 1 + T(30) = 7
 *
 * Som gir en funksjon T(n) som ser slik ut:
 *
 * |                                ................................
 * |                ................
 * |        ........
 * |    ....
 * |  ..
 * | .
 * |.
 * +---------+---------+---------+---------+---------+---------+
 *
 * Disse tallene stemmer ganske godt overens med forventet tidsforbruk, hvor det ser ut til å være på trappeform
 *
 * Oppg. 3
 * Her ser det ut til at Math.pow har en veldig konstant tidsbruk.
 * Etter litt Google'ing, så har jeg funnet ut at dette skyldes at Math.pow() bruker logaritmer for å regne ut eksponenter
 *
 * Raskest algoritmene til tregest:
 * Math.pow()
 * exponentAlgorithm()
 * exponentAlgorithm2()
 *
 * Andre observasjoner:
 * Det er kostbart å lage datatypen double, og det er raskere å regne med longs
 *
 */
public class Main {
    public static void main(String[] args) {
        // 2^3
        int x = 2;
        int n = 3;
        long start = System.nanoTime();
        double result = Calculator.exponentAlgorithm(x, n);
        long time = System.nanoTime() - start;
        System.out.println("ExponentAlgorithm1: " + result + " Time: " + time);

        x = 2;
        n = 3;
        start = System.nanoTime();
        result = Calculator.exponentAlgorithm2(x, n);
        time = System.nanoTime() - start;
        System.out.println("ExponentAlgorithm2: " + result + " Time: " + time);

        x = 2;
        n = 3;
        start = System.nanoTime();
        result = Math.pow(x, n);
        time = System.nanoTime() - start;
        System.out.println("Math.pow(2, 3)   : " + result + " Time: " + time);


        for (int i = 10; i < 301; i = i + 10) {
            x = 2;
            n = i;
            start = System.nanoTime();
            result = Calculator.exponentAlgorithm(x, n);
            time = System.nanoTime() - start;
            System.out.println("ExponentAlgorithm1: " + result + " Time: " + time);

            x = 2;
            n = i;
            start = System.nanoTime();
            result = Calculator.exponentAlgorithm2(x, n);
            time = System.nanoTime() - start;
            System.out.println("ExponentAlgorithm2: " + result + " Time: " + time);

            x = 2;
            n = i;
            start = System.nanoTime();
            result = Math.pow(x, n);
            time = System.nanoTime() - start;
            System.out.println("Math.pow(2, " + i + ")   : " + result + " Time: " + time);
        }
    }
}
