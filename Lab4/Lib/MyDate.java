package Lib;

public class MyDate {
    private int day;
    private int month;
    private int year;
    
    public int getDay(){
        return this.day;
    }
    public int getMount(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
    public void setDay(int d){
        if(d>0 && d<=31) this.day=d;
        else System.out.println("Can't set Day.");
    }
    public void setMount(int m){
        if(m>0 && m<=12) this.month=m;
        else System.out.println("Can't set Mount.");
    }
    public void setYear(int y){
        if(y>0) this.year=y;
        else System.out.println("Can't set Year.");
    }
    public void setDate(int d, int m, int y){
        this.setDay(d);
        this.setMount(m);
        this.setYear(y);
    }
    public String toString(){
        return day + "/" + month + "/" + year;
    }
}
