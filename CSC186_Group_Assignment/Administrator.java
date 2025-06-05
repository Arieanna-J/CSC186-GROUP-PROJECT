import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Administrator{
    private String adID;
    private String password;
    
    public Administrator(){}
    public Administrator(String ID, String password){
        this.adID = ID;
        this.password = password;
    }
    
    public boolean authentifiction() {
        boolean adminIdentify = false;
        try {
            FileReader fr = new FileReader("C:/Users/Arieanna/Documents/CSC186 [Java Coding]/Group Assignment/Java Coding/admin.txt");
            BufferedReader br = new BufferedReader(fr);
            String data;
            StringTokenizer st;

            while ((data = br.readLine()) != null) {
                st = new StringTokenizer(data, ",");
                String adminID = st.nextToken();
                String pass = st.nextToken();

                if (this.adID.equals(adminID) && this.password.equals(pass)) {
                    adminIdentify = true;
                    break;
                }
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problem:" + e.getMessage());
        } catch (IOException ioe) {
            System.out.println("Problem:" + ioe.getMessage());
        } finally {}
        
        return adminIdentify;
    }
    
    // Methods for Admin Home Menu Apps
    public void homeMenu(){
        System.out.println("*-*-* EZJAY ENTERPRISES HOME MENU [ADMIN] *-*-*");
        System.out.println("Options:");
        System.out.println("1. Manage Items");
        System.out.println("2. Manage Customers");
        System.out.println("3. Add Items");
        System.out.println("4. Company's Statistics");
        System.out.println("5. Logout");
        System.out.println("Please Select An Option to Proceed:");
    }
}