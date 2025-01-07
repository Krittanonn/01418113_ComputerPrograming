package Lib;

public class Employee extends People{
    private String company;
    private double salary;
    
    public String getCompany() {
        return this.company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    public double getSalary() {
        return this.salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public boolean taxpay(){
        return ((salary * 12)> 100000);
    }

    private People name = new People();
    public People getName(){
        return name;
    }
    public void setname(String firstname, String lastname){
        this.name.setfirstname(firstname);
        this.name.setlastname(lastname);
    }
    private MyDate birthdayDate = new MyDate();
    public MyDate getbirthDate(){
        return  this.birthdate;
    }
    public void show(){
        System.out.println("I'm "+this.name.getfirstname()+" "+this.name.getlastname()+ "\nI work for"+this.company+".");
    }

}
