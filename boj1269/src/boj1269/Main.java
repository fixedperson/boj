package boj1269;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            setB.add(Integer.parseInt(st.nextToken()));
        }

        int num = 0;
        HashSet<Integer> temp = new HashSet<>(setA);
        temp.removeAll(setB);
        num += temp.size();

        temp = new HashSet<>(setB);
        temp.removeAll(setA);
        num += temp.size();

        bw.write(String.valueOf(num));
        bw.close();
        br.close();
    }
}
