public class ElectricalAppliance extends Item{
    private String brandName;
    private int serialNum;
    
    public ElectricalAppliance(){}
    public ElectricalAppliance(int ID, String name, double price, int stock, String bName, int sNum){
        super(ID, name, price, stock);
        this.brandName = bName;
        this.serialNum = sNum;
    }
    
    public void setElectricalAppliance (int ID, String name, double price, int stock, String bName, int sNum){
        super.setItem(ID, name, price, stock);
        this.brandName = bName;
        this.serialNum = sNum;
    }
    public String getBrandName(){
        return brandName;
    }
    public int getSerialNum(){
        return serialNum;
    }
    
    @Override
    public String toString(){
        return (super.toString() + "\nBrand Name: " + brandName + "\nProduct Serial Number: " + serialNum);
    }
}