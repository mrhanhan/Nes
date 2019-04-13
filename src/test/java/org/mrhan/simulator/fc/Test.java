package org.mrhan.simulator.fc;

import org.mrhan.simulator.fc.core.memory.NesDynamicMemory;
import org.mrhan.simulator.fc.core.memory.NesFixedMemory;
import org.mrhan.simulator.fc.io.NesInputStream;
import org.mrhan.simulator.fc.io.NesOutputStream;

import java.io.*;

public class Test {



    @org.junit.Test
    public void dMemory() throws IOException {
        NesDynamicMemory buffer = new NesDynamicMemory(16, 1);
        /* 读写操作 */
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new NesOutputStream(buffer)));
        BufferedReader br = new BufferedReader(new InputStreamReader(new NesInputStream(buffer)));
        while(true){
            try{
                bw.write("我");
                bw.flush();
                bw.write("是");
                bw.flush();
                bw.write("你");
                bw.flush();
                bw.write("爸");
                bw.flush();
                bw.write("爸");
                bw.flush();
                bw.write("\n");
                bw.flush();
            }catch (IOException e){
                System.out.println(e.getMessage());
                break;
            }
        }
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }

    @org.junit.Test
    public void fMemory() throws IOException {
        NesFixedMemory memory = new NesFixedMemory(5);
        /* 读写操作 */
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new NesOutputStream(memory)));
        BufferedReader br = new BufferedReader(new InputStreamReader(new NesInputStream(memory)));
        while(true){
            try{
                bw.write("我");
                bw.flush();
                bw.write("是");
                bw.flush();
                bw.write("你");
                bw.flush();
                bw.write("爸");
                bw.flush();
                bw.write("爸");
                bw.flush();
                bw.write("\n");
                bw.flush();
            }catch (IOException e){
                System.out.println(e.getMessage());
                break;
            }
        }
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }
}