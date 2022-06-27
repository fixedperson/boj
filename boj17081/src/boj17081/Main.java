package boj17081;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    static char[][] map;
    static Monster[][] monData; // 몬스터의 정보
    static int monNum = 0; // 몬스터의 수
    static Item[][] itemData; // 아이템의 정보
    static int itemNum = 0; // 아이템의 수
    static char[] move; // 이동 방향
    static int playerX, playerY;
    static int turns;
    static String result = "Press any key to continue.";
    static int nextX, nextY;
    static int startX, startY;
    static Player player;
    static boolean useRE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N+1][M+1];
        for(int i = 1; i <= N; i++){
            String s = br.readLine();
            for(int j = 1; j <= M; j++){
                map[i][j] = s.charAt(j-1);
                if(map[i][j] == '&' || map[i][j] == 'M')
                    monNum++;
                if(map[i][j] == 'B')
                    itemNum++;
                if(map[i][j] == '@'){
                    playerX = j;
                    playerY = i;
                    startX = j;
                    startY = i;
                    map[i][j] = '.';
                }
            }
        }

        move = br.readLine().toCharArray();

        monData = new Monster[N+1][M+1];
        for(int i = 0; i < monNum; i++){
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            String name = st.nextToken();
            int att = Integer.parseInt(st.nextToken());
            int def = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());
            int exp = Integer.parseInt(st.nextToken());

            monData[y][x] = new Monster(name, att, def, hp, exp);
        }

        itemData = new Item[N+1][M+1];
        for(int i = 0; i < itemNum; i++){
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            char div = st.nextToken().charAt(0);
            String effect = st.nextToken();

            itemData[y][x] = new Item(div, effect);
        }

        player = new Player();
        for(turns = 1; turns <= move.length; turns++){
            useRE = false;

            // 이동
            nextX = playerX;
            nextY = playerY;

            char dir = move[turns-1];
            if(dir == 'L') {
                nextX -= 1;
            }
            else if (dir == 'R'){
                nextX += 1;
            }
            else if (dir == 'U'){
                nextY -= 1;
            }
            else{
                nextY += 1;
            }

            if(nextX <= 0 || nextX >= M+1 || nextY <= 0 || nextY >= N+1) {
                nextX = playerX;
                nextY = playerY;
            }
            if(map[nextY][nextX] == '#') {
                nextX = playerX;
                nextY = playerY;
            }

            if(map[nextY][nextX] == 'B'){
                getItem();
            }

            else if(map[nextY][nextX] == '^'){
                spikeTrap();
                if(useRE){
                    continue;
                }
                if(player.remHP <= 0){
                    break;
                }
            }

            else if(map[nextY][nextX] == '&'){
                battle();
                if(useRE){
                    continue;
                }
                // 장신구 HR
                if(player.remHP > 0 && player.acc.contains("HR")){
                    player.remHP += 3;
                    if(player.remHP > player.curHP){
                        player.remHP = player.curHP;
                    }
                }
                if(player.remHP <= 0){
                    break;
                }
            }

            else if(map[nextY][nextX] == 'M'){
                battle();
                if(useRE){
                    continue;
                }
                // 장신구 HR
                if(player.remHP > 0 && player.acc.contains("HR")){
                    player.remHP += 3;
                    if(player.remHP > player.curHP){
                        player.remHP = player.curHP;
                    }
                }
                if(player.remHP > 0) {
                    result = "YOU WIN!";
                }

                playerX = nextX;
                playerY = nextY;
                break;
            }

            playerX = nextX;
            playerY = nextY;
        }
        if (turns >= move.length){
            turns = move.length;
        }

        if(player.remHP > 0){
            map[playerY][playerX] = '@';
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        sb.append("Passed Turns : " + turns + "\n");
        sb.append("LV : " + player.lev + "\n");
        sb.append("HP : " + player.remHP + "/" + player.curHP + "\n");
        sb.append("ATT : " + player.nATT + "+" + player.wATT + "\n");
        sb.append("DEF : " + player.nDEF + "+" + player.aDEF + "\n");
        sb.append("EXP : " + player.curEXP + "/" + player.maxEXP + "\n");
        sb.append(result);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    static void getItem(){

        char div = itemData[nextY][nextX].div;

        if(div == 'W'){
            player.wATT = Integer.parseInt(itemData[nextY][nextX].effect);
        }

        else if (div == 'A'){
            player.aDEF = Integer.parseInt(itemData[nextY][nextX].effect);
        }

        else {
            if(player.acc.size() < 4) {
                player.acc.add(itemData[nextY][nextX].effect);
            }
        }

        map[nextY][nextX] = '.';
    }

    static void spikeTrap(){

        // 장신구 DX
        if(player.acc.contains("DX")){
            player.remHP -= 1;
        }
        else {
            player.remHP -= 5;
        }

        if(player.remHP <= 0){
            // 장신구 RE
            if(player.acc.contains("RE")){
                useRE = true;
                player.remHP = player.curHP;
                playerX = startX;
                playerY = startY;
                player.acc.remove("RE");
                return;
            }
            player.remHP = 0;
            result = "YOU HAVE BEEN KILLED BY SPIKE TRAP..";
        }
    }

    static void battle(){
        Monster monster = monData[nextY][nextX];

        int monsterHP = monster.hp;

        if(map[nextY][nextX] == 'M' && player.acc.contains("HU")){
            player.remHP = player.curHP;
        }

        for(int i = 0;;i++){
            // 플레이어 공격
            int damage = 0;

            //장신구 CO
            if(i == 0 && player.acc.contains("CO")){
                if(player.acc.contains("DX")){
                    damage = Math.max(1, 3 * (player.nATT + player.wATT) - monster.def);
                }
                else{
                    damage = Math.max(1, 2 * (player.nATT + player.wATT) - monster.def);
                }
            }
            else {
                damage = Math.max(1, (player.nATT + player.wATT) - monster.def);
            }
            monster.hp -= damage;

            if(monster.hp <= 0){
                break;
            }

            // 몬스터 공격
            if(i == 0 && map[nextY][nextX] == 'M' && player.acc.contains("HU")){
                damage = 0;
            }
            else {
                damage = Math.max(1, monster.att - (player.aDEF + player.nDEF));
            }
            player.remHP -= damage;

            if(player.remHP <= 0){
                // 장신구 RE
                if(player.acc.contains("RE")){
                    useRE = true;
                    player.remHP = player.curHP;
                    playerX = startX;
                    playerY = startY;
                    monster.hp = monsterHP;
                    player.acc.remove("RE");
                    return;
                }
                player.remHP = 0;
                result = "YOU HAVE BEEN KILLED BY " + monster.name + "..";
                return;
            }
        }

        // 경험치 획득
        int exp = monster.exp;
        // 장신구 EX
        if(player.acc.contains("EX")){
            exp = (int) (exp * 1.2);
        }
        player.curEXP += exp;
        if(player.curEXP >= player.maxEXP) {
            player.lev += 1;
            player.curEXP = 0;
            player.maxEXP = player.lev * 5;
            player.curHP += 5;
            player.remHP = player.curHP;
            player.nATT += 2;
            player.nDEF += 2;
        }
        map[nextY][nextX] = '.';
    }
}

class Player{
    int lev = 1;
    int remHP = 20;
    int curHP = 20;
    int nATT = 2;
    int wATT = 0;
    int nDEF = 2;
    int aDEF = 0;
    int curEXP = 0;
    int maxEXP = 5*lev;
    Set<String> acc;
    Player(){
        acc = new HashSet<String>();
    }
}

class Monster{
    String name;
    int att;
    int def;
    int hp;
    int exp;
    Monster(String name, int att, int def, int hp, int exp){
        this.name = name;
        this.att = att;
        this.def = def;
        this.hp = hp;
        this.exp = exp;
    }
}

class Item{
    char div;
    String effect;
    Item(char div, String effect){
        this.div = div;
        this.effect = effect;
    }
}