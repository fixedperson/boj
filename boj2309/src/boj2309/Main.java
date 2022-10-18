package boj2309;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            for(int j = i+1; j < 9; j++){
                if(sum - arr[i] - arr[j] == 100){
                    for(int k = 0; k < 9; k++){
                        if(k == i || k == j) continue;
                        list.add(arr[k]);
                    }
                    break;
                }
            }
            if(list.size() > 0) break;
        }

        Collections.sort(list);

        for(Integer i : list){
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
