package boj10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[300];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int v = Integer.parseInt(st.nextToken());
            if(v < 0){
                v += 201;
            }
            arr[v]++;
        }

        int v = Integer.parseInt(br.readLine());

        if(v < 0){
            v += 201;
        }

        System.out.println(arr[v]);
    }
}
