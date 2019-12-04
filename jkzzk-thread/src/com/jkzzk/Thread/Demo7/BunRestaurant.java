package com.jkzzk.Thread.Demo7;

/**
 * 包子铺类
 * @author JKzzk
 */
public class BunRestaurant extends Thread{

    private Bun bun;

    public BunRestaurant() {

    }

    public BunRestaurant(Bun bun) {
        this.bun = bun;
    }

    @Override
    public void run() {
        int count = 0;

        while(true) {



            synchronized (bun) {
                if(bun.isFlag()) {
                    try {
                        bun.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("包子铺没有包子，开始做包子！");

                try {
                    //做个5秒钟
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(count % 3 == 0) {
                    bun.setBunSkin("薄皮");
                    bun.setBunFilling("三鲜馅");
                }else if(count % 3 == 1){
                    bun.setBunSkin("冰皮");
                    bun.setBunFilling("牛肉馅");
                }else {
                    bun.setBunSkin("胶皮");
                    bun.setBunFilling("猪肉馅");
                }

                count++;

                //更改包子的状态
                bun.setFlag(true);
                System.out.println(bun.toString() + "做好了！");

                //唤醒顾客包子
                bun.notify();

            }
        }
    }
}
