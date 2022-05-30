package boj16496;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        ArrayList<Number> al = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            int temp = Integer.parseInt(st.nextToken());
            al.add(new Number(temp));
        }

        Collections.sort(al, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return o1.value - o2.value;
            }
        });
        if(al.get(k-1).value == 0){
            System.out.println("0");
            System.exit(0);
        }

        Collections.sort(al, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                String a = Integer.toString(o1.value);
                String b = Integer.toString(o2.value);
                int a_index = 0;
                int b_index = 0;
                int count = 0;
                while(count < a.length() * b.length()){
                    if(a_index == a.length())
                        a_index = 0;
                    if(b_index == b.length())
                        b_index = 0;
                    if(a.charAt(a_index) == b.charAt(b_index)) {
                        a_index++;
                        b_index++;
                        count++;
                        continue;
                    }
                    return b.charAt(b_index) - a.charAt(a_index);
                }
                return a.length()-b.length();
            }
        });

        String ans = "";
        for(int i = 0; i < k; i++){
            for(int j = 0; j < al.get(i).count; j++) {
                ans += Integer.toString(al.get(i).value);
            }
        }
        System.out.println(ans);
    }
}

class Number{
    int value;
    int count;
    Number(int value){
        this.value = value;
        count = 1;
    }
}