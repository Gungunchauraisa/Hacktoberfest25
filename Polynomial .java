import java.util.Scanner;

class Polynomial {
    private int degree;
    private int[] coefficients;

    public Polynomial(int degree) {
        this.degree = degree;
        coefficients = new int[degree + 1];
    }

    public void inputPolynomial() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coefficients from highest degree to constant term:");
        for (int i = degree; i >= 0; i--) {
            System.out.print("Coefficient of x^" + i + ": ");
            coefficients[i] = sc.nextInt();
        }
    }

    public void displayPolynomial() {
        System.out.print("Polynomial: ");
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] != 0) {
                System.out.print(coefficients[i] + "x^" + i);
                if (i != 0) System.out.print(" + ");
            }
        }
        System.out.println();
    }

    public Polynomial add(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.degree);
        Polynomial result = new Polynomial(maxDegree);

        for (int i = 0; i <= maxDegree; i++) {
            int coeff1 = (i <= this.degree) ? this.coefficients[i] : 0;
            int coeff2 = (i <= p.degree) ? p.coefficients[i] : 0;
            result.coefficients[i] = coeff1 + coeff2;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter degree of first polynomial: ");
        int degree1 = sc.nextInt();
        Polynomial p1 = new Polynomial(degree1);
        p1.inputPolynomial();

        System.out.print("Enter degree of second polynomial: ");
        int degree2 = sc.nextInt();
        Polynomial p2 = new Polynomial(degree2);
        p2.inputPolynomial();

        System.out.println("\nFirst ");
        p1.displayPolynomial();

        System.out.println("Second ");
        p2.displayPolynomial();

        Polynomial sum = p1.add(p2);
        System.out.println("Sum ");
        sum.displayPolynomial();
    }
}
