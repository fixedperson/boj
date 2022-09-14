package boj1517;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr;
    static int[] tree;
    static long count = 0;
    static Map<Long, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(st.nextToken());
            map.put(arr[i], i);
        }

        Arrays.sort(arr);

        tree = new int[N*4];
        for(int i = 1; i <= N; i++){
            int index = map.get(arr[i]);
            count += swapNum(1, N, 1, index + 1, N);
            update(1, N, 1, index);
        }

        bw.write(count + "\n");

        bw.close();
        br.close();
    }
    static int update(int start, int end, int node, int index){
        if(start > index || end < index) return tree[node];

        if(start == end && start == index){
            return tree[node] = 1;
        }

        int mid = (start + end) / 2;

        return tree[node] = update(start, mid, node*2, index) + update(mid + 1, end, node*2+1, index);
    }
    static int swapNum(int start, int end, int node, int left, int right){
        if(left > end || right < start)
            return 0;

        if(left <= start && right >= end)
            return tree[node];

        int mid = (start+end)/2;
        return swapNum(start, mid, node*2, left, right) + swapNum(mid+1, end, node*2+1, left, right);
    }
}
