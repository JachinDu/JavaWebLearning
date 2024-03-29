package com.imooc.energy;

public class EnergyTransferTask implements Runnable {

    private EnergySystem energySystem;
    private int fromBox;
    private double maxAmount;
    private int DELAY = 10;

    public EnergyTransferTask(EnergySystem energySystem,int from,double max){
        this.energySystem = energySystem;
        this.fromBox = from;
        this.maxAmount = max;
    }

    public void run(){
        while(true){
            int toBox = (int)(energySystem.getBoxAmount()*Math.random());
            double amount = maxAmount*Math.random();
            energySystem.transfer(fromBox,toBox,amount);
            try {
                Thread.sleep((int)(DELAY * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
