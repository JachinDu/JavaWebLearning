package com.imooc.energy;

public class EnergySystem {

    //能量盒子，能量存储的地方
    private final double[] energyBoxes;
    private final Object lockObj = new Object();

    public EnergySystem(int n, double initialEnergy){
        energyBoxes = new double[n];
        for(int i = 0; i < energyBoxes.length; i++)
        {
            energyBoxes[i] = initialEnergy;
        }
    }


    public void transfer(int from, int to, double amount)
    {
        //同步与互斥
        synchronized (lockObj){
//            if(energyBoxes[from] < amount)
//                return;
            //while循环，保证条件不满足时任务都会被条件阻挡
            //而不是继续竞争CPU资源
            //Wait set
            while(energyBoxes[from] < amount){
                try {
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName());
            energyBoxes[from] -= amount;
            System.out.printf("从%d转移%10.2f单位能量到%d",from,amount,to);
            energyBoxes[to] += amount;
            System.out.printf("能量总和：%10.2f%n",getTotalEnergies());
            //唤醒所有在lockObj对象上等待到线程
            //同步与互斥
            lockObj.notifyAll();
        }

    }

    public double getTotalEnergies(){
        double sum = 0;
        for(double amount:energyBoxes)
        {
            sum += amount;
        }
        return sum;
    }

    //返回能量盒子长度
    public int getBoxAmount(){
        return energyBoxes.length;
    }
}
