package boj26069;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if(set.contains(a) || set.contains(b)){
                set.add(a);
                set.add(b);
            }
        }

        bw.write(set.size() + "\n");

        bw.close();
        br.close();
    }
}
