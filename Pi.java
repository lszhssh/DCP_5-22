public class Pi {
    // Problem from 5/27/22:

    // The area of a circle is defined as πr^2. Estimate π to 3 decimal places using
    // a Monte Carlo method.
    // Hint: The basic equation of a circle is x^2 + y^2 = r^2.

    // Solution time: 26 minutes

    public static double estimPi(double r, int iter) {
        int numInCircle = 0;
        int numOutCircle = 0;
        for (int i = 0; i < iter; i++) {
            double x = Math.random() * 2 * r - r;
            double y = Math.random() * 2 * r - r;
            if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2)) {
                numInCircle++;
            } else {
                numOutCircle++;
            }
        }
        double estim = (double) (4 * numInCircle) / (double) (numInCircle + numOutCircle);
        return estim;
    }

    public static void main(String[] args) {
        System.out.println(estimPi(5.0, 1000000));
    }
}