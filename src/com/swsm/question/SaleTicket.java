package com.swsm.question;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class SaleTicket {

    public static void main(String[] args) {
        SellTicketWindow window = new SellTicketWindow();
        new Thread(window).start();
        new Thread(window).start();
    }
    
}

class SellTicketWindow implements Runnable {
    //100张票
    private int count = 100;
    @Override
    public void run() {
        while (true) {
            count--;
        }
    }
}
