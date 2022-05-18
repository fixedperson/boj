package boj11508;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] price = new int[N];
        for(int i = 0; i < N; i++){
            price[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(price);

        int count = 1;
        int sum = 0;
        for(int i = N-1; i >= 0; i--){
            if(count == 3){
                count = 1;
                continue;
            }
            sum += price[i];
            count++;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
