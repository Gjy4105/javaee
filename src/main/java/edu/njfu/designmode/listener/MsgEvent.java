package edu.njfu.designmode.listener;

import java.util.EventObject;

/**
 * @Classname MsgEvent
 * @Description TODO
 * @Date 2020/10/24 10:46 下午
 * @Created by lqj(1724226325@qq.com)
 */
public class MsgEvent extends EventObject {
    private int status;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MsgEvent(Object source) {
        super(source);
    }

    public MsgEvent(Object source, int status) {
        super(source);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
