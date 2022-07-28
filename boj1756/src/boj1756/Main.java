package boj1756;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] oven = new int[D];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < D; i++){
            oven[i] = Integer.parseInt(st.nextToken());

            if(i >= 1){
                oven[i] = Math.min(oven[i], oven[i-1]);
            }
        }

        int pre_index = D;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int diam = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = pre_index;
            while(left < right){
                int mid = (left + right) / 2;

                if(oven[mid] < diam){
                    right = mid;
                }

                else {
                    left = mid + 1;
                }
            }

            if(right == 0){
                System.out.println("0");
                System.exit(0);
            }

            pre_index = right-1;
        }

        bw.write((pre_index+1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
