package boj1302;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();
        while(N-- > 0){
            String s = br.readLine();
            hashMap.put(s, hashMap.getOrDefault(s, 0)+1);
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() == o2.getValue()){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue()- o1.getValue();
            }
        });

        bw.write(entryList.get(0).getKey());

        bw.close();
        br.close();
    }
}
