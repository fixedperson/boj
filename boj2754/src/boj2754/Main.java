package boj2754;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        if(s.equals("A+")){
            bw.write("4.3");
        }
        else if(s.equals("A0")){
            bw.write("4.0");
        }
        else if(s.equals("A-")){
            bw.write("3.7");
        }
        else if(s.equals("B+")){
            bw.write("3.3");
        }
        else if(s.equals("B0")){
            bw.write("3.0");
        }
        else if(s.equals("B-")){
            bw.write("2.7");
        }
        else if(s.equals("C+")){
            bw.write("2.3");
        }
        else if(s.equals("C0")){
            bw.write("2.0");
        }
        else if(s.equals("C-")){
            bw.write("1.7");
        }
        else if(s.equals("D+")){
            bw.write("1.3");
        }
        else if(s.equals("D0")){
            bw.write("1.0");
        }
        else if(s.equals("D-")){
            bw.write("0.7");
        }
        else {
            bw.write("0");
        }

        bw.close();
        br.close();
    }
}
