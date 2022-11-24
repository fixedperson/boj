package boj10546;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        while(N-- > 1) {
            String s = br.readLine();

            int temp = map.getOrDefault(s, 0)-1;

            if(temp == 0) map.remove(s);
            else map.put(s, temp);
        }

        bw.write(map.keySet().iterator().next());

        bw.close();
        br.close();
    }
}
