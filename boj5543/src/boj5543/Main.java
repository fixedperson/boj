package boj5543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Math.min(Math.min(Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine())),Integer.parseInt(br.readLine()));
        int B = Math.min(Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine()));
        System.out.println((A+B - 50));
    }
}
