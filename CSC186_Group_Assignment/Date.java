public class Date {
    private int day, month, year;
    
    public Date(){}
    public Date(int dd, int mm, int yy){
        this.day = dd;
        this.month = mm;
        this.year = yy;
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    @Override
    public String toString(){
        return (day + "/" + month + "/" + year);
    }
    
}