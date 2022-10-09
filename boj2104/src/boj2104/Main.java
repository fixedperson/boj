package boj2104;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;
    static int[] minSeg;
    static long[] sumSeg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        arr[0] = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        minSeg = new int[N*4];
        minInit(1, N, 1);

        sumSeg = new long[N*4];
        sumInit(1, N, 1);

        bw.write(query(1, N) + "\n");

        bw.close();
        br.close();
    }
    static int minInit(int start, int end, int node){
        if(start == end) return minSeg[node] = start;

        int mid = (start + end) / 2;

        int left = minInit(start, mid, node*2);
        int right = minInit(mid+1, end, node*2+1);

        return minSeg[node] = arr[left] < arr[right] ? left : right;
    }
    static long sumInit(int start, int end, int node){
        if(start == end) return sumSeg[node] = arr[start];

        int mid = (start + end) / 2;

        return sumSeg[node] = sumInit(start, mid, node*2) + sumInit(mid+1, end, node*2+1);
    }
    static long segSum(int start, int end, int left, int right, int node){
        if(left > end || right < start)
            return 0;

        if(left <= start && right >= end)
            return sumSeg[node];

        int mid = (start+end)/2;
        return segSum(start, mid, left, right, node*2) + segSum(mid+1, end, left, right, node*2+1);
    }
    static int segMin(int start, int end, int left, int right, int node){
        if(left > end || right < start)
            return 0;

        if(left <= start && right >= end)
            return minSeg[node];

        int mid = (start + end) / 2;

        int l = segMin(start, mid, left, right, node*2);
        int r = segMin(mid+1, end, left, right, node*2+1);

        return arr[l] < arr[r] ? l : r;
    }
    static long query(int left, int right){
        int minIdx = segMin(1, N, left, right, 1);
        long ans = segSum(1, N, left, right, 1) * arr[minIdx];

        if(left == right) return ans;

        if(left < minIdx){
            long temp = query(left,  minIdx-1);
            ans = Math.max(ans, temp);
        }

        if(right > minIdx){
            long temp = query(minIdx+1, right);
            ans = Math.max(ans, temp);
        }

        return ans;
    }
}
