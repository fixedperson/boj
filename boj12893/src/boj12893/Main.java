package boj12893;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int[] enemy;
    static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        enemy = new int[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            A = find(A);
            B = find(B);

            if(A == B){
                answer = 0;
                break;
            }

            else {
                if(enemy[A] != 0){
                    union(enemy[A], B);
                }
                else
                    enemy[A]= B;

                if(enemy[B] != 0){
                    union(enemy[B], A);
                }
                else
                    enemy[B]= A;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static int find(int x){
        if(x == parents[x])
            return x;
        else
            return parents[x] = find(parents[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            if(x > y){
                int temp = y;
                y = x;
                x = temp;
            }
            parents[y] = x;
        }
    }
}
