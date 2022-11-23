package boj16499;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        while(N-- > 0){
            String s = br.readLine();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);

            set.add(s);
        }

        bw.write(String.valueOf(set.size()));

        bw.close();
        br.close();
    }
}
