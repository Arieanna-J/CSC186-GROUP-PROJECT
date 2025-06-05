public class Customer {
    private int customerID;
    private String customerName;
    private String phoneNum;
    private Date date;
    
    public Customer(){}
    public Customer(int ID, String name, String num, Date date){
        this.customerID = ID;
        this.customerName = name;
        this.phoneNum = num;
        this.date = date;
    }
    public void setPhoneNum(String num){
        this.phoneNum = num;
    }
    public int getCustomerID(){
        return customerID;
    }
    public String getCustomerName(){
        return customerName;
    }
    public String getPhoneNum(){
        return phoneNum;
    }
    
    // Method for Customer Home Menu Apps
        public void customerMenu(){
        System.out.println("*-*-* Welcome to EzJay's Enterprises! *-*-*");
        System.out.println("Options:");
        System.out.println("1. Proceed with Shopping");
        System.out.println("2. Return to Login Menu");
        System.out.println("Please Select An Option to Proceed:");
    }
    
    
}