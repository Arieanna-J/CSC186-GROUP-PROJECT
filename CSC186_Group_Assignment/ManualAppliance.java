public class ManualAppliance extends Item {
    private String manualType;
    private int serialNum;
    
    public ManualAppliance(){}
    public ManualAppliance(int ID, String name, double price, int stock, String mType, int sNum){
        super(ID, name, price, stock);
        this.manualType = mType;
        this.serialNum = sNum;
    }
    
    public void setManualAppliance (int ID, String name, double price, int stock, String mType, int sNum){
        super.setItem(ID, name, price, stock);
        this.manualType = mType;
        this.serialNum = sNum;
    }
    
    public String getManualType(){
        return manualType;
    }
    public int getSerialNum(){
        return serialNum;
    }
    
    @Override
    public String toString(){
        return (super.toString() + "\nType of Product: " + manualType + "\nProduct Serial Number: " + serialNum);
    }
}