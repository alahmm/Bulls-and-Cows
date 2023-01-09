package floating_point_types;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
/*        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        System.out.println(a * 10.5 + b * 4.4 + (c + d) / 2.2);*/


/*        double distance = scanner.nextDouble();
        double time = scanner.nextDouble();
        double averageSpeed = distance / time;
        System.out.println(averageSpeed);*/

        /**
         * converting siliceous to f
         */

/*        double C = scanner.nextDouble();
        double F = C * 1.8 + 32;
        System.out.println(F);*/
        /**
         * double floor = Math.floor(3.78); // floor is 3.0
         * double ceil = Math.ceil(4.15); // ceil is 5.0
         * double sqrt = Math.sqrt(2); // sqrt is 1.4142...
         * double cbrt = Math.cbrt(27.0); // cbrt is 3.0
         * double random = Math.random(); // a random value >= 0.0 and < 1.0
         * double pi = Math.PI; // pi is 3.1415...
         * double e = Math.E; // e is 2.71828...
         */
/*        double x = scanner.nextDouble();
        System.out.println(Math.pow(x,3) + Math.pow(x,2) + x + 1);*/

        /**
         * calculating the area of a triangle
         */

/*        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();
        double p = (a + b + c) / 2;
        double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println(S);*/

        /**
         * calculating angle between two vectors
         */

        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double cosAngle = (x1 * x2 + y1 * y2) /Math.sqrt((Math.pow(x1,2) + Math.pow(y1, 2)) * (Math.pow(x2,2) + Math.pow(y2, 2)));
        double variable = Math.toDegrees(Math.acos(cosAngle));
        System.out.println(Math.round(variable));

    }
}
