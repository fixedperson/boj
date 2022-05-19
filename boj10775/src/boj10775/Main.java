package boj10775;

import java.io.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parents = new int[G+1];
        for(int i = 1; i <= G; i++){
            parents[i] = i;
        }

        int[] plane = new int[P];
        for(int i = 0; i < P; i++){
            plane[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i = 0; i < P; i++){
            int temp = find(plane[i]);
            if(temp == 0){
                break;
            }
            union(temp, temp-1);
            answer++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
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
            parents[x] = y;
        }
    }
}
