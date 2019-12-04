package com.jkzzk.Exception.Demo3;

import java.util.List;

/**
 *  测试子父类抛出异常机制----子类
 * @author  Jkzzk
 */
public class Son extends Father{

    private List<String> message;

    private String[] readers;

    public String[] getReaders() {
        return readers;
    }

    public void setReaders(String[] readers) {
        this.readers = readers;
    }

    @Override
    public List<String> getMessage() {
        return message;
    }

    @Override
    public void setMessage(List<String> message) {
        this.message = message;
    }

    //    public void printMessage(Integer index)throws Exception{  //只能抛出父类该方法的子类异常或本身
//    public void printMessage(Integer index)throws ArrayIndexOutOfBoundsException{  //可以抛出子类异常
//    public void printMessage(Integer index){  //也可以不抛出异常
    public void printMessage(Integer index)throws IndexOutOfBoundsException{  //也可以抛出父类该方法的异常
        if(this.readers != null) {
            if (index < 0 || index >= this.readers.length) {
                throw new IndexOutOfBoundsException();
            }

            System.out.println(this.readers[index]);
        }

        super.printMessage(index);
    }

}
