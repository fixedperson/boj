package boj17215;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int turns;
    static int frames;
    static int[] extra;
    static int total_score = 0;
    static String str;

    static int score;
    static char pins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();

        turns = 0;
        frames = 1;
        extra = new int[25];
        Arrays.fill(extra, 1);

        while(turns < str.length()){
            bowling();
        }

        bw.write(total_score + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void bowling(){
        score = 0;
        pins = str.charAt(turns);

        if (pins == 'S') {
            score = 10;
            score *= extra[turns];
            total_score += score;
            if (frames < 10) {
                extra[turns + 1]++;
                extra[turns + 2]++;
            }
            turns++;
            frames++;
        } else {
            if(frames == 10){
                frames++;
            }
            if (pins != '-') {
                score = pins - '0';
            }
            score *= extra[turns];
            total_score += score;
            turns++;
            spare();
            frames++;
        }
    }

    static void spare(){
        if(frames == 12)
            return;

        score = 0;
        pins = str.charAt(turns);

        if(pins == 'P'){
            if(str.charAt(turns-1) != '-')
                score = 10 - (str.charAt(turns-1) - '0');
            else
                score = 10;
            score *= extra[turns];
            total_score += score;
            if(frames < 10)
                extra[turns+1]++;
            turns++;
        }

        else {
            if(pins != '-'){
                score = pins - '0';
            }
            score *= extra[turns];
            total_score += score;
            turns++;
        }
    }
}
