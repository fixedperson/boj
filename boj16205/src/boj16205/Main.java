package boj16205;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String name = st.nextToken();

        String name1 = "";
        String name2 = "";
        String name3 = "";

        if(n == 1){
            name1 = name;
            for(int i = 0; i < name.length(); i++){
                if(Character.isUpperCase(name.charAt(i))){
                    name2 += "_";
                    name2 += Character.toLowerCase(name.charAt(i));
                }
                else {
                    name2 += name.charAt(i);
                }
            }
            for(int i = 0; i < name.length(); i++){
                if(i == 0){
                    name3 += Character.toUpperCase(name.charAt(i));
                }
                else {
                    name3 += name.charAt(i);
                }
            }
        }

        else if(n==2){
            for(int i = 0; i < name.length(); i++){
                if(name.charAt(i) == '_'){
                    name1 += Character.toUpperCase(name.charAt(i+1));
                    i++;
                }
                else {
                    name1 += name.charAt(i);
                }
            }
            name2 = name;
            for(int i = 0; i < name.length(); i++){
                if(i == 0){
                    name3 += Character.toUpperCase(name.charAt(i));
                }
                else if(name.charAt(i) == '_'){
                    name3 += Character.toUpperCase(name.charAt(i+1));
                    i++;
                }
                else {
                    name3 += name.charAt(i);
                }
            }
        }

        else {
            for(int i = 0; i < name.length(); i++){
                if(i == 0){
                    name1 += Character.toLowerCase(name.charAt(i));
                }
                else {
                    name1 += name.charAt(i);
                }
            }
            for(int i = 0; i < name.length(); i++){
                if(i == 0){
                    name2 += Character.toLowerCase(name.charAt(i));
                }
                else if(Character.isUpperCase(name.charAt(i))){
                    name2 += "_";
                    name2 += Character.toLowerCase(name.charAt(i));
                }
                else {
                    name2 += name.charAt(i);
                }
            }
            name3 = name;
        }

        bw.write(name1 + "\n");
        bw.write(name2 + "\n");
        bw.write(name3);
        bw.flush();
        bw.close();
        br.close();
    }
}
