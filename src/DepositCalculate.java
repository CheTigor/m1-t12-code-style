import java.util.Scanner;
import java.lang.Math;

public class DepositCalculate {

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double payment = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(payment, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        double payment = amount + amount * yearRate * period;
        return round(payment, 2);
    }

    double round(double value, int places) {
       double scale = Math.pow(10, places);
       return Math.round(value * scale) / scale;
    }

    void calculateContributionResult() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Введите сумму вклада в рублях:");
      int amount = scanner.nextInt();
      System.out.println("Введите срок вклада в годах:") ;
      int period = scanner.nextInt( );
      System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
      int action = scanner.nextInt();
      double payment = 0;
      if (action ==1) {
          payment = calculateSimplePercent(amount, 0.06, period);
      } else if (action == 2) {
          payment = calculateComplexPercent(amount, 0.06, period);
      }
      System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + payment);
    }
}
