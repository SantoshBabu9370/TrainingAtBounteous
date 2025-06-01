import java.util.*;

public class TaxCalculator{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Salary:");double sal=s.nextDouble();
        System.out.print("Age:");int age=s.nextInt();
        System.out.print("Investments:");double inv=s.nextDouble();
        System.out.print("Health Premium:");double hp=s.nextDouble();
        System.out.print("Home Loan Interest:");double hli=s.nextDouble();

        double d80C=Math.min(inv,150000),d80D=Math.min(hp,(age>=60?50000:25000)),d24=Math.min(hli,200000);
        double deductions=d80C+d80D+d24,taxable=sal-deductions;if(taxable<0)taxable=0;
        double tax=0;

        if(age<60){
            if(taxable<=250000)tax=0;
            else if(taxable<=500000)tax=(taxable-250000)*0.05;
            else if(taxable<=1000000)tax=12500+(taxable-500000)*0.2;
            else tax=112500+(taxable-1000000)*0.3;
        }else if(age<=80){
            if(taxable<=300000)tax=0;
            else if(taxable<=500000)tax=(taxable-300000)*0.05;
            else if(taxable<=1000000)tax=10000+(taxable-500000)*0.2;
            else tax=110000+(taxable-1000000)*0.3;
        }else{
            if(taxable<=500000)tax=0;
            else if(taxable<=1000000)tax=(taxable-500000)*0.2;
            else tax=100000+(taxable-1000000)*0.3;
        }

        System.out.printf("\nTaxable Income: INR %.2f\nTax Payable: INR %.2f\n",taxable,tax);

    }
}
