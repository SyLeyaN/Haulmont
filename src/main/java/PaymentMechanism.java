public class PaymentMechanism {
    public static void calculation(double rate, double limit, double sum, double paymentMonth,
                            double paymentBody, double paymentPercent, double paymentAll){
        //rate - процент ежегодный
        //limit - время на погашения кредита
        //sum - сумма займа
        //paymentMonth - полная выплата в месяц
        //paymentBody - выплата кредита
        //paymentPercent - выплата процента
        //paymentAll - полная выаплата кредита

        paymentMonth = allSum(rate,limit,sum);
        paymentAll = all(allSum(rate,limit,sum),limit);
        System.out.print("All loan payments: " + String.format("%.2f",paymentAll)+"\t");
        System.out.println("Overpayment: "+ (paymentAll-sum));

        double balance = sum;

        for(int i =0; i<limit;i++){
            paymentPercent = percent(sum,balance,rate);
            paymentBody = body(paymentMonth,paymentPercent);
            balance = balance(balance,paymentBody);

            System.out.printf("Month " + (i+1)+"\t");
            System.out.printf(String.format("Payment at month: "+"%.2f",paymentMonth) + "\t");
            System.out.printf(String.format("Payment percent: "+"%.2f",paymentPercent)+ "\t");
            System.out.printf(String.format("Payment body: "+"%.2f",paymentBody)+"\t");
            System.out.println(String.format("Payment balance: "+"%.2f",balance));
        }
    }

    public static double allSum(double rate, double limit, double sum){
        return sum * (rate/12 * Math.pow((1+rate/12),limit))/(Math.pow((1+rate/12),limit)-1);
    }

    public static double percent(double sum, double balance,double rate){
        return balance * rate/12;
    }

    public static double body(double paymentMonth, double paymentPercent){
        return paymentMonth-paymentPercent;
    }

    public static double balance(double balance, double paymentBody){
        return balance-paymentBody;
    }

    public static double all(double paymentMonth, double limit){
        return limit*paymentMonth;
    }
}
