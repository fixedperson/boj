package boj7662;

import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());

                String calc = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(calc.equals("I")){
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }

                else {
                    if(map.size() < 1) continue;

                    int temp = num == 1 ? map.lastKey() : map.firstKey();

                    int value = map.get(temp);
                    if(value == 1){
                        map.remove(temp);
                    }
                    else {
                        map.put(temp, value-1);
                    }
                }
            }
            if(map.size() < 1){
                bw.write("EMPTY\n");
            }
            else{
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
