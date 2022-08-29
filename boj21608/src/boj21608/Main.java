package boj21608;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int ans = 0;
    static ArrayList<Node> list = new ArrayList<>();
    static HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 1; j <= 4; j++) {
                tmp.add(Integer.parseInt(st.nextToken()));
            }

            list.add(new Node(num, tmp));
            hashMap.put(num, tmp);
        }

        for (int i = 0; i < N * N; i++) {
            student(list.get(i));
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int num = map[i][j];
                int cnt = 0;
                ArrayList<Integer> tmp = hashMap.get(num);

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (isValid(nx, ny) && tmp.contains(map[nx][ny])) {
                        cnt++;
                    }
                }

                if (cnt == 0) {
                    ans += 0;
                } else if (cnt == 1) {
                    ans += 1;
                } else if (cnt == 2) {
                    ans += 10;
                } else if (cnt == 3) {
                    ans += 100;
                } else {
                    ans += 1000;
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void student(Node temp) {
        PriorityQueue<Node2> pq = new PriorityQueue<>(new Comparator<Node2>() {
            @Override
            public int compare(Node2 o1, Node2 o2) {
                if (o1.like == o2.like) {
                    if (o1.empty == o2.empty) {
                        if (o1.x == o2.x) {
                            return o1.y - o2.y;
                        }
                        return o1.x - o2.x;
                    }
                    return o2.empty - o1.empty;
                }
                return o2.like - o1.like;
            }
        });

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int like = 0;
                int empty = 0;

                if (map[i][j] != 0) continue;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (!isValid(nx, ny)) continue;
                    if (map[nx][ny] == 0) {
                        empty++;
                    } else {
                        if (temp.list.contains(map[nx][ny])) like++;
                    }
                }
                pq.add(new Node2(i, j, like, empty));
            }
        }

        Node2 a = pq.poll();
        map[a.x][a.y] = temp.num;
    }

    public static boolean isValid(int x, int y) {
        return (x > 0) && (x <= N) && (y > 0) && (y <= N);
    }
}
class Node{
    int num;
    ArrayList<Integer>list;
    Node(int num, ArrayList<Integer>list){
        this.num = num;
        this.list = list;
    }
}

class Node2 {
    int x, y, like, empty;
    Node2(int x, int y, int like, int empty) {
        this.x = x;
        this.y = y;
        this.like = like;
        this.empty = empty;
    }
}