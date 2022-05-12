package boj17143;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] sharks; // 현재 시간 상어의 위치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()); // 행
        int C = Integer.parseInt(st.nextToken()); // 열
        int M = Integer.parseInt(st.nextToken()); // 상어

        ArrayList<Shark> al = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            al.add(new Shark(r,c,s,d,z));
        }

        int answer = 0;
        int index;
        int minX;
        int minSize;
        for(int i = 1; i <= C; i++){
            index = -1;
            minX = R+1;
            minSize = 0;
            for(int j = 0; j < al.size(); j++){
                if(al.get(j).death) continue;
                if(al.get(j).y == i){
                    if(minX > al.get(j).x){
                        index = j;
                        minX = al.get(j).x;
                        minSize = al.get(j).size;
                    }
                }
            }
            if(index != -1){
                answer += minSize;
                al.get(index).death = true;
            }

            sharks = new int[R+1][C+1];
            for(int j = 0; j <= R; j++){
                Arrays.fill(sharks[j], -1);
            }
            for(int j = 0; j < al.size(); j++){
                Shark temp = al.get(j);
                if(temp.death) continue;
                if(temp.direction == 1){
                    temp.x -= temp.speed;
                    while(1 > temp.x || temp.x > R){
                        if(temp.x < 1){
                            temp.x = 1 + 1 - temp.x;
                            temp.direction = 2;
                        }
                        else {
                            temp.x = R - (temp.x - R);
                            temp.direction = 1;
                        }
                    }
                }
                else if(temp.direction == 2){
                    temp.x += temp.speed;
                    while(1 > temp.x || temp.x > R){
                        if(temp.x < 1){
                            temp.x = 1 + 1 - temp.x;
                            temp.direction = 2;
                        }
                        else {
                            temp.x = R - (temp.x - R);
                            temp.direction = 1;
                        }
                    }
                }
                else if(temp.direction == 3){
                    temp.y += temp.speed;
                    while(1 > temp.y || temp.y > C){
                        if(temp.y < 1){
                            temp.y = 1 + 1 - temp.y;
                            temp.direction = 3;
                        }
                        else {
                            temp.y = C - (temp.y - C);
                            temp.direction = 4;
                        }
                    }
                }
                else{
                    temp.y -= temp.speed;
                    while(1 > temp.y || temp.y > C){
                        if(temp.y < 1){
                            temp.y = 1 + 1 - temp.y;
                            temp.direction = 3;
                        }
                        else {
                            temp.y = C - (temp.y - C);
                            temp.direction = 4;
                        }
                    }
                }
                if(sharks[temp.x][temp.y]== -1) {
                    sharks[temp.x][temp.y] = j;
                }
                else{
                    if(temp.size > al.get(sharks[temp.x][temp.y]).size){
                        al.get(sharks[temp.x][temp.y]).death = true;
                        sharks[temp.x][temp.y] = j;
                    }
                    else{
                        al.get(j).death = true;
                    }
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}

class Shark{
    int x;
    int y;
    int speed;
    int direction;
    int size;
    boolean death = false;
    Shark(int r, int c, int s, int d, int z){
        x = r;
        y = c;
        speed = s;
        direction = d;
        size = z;
    }
}