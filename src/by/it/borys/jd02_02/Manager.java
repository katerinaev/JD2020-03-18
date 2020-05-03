package by.it.borys.jd02_02;

import by.it.borys.jd01_14.TaskA;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class Manager {
    static final int K_SPEED = 100;

    final static Object MONITOR = new Object();
    private static final int PLAN = 100;
    private volatile static  int inCount = 0;
    private volatile static int outCount = 0;

    static boolean shopOpen(){
        return inCount<PLAN;
    }
    static boolean planComplete(){
        return outCount == PLAN;
    }

    static void buyerAddToShop(){
        synchronized (MONITOR){
            inCount++;
        }
    }
    static void buyerLeaveTheShop(){
        synchronized (MONITOR){
            outCount++;
        }
    }
public static int count =0;

static int buyersReg(int second){
    int sec = second%60;
    if (sec < 30) {
        return sec/6+5;}
    else if(sec<45){
        return (44-sec);
    }
    else return 2;
}

 public  static TreeMap<Integer, Integer> graph = new TreeMap<>();
    public  static void buyersCount(boolean e){
        if (e) count++;
        else count--;

    }

    public static void printToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(TaskA.dir(Manager.class)+"log.txt")))
        {
            for (Map.Entry<Integer, Integer> el : graph.entrySet()) {
                pw.println(el.getKey()+" "+el.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
