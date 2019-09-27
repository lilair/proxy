package com.changhong.dao;

/**
 * @author lilair
 * @create 2019/08/29 10:19
 */
public class Actor implements IActor {

    @Override
    public void dangerAct(double money) {
        System.out.println("危险的表演需要"+money);
    }

    @Override
    public void basicAct(double money) {
        System.out.println("基础的表演需要"+money);
    }
}
