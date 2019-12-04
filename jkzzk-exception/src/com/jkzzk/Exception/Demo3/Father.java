package com.jkzzk.Exception.Demo3;

import java.util.List;

/**
 *  测试子父类抛出异常机制---父类
 * @author  Jkzzk
 */
public class Father {

    private List<String> message;

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public void printMessage(Integer index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= this.message.size()) {
            throw new IndexOutOfBoundsException();
        }

        System.out.println(this.message.get(index));
    }
}
