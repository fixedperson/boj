package boj10798;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] arr = new char[5][15];
        for(int i = 0; i < 5; i++){
            String s = br.readLine();

            for(int j = 0; j < 15; j++){
                if(s.length() > j){
                    arr[i][j] = s.charAt(j);
                }

                else {
                    arr[i][j] = ' ';
                }
            }
        }

        String s = "";
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
                if(arr[j][i] == ' ') continue;

                s += arr[j][i];
            }
        }

        bw.write(s);
        bw.close();
        br.close();
    }
}
