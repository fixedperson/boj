package boj16235;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] nutrient;
    static PriorityQueue[][] tree;
    static int N;
    static int[] dx = {-1,-1,-1,1,1,1,0,0};
    static int[] dy = {-1,0,1,-1,0,1,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tree = new PriorityQueue[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                tree[i][j] = new PriorityQueue<Integer>();
            }
        }

        nutrient = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            Arrays.fill(nutrient[i], 5);
        }

        int[][] A = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            tree[x][y].add(age);
        }

        while(K-- > 0){
            SprSum();
            autumn();
            winter(A);
        }

        int answer = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                answer += tree[i][j].size();
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 봄, 여름
    static void SprSum(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                PriorityQueue<Integer> src = tree[i][j];
                PriorityQueue<Integer> dst = new PriorityQueue<>();

                while(!src.isEmpty()){
                    int temp = src.poll();
                    if(temp <= nutrient[i][j]){
                        nutrient[i][j] -= temp;
                        dst.add(temp + 1);
                    }
                    else {
                        src.add(temp);
                        break;
                    }
                }

                while(!src.isEmpty()){
                    nutrient[i][j] += src.poll() / 2;
                }

                tree[i][j] = dst;
            }
        }
    }

    // 가을
    static void autumn(){
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                PriorityQueue<Integer> src = tree[i][j];
                PriorityQueue<Integer> dst = new PriorityQueue<>();

                while(!src.isEmpty()){
                    int temp = src.poll();
                    if(temp % 5 == 0){
                        for(int k = 0; k < 8; k++){
                            int x = i + dx[k];
                            int y = j + dy[k];
                            if(x < 1 || x > N || y < 1 || y > N) continue;
                            tree[x][y].add(1);
                        }
                    }
                    dst.add(temp);
                }
                tree[i][j] = dst;
            }
        }
    }

    // 겨울
    static void winter(int[][] A){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                nutrient[i][j] += A[i][j];
            }
        }
    }
}
