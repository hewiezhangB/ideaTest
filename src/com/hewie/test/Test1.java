package com.hewie.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Test1 {
    /**
     * 功能：电梯调度算法；
     * 说明：电梯调度算法的基本原则就是如果在电梯运行方向上有人要使用电梯则继续往那个方向运动，如果电梯中的人还没有到达目的地则继续向原方向运动。具体而言，如果电梯现在朝上运动，
     * 如果当前楼层的上方和下方都有请求，则先响应所有上方的请求，然后才向下响应下方的请求；如果电梯向下运动，则刚好相反。
     * 设计要求：模拟多人在不同楼层同时要求到各自目的地时电梯的响应顺序，要求使用C语言编程，定义合适的数据结构。最后，需要说明设计思想，同时给出能够运行的源程序，并给出对应的程序流程图。
     * 设计提示：可以用一个结构体表示乘电梯的人，其中内容包括人的姓名、起始楼层、目的楼层；建立一个结构体的数组模拟当前所有需要乘电梯的人。把这个结构体数组作为程序的输入，
     * 通过对数组中每个人的起始楼层和目的楼层进行分析，确定每个人进出电梯的顺序，并打印输出。 比如： 当前楼层是4，结构体数组中共有3个人，A：7 → 3 B：6→10 C：7→8；
     *
     * 则输出应该是：
     * 当前楼层为6，B进入
     * 当前楼层为7，C进入
     * 当前楼层为8，C出去
     * 当前楼层为10，B出去
     * 当前楼层为7，A进入
     * 当前楼层为3，A出去
     *
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
        Brick brick = new Brick();
    }
}

//方块类
class Brick {
    //计算开关门事件。
    public int octime = 0;
    public int j = 0;
    public String closedoor = "关门";
    public String close = "关";
    public String open = "开";
    JFrame frame = new JFrame("电梯调度算法");
    JPanel pan = new JPanel();
    JButton but = null;
    JButton sign = new JButton(+j + "楼");
    JButton openclose = new JButton(closedoor + "");
    JButton openkey = new JButton(open + "");
    JButton closekey = new JButton(close + "");

    public ArrayList blackBrick;
    //brick用来依次存放button,程序用button显示蓝色表示有电梯的当前位置。
    public ArrayList controlBrick;
    //controlBrick用来依次存放button,表示每层楼电梯口的是上键和下键，程序用button显示绿色表示对应键被按下。
    public int[][] controlTable;
    //用二维数组controlTable与电梯口的上下键对应，其中如果值1表示button应显示绿色，值0表示button应显示灰色。
    public ArrayList numberBrick;
    //numberBrick用来依次存放button,程序用button显示桔黄色表示电梯内的数字键被按下。
    public int[] table;
    //用二维数组table与电梯内的数字键对应，其中如果值1表示button应显示桔黄色，值0表示button应显示灰色。
    public int[] upSignalTable;
    //纪录向上任务的任务数组，值为1表示相应位的上键被按下。
    public int[] downSignalTable;
    //纪录向下任务的任务数组，值为1表示相应位的下键被按下。
    public Timer timer;
    //计时器。
    public LiftThread lift;
    //控制每个电梯的线程数组。


//================================================构造方法(下)初始化===========================================================//

    public Brick() {
        //起始位置
        sign.setBounds(0, 0, 80, 40);
        //开关门部分
        openclose.setBounds(80, 0, 80, 40);
        openclose.setBackground(Color.yellow);

        openkey.setBounds(160, 0, 80, 40);
        //开门按钮添加事件
        openkey.addActionListener(new OpencolseListener());
        closekey.setBounds(240, 0, 80, 40);
        //关门按钮添加事件
        closekey.addActionListener(new OpencolseListener());

        //画布绝对定位
        pan.setLayout(null);
        //设置字体样式
        Font fnt = new Font("Serief", Font.ITALIC, 15);

        //实例化数组
        numberBrick = new ArrayList(10);
        blackBrick = new ArrayList(10);
        controlBrick = new ArrayList(10);

        controlTable = new int[10][2];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 2; j++){
                controlTable[i][j] = 0;
            }
        }

        table = new int[10];
        for (int i = 0; i < 10; i++){
            table[i] = 0;
        }

        upSignalTable = new int[10];
        downSignalTable = new int[10];

        for (int i = 0; i < 10; i++) {
            upSignalTable[i] = 0;
            downSignalTable[i] = 0;
        }

        //********************画图************************
        for (int i = 10; i > 0; i--) {

            //最左边黑色列
            but = new JButton();
            but.setFont(fnt);
            but.setBounds(0, (11 - i) * 40, 80, 40);
            but.setBackground(Color.BLACK);
            blackBrick.add(but);
            pan.add(but);

            //显示楼层
            but = new JButton(+i + "楼");
            but.setFont(fnt);
            but.setBounds(80, (11 - i) * 40, 80, 40);
            but.addActionListener(new NumberListener(i));
            but.setBackground(Color.gray);
            numberBrick.add(but);
            pan.add(but);

            //向上键
            but = new JButton("上");
            but.setFont(fnt);
            but.setBounds(160, (11 - i) * 40, 80, 40);
            if (i != 10){
                but.addActionListener(new UpListener(i));
            }
            but.setBackground(Color.gray);
            controlBrick.add(but);
            pan.add(but);

            //向下键
            but = new JButton("下");
            but.setFont(fnt);
            but.setBounds(240, (11 - i) * 40, 80, 40);
            if (i != 1){
                but.addActionListener(new DownListener(i));
            }

            but.setBackground(Color.gray);
            controlBrick.add(but);
            pan.add(but);
        }

        //*******************运行部分******************

        pan.add(sign);
        pan.add(openclose);
        pan.add(openkey);
        pan.add(closekey);
        frame.add(pan);
        frame.setSize(329, 479);
        lift = new LiftThread();
        frame.setVisible(true);
        //frame.EXIT_ON_CLOSE
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //====================================================构造方法(上)=======================================================//


    //*************************************************填充方块和设置方法*******************************************************
    public void DrawBrick() { //重新刷新整个table，使每个button显示应该的颜色。
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < 10; j++){
                ((JButton) blackBrick.get(j)).setBackground(Color.black);
            }
            ((JButton) blackBrick.get(10 - lift.number)).setBackground(Color.blue);
        }
    }

    //将所电梯口的上下键全部重新按当前状态显示颜色。
    public void DrawControlBrick() {
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 2; j++){
                if (controlTable[i][j] == 1) {
                    ((JButton) controlBrick.get(i * 2 + j)).setBackground(Color.green);
                } else {
                    ((JButton) controlBrick.get(i * 2 + j)).setBackground(Color.gray);
                }
            }
        }
    }

    //将所有电梯内的数字键重新按当前状态显示颜色。
    public void DrawNumberBrick() {
        for (int i = 0; i < 10; i++){
            if (table[i] == 1){
                ((JButton) numberBrick.get(i)).setBackground(Color.orange);
            } else {
                ((JButton) numberBrick.get(i)).setBackground(Color.gray);
            }
        }
    }

    //判断当前电梯内的数字键是否被按下，如有键被按下，则值为1，如果没有任何键被按下，则值为0。
    public boolean WorkState() {
        for (int i = 0; i < 10; i++) {
            if (table[i] == 1){
                return true;
            }
        }
        return false;
    }

    public void setState(int number) { //如果电梯原来停，则改变电梯状态
        lift.destination = number;
        int x = lift.number;
        if (lift.state == 0) {
            if (number > x){
                lift.state = 1;
            }
            if (number < x){
                lift.state = 2;
            }
        }
    }

//*****************************************事件处理部分****************************************

    public class UpListener implements ActionListener { //相应上键被按下的动作。
        int L = 1; //当前楼层。

        UpListener(int n) {
            L = n;
        }

        @Override
        public void actionPerformed(ActionEvent e) { //重新显示上下键的颜色并将向上任务加入向上任务数组。
            controlTable[10 - L][0] = 1;
            setState(L);
            DrawControlBrick();
        }
    }

    public class DownListener implements ActionListener { //相应下键被按下的动作。
        int L = 0;

        public DownListener(int n) {
            L = n;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controlTable[10 - L][1] = 1;
            setState(L);
            DrawControlBrick();
        }
    }

    public class NumberListener implements ActionListener { //相应数字键被按下的动作。
        int number = 0; //相应的数字键楼层。

        NumberListener(int n) {
            number = n;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            table[10 - number] = 1;
            setState(number);
            DrawNumberBrick();
        }
    }

    public class OpencolseListener implements ActionListener { //开门关门按钮
        //int number = 0;
        OpencolseListener() {
            //number = n;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            octime = 500;
            System.out.println("事件" + octime);
        }
    }

    //***************************************主要监听器********************************************

    public class TimeListener implements ActionListener { //电梯线程的监听器。************************************
        TimeListener() {
        }

        public void actionDown() { //检查向下运行的电梯是否还需向下，即检查在此层下还有没有数字键被按下，如果没有，则置电梯状态为停止，并使该电梯内所有数字键还原。
            if (lift.state == 2) {
                int count = 0;
                for (int i = lift.number; i > 0; i--){
                    if (table[10 - i] == 1 || controlTable[10 - i][1] == 1 || controlTable[10 - i][0] == 1){
                        count++;
                    }
                }

                if (count == 0 && lift.number <= lift.destination) {
                    count = 0;
                    for (int j = lift.number; j < 10; j++) {
                        if (table[10 - j] == 1 || controlTable[10 - j][1] == 1 || controlTable[10 - j][0] == 1) {
                            count++;
                        }
                    }
                    if (count > 0) {
                        lift.state = 1;
                    //System.out.println("改变方向：向上");
                    } else {
                        lift.state = 0;
                    }
                }
            }
        }


        public void actionUp() { //检查向上运行的电梯是否还需向上，即检查在此层上还有没有数字键被按下，如果没有，则置电梯状态为停止，并使该电梯内所有数字键还原。
            if (lift.state == 1) {
                int count = 0;
                for (int i = lift.number; i < 10; i++){
                    if (table[10 - i] == 1 || controlTable[10 - i][0] == 1 || controlTable[10 - i][1] == 1){
                        count++;
                    }
                }

                if (count == 0 && lift.number >= lift.destination) {
                    count = 0;
                    for (int j = lift.number; j > 0; j--) {
                        if (table[10 - j] == 1 || controlTable[10 - j][1] == 1 || controlTable[10 - j][0] == 1) {
                            count++;
                        }
                    }
                    if (count > 0) {
                        lift.state = 2;
//System.out.println("改变方向：向下");
                    } else {
                        lift.state = 0;
                    }
                }
            }

        }

        @Override
        public void actionPerformed(ActionEvent event) {
            int state = lift.state; //纪录电梯当前状态。

            if (lift.state != 0 && table[10 - lift.number] == 1) { //如果电梯经过电梯内数字键显示的要到达的楼层，则该数字键状态恢复未按，并重新显示数字键颜色。
                table[10 - lift.number] = 0;
                DrawNumberBrick();
                new openclosThread();
            }

            if (state != 0 && lift.number == lift.destination) { //如果电梯属于逆向到达，则此任务完成，从任务数组中删除并重新显示上下键的颜色。
                if (state == 2 && controlTable[10 - lift.number][state - 1] == 0) {
                    controlTable[10 - lift.number][2 - state] = 0;
                    DrawControlBrick();
                    new openclosThread();
                }
                if (state == 1 && controlTable[10 - lift.number][state - 1] == 0) {
                    controlTable[10 - lift.number][2 - state] = 0;
                    new openclosThread();
                    DrawControlBrick();
                }
            }

            //向上电梯经过的向上任务完成，从任务数组中删除并重新显示上下键的颜色。
            if (state == 1) {
                if (controlTable[10 - lift.number][0] == 1) {
                    controlTable[10 - lift.number][0] = 0;
                    new openclosThread();
                    DrawControlBrick();
                }
            }

            //向下电梯经过的向下任务完成，从任务数组中删除并重新显示上下键的颜色。
            if (state == 2) {
                if (controlTable[10 - lift.number][1] == 1) {
                    controlTable[10 - lift.number][1] = 0;
                    new openclosThread();
                    DrawControlBrick();
                }
            }

            actionUp(); //判断是否继续向上

            actionDown(); //判断是否继续向下

            //如果电梯状态不为停止，则按照运行方向运行。
            state = lift.state;
            if (state == 1) {
                lift.number++;
                //System.out.println("向上"+lift.number);
            }

            if (state == 2) {
                lift.number--;
                //System.out.println("向下"+lift.number);
            }
            //设置相应电梯的显示器
            sign.setText("" + lift.number);
            DrawBrick();

            new Returnfirstfloor(state);//10秒没人按下任何键，则返回第一层
        }
    }

    //***************************************************电梯线程时间控制。****************************************************************************************

    public class openclosThread extends Thread {
        public openclosThread() {
            start();
        }

        @Override
        public void run() {
            openclose.setText("开门");
            try {
                sleep(1000);
            } catch (InterruptedException e) {

            }
            openclose.setText("关门");
        }
    }

    //如果在30秒内没有人按下任何键，电梯则自动返回第一次；省电(*^__^*) 嘻嘻……
    public class Returnfirstfloor extends Thread {
        int stater;
        int count;

        public Returnfirstfloor(int state) {
            count = 0;
            this.stater = state;
            start();
        }

        @Override
        public void run() {
            if (stater == 0 && lift.number != 1) {
                try {
                    sleep(10000);
                } catch (InterruptedException e) {

                }
                for (int i = 1; i <= 10; i++) {
                    if (table[10 - i] == 1 || controlTable[10 - i][1] == 1 || controlTable[10 - i][0] == 1) {
                        count++;
                    }
                }
                //如果10秒后没人按，就设第一层为1,电梯方向为向下。
                if (count == 0) {
                    table[9] = 1;
                    lift.state = 2;
                }
            }
        }
    }

    public class LiftThread extends Thread {
        //电梯当前楼层。
        public int number = 1;
        //电梯当前状态，0为停止，1为上升，2为下降。
        public int state = 0;
        //电梯的目的楼层。
        int destination;
        int i = 0;

        public LiftThread() {
            start();
            i = octime;
            System.out.println("" + i);
        }

        @Override
        public void run() {
            ActionListener timelistener = new TimeListener();
            timer = new Timer((1500 + i), timelistener);
            timer.start();
        }
    }
}
