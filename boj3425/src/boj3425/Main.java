package boj3425;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        List<Cmd> list;
        Stack<Integer> stack;
        while(true){
            list = new ArrayList<>();

            while(true){
                st = new StringTokenizer(br.readLine());

                String temp = st.nextToken();

                if(temp.equals("END")){
                    break;
                }

                else if(temp.equals("QUIT")){
                    bw.write(String.valueOf(sb));
                    bw.flush();
                    bw.close();
                    br.close();
                    System.exit(0);
                }

                else if(temp.equals("NUM")){
                    list.add(new Cmd(temp, Integer.parseInt(st.nextToken())));
                }

                else {
                    list.add(new Cmd(temp));
                }
            }

            int N = Integer.parseInt(br.readLine());

            for(int i = 0; i < N; i++){
                stack = new Stack<>();

                stack.push(Integer.parseInt(br.readLine()));
                String answer = "";
                for(Cmd temp : list){
                    if(temp.name.equals("NUM")){
                        stack.push(temp.num);
                    }

                    else if(temp.name.equals("POP")){
                        if(stack.size() < 1){
                            answer = "ERROR";
                            break;
                        }
                        stack.pop();
                    }

                    else if(temp.name.equals("INV")){
                        if(stack.size() < 1){
                            answer = "ERROR";
                            break;
                        }
                        int tmp = stack.pop();
                        stack.push(tmp * (-1));
                    }

                    else if(temp.name.equals("DUP")){
                        if(stack.size() < 1){
                            answer = "ERROR";
                            break;
                        }
                        int tmp = stack.peek();
                        stack.push(tmp);
                    }

                    else if(temp.name.equals("SWP")){
                        if(stack.size() < 2){
                            answer = "ERROR";
                            break;
                        }
                        int num1 = stack.pop();
                        int num2 = stack.pop();

                        stack.push(num1);
                        stack.push(num2);
                    }

                    else if(temp.name.equals("ADD")){
                        if(stack.size() < 2){
                            answer = "ERROR";
                            break;
                        }
                        int num1 = stack.pop();
                        int num2 = stack.pop();

                        long tmp = (long)num2 + num1;
                        if(Math.abs(tmp) > 1000000000){
                            answer = "ERROR";
                            break;
                        }
                        stack.push(num2 + num1);
                    }

                    else if(temp.name.equals("SUB")){
                        if(stack.size() < 2){
                            answer = "ERROR";
                            break;
                        }
                        int num1 = stack.pop();
                        int num2 = stack.pop();

                        long tmp = (long)num2 - num1;
                        if(Math.abs(tmp) > 1000000000){
                            answer = "ERROR";
                            break;
                        }
                        stack.push(num2 - num1);
                    }

                    else if(temp.name.equals("MUL")){
                        if(stack.size() < 2){
                            answer = "ERROR";
                            break;
                        }
                        int num1 = stack.pop();
                        int num2 = stack.pop();

                        long tmp = (long)num2 * num1;
                        if(Math.abs(tmp) > 1000000000){
                            answer = "ERROR";
                            break;
                        }
                        stack.push(num2 * num1);
                    }

                    else if(temp.name.equals("DIV")){
                        if(stack.size() < 2){
                            answer = "ERROR";
                            break;
                        }
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        if(num1 == 0){
                            answer = "ERROR";
                            break;
                        }

                        int tmp = Math.abs(num2) / Math.abs(num1);
                        if(Math.abs(tmp) > 1000000000){
                            answer = "ERROR";
                            break;
                        }
                        if((num1< 0 && num2 >= 0) || (num1 >= 0 && num2 < 0)){
                            stack.push(tmp * (-1));
                        }
                        else {
                            stack.push(tmp);
                        }
                    }

                    else if(temp.name.equals("MOD")){
                        if(stack.size() < 2){
                            answer = "ERROR";
                            break;
                        }
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        if(num1 == 0){
                            answer = "ERROR";
                            break;
                        }

                        int tmp = Math.abs(num2) % Math.abs(num1);
                        if(Math.abs(tmp) > 1000000000){
                            answer = "ERROR";
                            break;
                        }
                        if(num2 < 0){
                            stack.push(tmp * (-1));
                        }
                        else {
                            stack.push(tmp);
                        }
                    }
                }
                if(answer.equals("ERROR") || stack.size() != 1){
                    sb.append("ERROR" + "\n");
                }

                else {
                    sb.append(stack.pop() + "\n");
                }
            }
            sb.append("\n");
            br.readLine();
        }
    }
}

class Cmd{
    String name;
    int num;
    Cmd(String name, int num){
        this.name = name;
        this.num = num;
    }
    Cmd(String name){
        this.name = name;
    }
}