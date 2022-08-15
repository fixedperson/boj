package bojContestb;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        long sum = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());

            arr[i] = a;
            sum += b;
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            sum += (arr[i] * (i+1));
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
