package boj14581;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();

        System.out.print(":fan::fan::fan:\n" +
                ":fan::" + name + "::fan:\n" +
                ":fan::fan::fan:");
    }
}
