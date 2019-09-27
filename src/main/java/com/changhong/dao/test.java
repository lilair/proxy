package com.changhong.dao;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lilair
 * @create 2019/08/29 10:22
 */
public class test {
    public static void main(String[] args) {
        Actor actor= new Actor();
        IActor proxyActor = (IActor) Proxy.newProxyInstance(Actor.class.getClassLoader(), Actor.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                IActor retValue=null;
                String name=method.getName();
                Double money= (Double) args[0];
                if ("dangerAct".equals(name)){
                    if(money>1000){
                        method.invoke(actor,money/2);
                    }
                }
                if ("basicAct".equals(name)){
                    if(money>2000){
                        method.invoke(actor,money/2);
                    }
                }
                return retValue;
            }
        });
        proxyActor.basicAct(10000);
        proxyActor.dangerAct(20000);
    }

}
