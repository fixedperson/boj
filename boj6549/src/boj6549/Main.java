package boj6549;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] tree;
    static int[] arr;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            if(N == 0) break;

            arr = new int[N+1];
            arr[0] = Integer.MAX_VALUE;
            for(int i = 1; i <= N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            answer = 0;
            tree = new int[N*4];
            init(1, N, 1);

            sb.append(maxWidth(1, N) + "\n");
        }

        bw.write(String.valueOf(sb));

        bw.close();
        br.close();
    }
    static int init(int start, int end, int node){
        if(start == end){
            return tree[node] = start;
        }

        int mid = (start + end) / 2;

        int leftIndex = init(start, mid, node*2);
        int rightIndex = init(mid+1, end, node*2+1);

        return tree[node] = arr[leftIndex] < arr[rightIndex] ? leftIndex : rightIndex;
    }
    static int minHeight(int start, int end, int node, int left, int right){
        if(start > right || end < left){
            return 0;
        }

        if(start >= left && end <= right){
            return tree[node];
        }

        int mid = (start + end) / 2;

        int leftIndex = minHeight(start, mid, node*2, left, right);
        int rightIndex = minHeight(mid+1, end, node*2+1, left, right);

        return arr[leftIndex] < arr[rightIndex] ? leftIndex : rightIndex;
    }
    static long maxWidth(int left, int right){
        int index = minHeight(1, N, 1, left, right);

        long width = (right - left + 1) *  (long) arr[index];
        long temp;
        if(left < index){
            temp = maxWidth(left, index - 1);
            width = Math.max(temp, width);
        }

        if(right > index){
            temp = maxWidth(index + 1, right);
            width = Math.max(temp, width);
        }

        return width;
    }
}
