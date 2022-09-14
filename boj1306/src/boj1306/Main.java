package boj1306;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[N*4];
        init(1, N, 1);

        for(int i = M; i <= N-M+1; i++){
            sb.append(maxValue(1, N, 1, i-(M-1), i+(M-1)) + " ");
        }

        bw.write(String.valueOf(sb));

        bw.close();
        br.close();
    }
    static int init(int start, int end, int node){
        if(start == end)
            return tree[node] = arr[start];

        int mid = (start + end) / 2;

        return tree[node] = Math.max(init(start, mid, node*2), init(mid+1, end, node*2+1));
    }
    static int maxValue(int start, int end, int node, int left, int right){
        if(start > right || end < left)
            return 0;

        if(left <= start && right >= end)
            return tree[node];

        int mid = (start + end) / 2;

        return Math.max(maxValue(start, mid, node*2, left, right), maxValue(mid+1, end, node*2+1, left, right));
    }
}
