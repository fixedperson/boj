package boj1091;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = i%3;
        }
        int[] P = new int[N];
        int[] S = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        while(true){
            if(isSameArr(arr, P))
                break;

            int[] temp = new int[N];
            for(int i = 0; i < N; i++){
                temp[i] = arr[S[i]];
            }
            arr = temp;
            count++;

            if(isSameStart(arr)){
                count = -1;
                break;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }

    static boolean isSameArr(int[] A, int[] B){
        for(int i = 0; i < N; i++){
            if(A[i] == B[i]) continue;
            return false;
        }
        return true;
    }

    static boolean isSameStart(int[] A){
        for(int i = 0; i < N; i++){
            if(A[i] == i%3) continue;
            return false;
        }
        return true;
    }
}
