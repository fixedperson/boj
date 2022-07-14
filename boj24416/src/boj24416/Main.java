package boj24416;

import java.io.*;

public class Main {
    static int code1 = 1;
    static int code2 = 0;
    static int[] f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        f = new int[n+1];
        f[1] = 1;
        f[2] = 1;

        fib(n);
        fibonacci(n);

        bw.write(code1 + " " + code2);
        bw.flush();
        bw.close();
        br.close();
    }
    static int fib(int n) {
        if (n == 1 || n == 2)
            return 1;
        else {
            code1++;
            return (fib(n - 1) + fib(n - 2));
        }
    }

    static int fibonacci(int n) {
        for(int i = 3; i <= n; i++) {
            code2++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
