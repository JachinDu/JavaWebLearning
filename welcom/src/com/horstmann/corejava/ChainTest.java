package com.horstmann.corejava;

public class ChainTest {

    public static void main(String[] args) {
        ChainTest ct = new ChainTest();
        try {
            ct.test2();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void test1() throws DrunkException{
        throw new DrunkException("喝车别开酒！");

    }

    public void test2(){
        try{
            test1();
        }catch (DrunkException e) {
            RuntimeException newExc = new RuntimeException(e);
            //newExc.initCause(e);
            throw newExc;
            }
        }

    }


