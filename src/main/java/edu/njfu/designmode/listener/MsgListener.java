package edu.njfu.designmode.listener;

import java.util.EventListener;

/**
 * @Classname MsgListener
 * @Description TODO
 * @Date 2020/10/24 10:50 下午
 * @Created by lqj(1724226325@qq.com)
 */
public interface MsgListener extends EventListener {
    void handleMsg(MsgEvent event) throws Exception;
}
