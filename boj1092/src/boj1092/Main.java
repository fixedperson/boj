    package boj1092;

    import java.io.*;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.StringTokenizer;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine());
            int[] crane = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                crane[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(crane);

            int M = Integer.parseInt(br.readLine());
            ArrayList<Integer> al = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                al.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(al, Collections.reverseOrder());


            if(al.get(0) > crane[N-1]){
                bw.write("-1");
            }
            else{
                int count = 0;
                while(al.size()>0){
                    int boxIndex = 0;
                    for(int i = N-1; i >= 0; i--){
                        if(al.size() == 0) break;
                        if(al.size() == boxIndex) break;
                        if(al.get(boxIndex) > crane[i]){
                            boxIndex++;
                            i++;
                            continue;
                        }
                        al.remove(boxIndex);
                    }
                    count++;
                }
                bw.write(count + "\n");
            }
            bw.flush();
            bw.close();
        }
    }

