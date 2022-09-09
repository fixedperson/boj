package boj2042;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        int k = (int)Math.ceil(Math.log(N)/Math.log(2))+1;
        int size = (int)Math.pow(2, k);
        tree = new long[size];
        init(1, N, 1);

        for(int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                long diff = c - arr[b];
                arr[b] = c;
                update(1, N, 1, b, diff);
            }
            else {
                sb.append(sum(1, N, b, (int) c, 1) + "\n");
            }
        }

        bw.write(String.valueOf(sb));

        br.close();
        bw.close();
    }
    static long init(int start, int end, int node){
        if(start == end)
            return tree[node] = arr[start];

        int mid = (start+end)/2;

        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }
    static long sum(int start, int end, int left, int right, int node){
        if(left > end || right < start)
            return 0;

        if(left <= start && right >= end)
            return tree[node];

        int mid = (start+end)/2;
        return sum(start, mid, left, right, node*2) + sum(mid+1, end, left, right, node*2+1);
    }
    static void update(int start, int end, int node, int index, long diff){
        if(index < start || index > end)
            return;

        tree[node] += diff;
        if(start == end)
            return;

        int mid = (start+end)/2;

        update(start, mid, node*2, index, diff);
        update(mid+1, end, node*2+1, index, diff);
    }
}
