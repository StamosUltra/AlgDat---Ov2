/**
 * Created by joaki on 24.08.2017.
 *
 * This program tests exponent calculator algorithms
 * Oppg 2-1-1:
 * T(n) = T(n-1) + 1
 * Dette er en linjeær funksjon, fordi antall funksjonkall er bestemt av antall n
 * n gir n-1 funksjonstall som går mot n når n blir stor.
 * T(n) element i Ø(n)
 *
 *
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 * | Expression  | Result                       |Time Alg1 | Expected | Time Alg2 | Expected | Math.pow() |
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 1.0005^1    | 1.0005                       | 326715   | n        | 5531      | log(n)   | 19753      |
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 1.0005^500  | 12.106842099040202           | 25284    | 35896    | 1580      | 1580     | 790        |
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 1.0005^1000 | 146.57562561109216           | 39901    | 39901    | 2371      | 1755     | 395        |
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 1.0005^1500 | 1774.567954841526            | 44247    | 42242    | 1975      | 1858     | 395        |
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 1.0005^2000 | 21484.414023283058           | 9087     | 43903    | 1975      | 1931     | 395        |
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 1.0005^2500 | 260108.40817029303           | 22519    | 45192    | 1975      | 1987     | 395        |
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 1.0005^3000 | 3149091.426350436            | 34766    | 46245    | 1580      | 2034     | 395        |
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 1.0005^3500 | 3.8125552654266015E7         | 35555    | 47136    | 1975      | 2073     | 395        |
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 1.0005^4000 | 4.615800459238418E8          | 22518    | 47907    | 1975      | 2107     | 395        |
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 1.0005^4500 | 5.5882767320676775E9         | 52939    | 48568    | 3161      | 2137     | 395        |
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 * | 1.0005^5000 | 6.765638400088376E10         | 45037    | 49196    | 1975      | 2163     | 395        |
 * +-------------+------------------------------+----------+----------+-----------+----------+------------+
 *
 *
 * Oppg 2-2-1
 * Ved å bruke generell metode tidskompleksitet
 *
 * Som gir en funksjon T(n) som ser slik ut:
 *
 * T(n) = T((n-1)/2) + 1
 * a = 1
 * b = 2
 * k = 0
 *
 * b^k = 1 = a => T(n) element i Ø(n^k * log(n) = Ø(log(n))
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
        double x = 1.005;
        int n = 1;
        long start = System.nanoTime();
        double result = Calculator.exponentAlgorithm(x, n);
        long time = System.nanoTime() - start;
        System.out.println("ExponentAlgorithm1: " + result + " Time: " + time);

        n = 3;
        start = System.nanoTime();
        result = Calculator.exponentAlgorithm2(x, n);
        time = System.nanoTime() - start;
        System.out.println("ExponentAlgorithm2: " + result + " Time: " + time);

        n = 1;
        start = System.nanoTime();
        result = Math.pow(x, n);
        time = System.nanoTime() - start;
        System.out.println("Math.pow(2, 3)   : " + result + " Time: " + time);


        for (int i = 500; i <= 7000; i = i + 500) {
            n = i;
            start = System.nanoTime();
            result = Calculator.exponentAlgorithm(x, n);
            time = System.nanoTime() - start;
            System.out.println("ExponentAlgorithm1: " + result + " Time: " + time);

            n = i;
            start = System.nanoTime();
            result = Calculator.exponentAlgorithm2(x, n);
            time = System.nanoTime() - start;
            System.out.println("ExponentAlgorithm2: " + result + " Time: " + time);

            n = i;
            start = System.nanoTime();
            result = Math.pow(x, n);
            time = System.nanoTime() - start;
            System.out.println("Math.pow(1.0005, " + i + ")   : " + result + " Time: " + time);
        }
    }
}
