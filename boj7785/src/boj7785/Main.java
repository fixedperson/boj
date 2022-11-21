package boj7785;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Set<String> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String temp = st.nextToken();

            if(temp.equals("enter")){
                set.add(name);
            }

            else {
                set.remove(name);
            }
        }

        ArrayList<String> al = new ArrayList<>(set);
        Collections.sort(al, Collections.reverseOrder());
        for(String s : al){
            bw.write(s + "\n");
        }

        bw.close();
        br.close();
    }
}
