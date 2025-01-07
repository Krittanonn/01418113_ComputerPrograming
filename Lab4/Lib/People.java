package Lib;

public class People{

    private String firstname;
    private String lastname;
    protected MyDate birthdate = new MyDate() ;

    public String getfirstname(){
        return this.firstname;
    }
    public void setfirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getlastname(){
        return this.lastname;
    }
    public void setlastname(String lastname){
        this.lastname = lastname;
    }

    public String getname(){
        return this.getfirstname() + this.getlastname();
    }
    public void setname(String firstname, String lastname){
        this.setfirstname(firstname);
        this.setlastname(lastname);
    }

    public MyDate getbirthdate(){
        return this.birthdate;
    }
    public void setbirthdate (int d, int m, int y){
        this.birthdate.setDate(d, m, y);
    }

    public String toString(){
        String s = "My name is"+firstname+" "+lastname+"."+"\nI was born on "+birthdate;
        return s;
    }
}
