package edu.njfu.designmode.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MsgManager
 * @Description TODO
 * @Date 2020/10/24 10:54 下午
 * @Created by lqj(1724226325@qq.com)
 */
public class MsgManager {
    static List<MsgListener> subs =new ArrayList<>();
    public static void addListener(MsgListener listener){
        subs.add(listener);
    }
    public static void sendMsg(MsgEvent event) throws Exception {
           nofifyListeners(event);
    }
    public static void nofifyListeners(MsgEvent event) throws Exception {
        for(MsgListener listener:subs){
             listener.handleMsg(event);
        }
    }
    public static void main(String[] args) throws Exception {
        MsgEvent event = new MsgEvent("test", 12);
        //注册监听器
        MsgManager.addListener(new MsgListener() {
            @Override
            public void handleMsg(MsgEvent event) throws Exception {
                System.out.println("EventA"+event.getStatus());
            }
        });
        //注册监听器
        MsgManager.addListener(new MsgListener() {
            @Override
            public void handleMsg(MsgEvent event) throws Exception {
                System.out.println("EventB"+event.getStatus());
            }
        });
        MsgManager.sendMsg(event);
    }
    
}

