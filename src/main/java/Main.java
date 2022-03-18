
public class Main {
    public static void main(String[] args){
        //rate - процент ежегодный
        //limit - время на погашения кредита
        //sum - сумма займа
        //paymentMonth - полная выплата в месяц
        //paymentBody - выплата кредита
        //paymentPercent - выплата процента
        //paymentAll - полная выаплата кредита
        double rate = 0.15;
        double limit = 20;
        double sum = 500000;
        double paymentMonth = 0;
        double paymentBody = 0;
        double paymentPercent = 0;
        double paymentAll = 0;
        double balance=0;


        PaymentMechanism.calculation(rate,limit,sum,paymentMonth, paymentBody,paymentPercent,paymentAll);
        System.out.println(balance);
    }

}
