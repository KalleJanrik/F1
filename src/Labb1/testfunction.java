package Labb1;

public class testfunction {
    public static void main(String[] args) {
        int r = 0, n = 0;
        while (n <= 20) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    for (int k = j; k <= i + j; k++) {
                        for (int m = 1; m <= i + j - k; m++) {
                            r++;// Enkel sats
                        }
                    }
                }
            }
            System.out.print(r + " ");
            n++;
            r = 0;
        }
        System.out.println("\n\n\n");
        r=0;n=0;

        while (n <= 100) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    for (int k = j; k <= i + j; k++) {
                        for (int m = 1; m <= i + j - k; m++) {
                            r++;// Enkel sats
                        }
                    }
                }
            }
            System.out.print(r + " ");
            n++;
            r = 0;
        }
    }

}
