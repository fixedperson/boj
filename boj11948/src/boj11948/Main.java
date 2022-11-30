package boj11948;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[4];

        for(int i = 0; i < 4; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] arr2 = new int[2];

        for(int i = 0; i < 2; i++){
            arr2[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        Arrays.sort(arr2);
        int sum=0;
        for(int i = 1; i <= 3; i++){
            sum += arr[i];
        }

        sum+= arr2[1];

        bw.write(sum + "\n");

        bw.close();
        br.close();
    }
}
