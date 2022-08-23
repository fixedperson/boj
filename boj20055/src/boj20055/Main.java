package boj20055;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] belts;
    static int stage = 0;
    static boolean[] isRobot;
    static int zeroCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belts = new int[N*2];
        isRobot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N*2; i++){
            belts[i] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            stage++;

            rotate();
            convey();
            addRobot();

            if(zeroCnt >= K) break;
        }

        bw.write(stage + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void rotate() {
        int temp = belts[N*2-1];

        for(int i = N*2-1; i > 0; i--){
            belts[i] = belts[i-1];
        }
        belts[0] = temp;

        for(int i = N-1; i > 0; i--){
            isRobot[i] = isRobot[i-1];
        }
        isRobot[0] = false;
        isRobot[N-1] = false;
    }

    static void convey() {
        for(int i = N-1; i > 0; i--){
            if(!isRobot[i-1]) continue;

            if(!isRobot[i] && belts[i] >= 1){
                isRobot[i] = true;
                isRobot[i-1] = false;

                belts[i]--;
                if(belts[i] == 0){
                    zeroCnt++;
                }
            }
        }
    }

    static void addRobot() {
        if(belts[0] >= 1){
            isRobot[0] = true;

            belts[0]--;
            if(belts[0] == 0){
                zeroCnt++;
            }
        }
    }
}
