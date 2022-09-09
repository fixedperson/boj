package boj11505;

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] arr, tree;
    private static final int remain = 1000000007;
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
        Arrays.fill(arr, 1);
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        tree = new long[N*4];
        init(1, N, 1);

        for(int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                arr[b] = c;
                update(1, N, 1, b, c);
            }

            else {
                sb.append(multiply(1, N, b, c ,1) + "\n");
            }
        }

        bw.write(String.valueOf(sb));

        br.close();
        bw.close();
    }
    static long init (int start, int end, int node){
        if(start == end)
            return tree[node] = arr[start];

        int mid = (start + end) / 2;

        return tree[node] = (init(start, mid, node*2) * init(mid + 1, end, node*2 + 1)) % remain;
    }
    static long multiply(int start, int end, int left, int right, int node){
        if(left > end || right < start)
            return 1;

        if(left <= start && right >= end)
            return tree[node];

        int mid = (start+end)/2;

        return (multiply(start, mid, left, right, node*2) * multiply(mid+1, end, left, right, node*2+1)) % remain;
    }
    static long update(int start, int end, int node, int index, long changeValue){
        if(index < start || index > end)
            return tree[node];

        else if(start == index && end == index)
            return tree[node] = changeValue;

        else {
            int mid = (start + end) / 2;

            return tree[node] = (update(start, mid, node*2, index, changeValue) * update(mid+1, end, node*2+1, index, changeValue)) % remain;
        }
    }
}
