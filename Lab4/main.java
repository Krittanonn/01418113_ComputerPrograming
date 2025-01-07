import Lib.Employee;
import Lib.MyDate;

public class Main {
    public static void main(String[] args){
        MyDate x = new MyDate();

        // x.setDate(16, 8, 2005);
        // System.out.println(x.toString());
        // x.setMount(20);

        // People A = new People();
        // A.setname("David", "Beckham");
        // A.setbirthdate(2, 5, 1975);
        // System.out.println(A.toString());

        Employee j = new Employee();
        Employee k = new Employee();

        j.setname("Leo", "messi");
        j.setbirthdate(24, 6, 1987);
        j.setCompany("Argentina");
        j.setSalary(15000);

        k.setname("Crist", "Red field");
        k.setbirthdate(5, 2, 1985);
        k.setCompany("Portugal");
        k.setSalary(19000);

        if(j.taxpay())j.show();

    }    
}
