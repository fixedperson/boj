package boj1620;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            String s = br.readLine();
            map1.put(s, i);
            map2.put(i, s);
        }

        while(M-- > 0){
            String s = br.readLine();

            try {
                Double.parseDouble(s);
                sb.append(map2.get(Integer.parseInt(s)) + "\n");
            } catch (NumberFormatException e) {
                sb.append(map1.get(s) + "\n");
            }
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
