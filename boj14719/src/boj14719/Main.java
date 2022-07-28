package boj14719;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int answer = 0;
    static int H, W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        rain();

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void rain(){
        for(int i = 1; i < W-1; i++){
            int left = 0;
            int right = 0;
            int current = arr[i];

            for(int j = i-1; j >= 0; j--){
                if(arr[j] > current){
                    left = Math.max(arr[j], left);
                }
            }

            for(int j = i+1; j < W; j++){
                if(arr[j] > current){
                    right = Math.max(arr[j], right);
                }
            }

            if(Math.min(left, right) > current){
                answer += (Math.min(left, right) - current);
            }
        }
    }
}
