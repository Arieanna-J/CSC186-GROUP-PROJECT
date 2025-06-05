import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Main {
    public static void main (String[] args){
        Scanner item = new Scanner(System.in);

        // Declaration of Variables:        
        // Item related Variables:
        int itemID;
        String itemName;
        double itemPrice;
        int quantityStock;
        int discount;
        // Price Related Variables:
        double totalPrice = 0;
        double totPriceStats = 0;
        double pricePayment;
        // Discount Verification Variables:
        boolean discountVerify1 = false;
        boolean discountVerify2 = false;
        // Highest Demand Calculation Variables:
        int ElectricalCount = 0; 
        int ManualCount = 0;
        // Electric + Manual Appliance related Variables
        String manualType;
        String brandName;
        int serialNum;
        // Item Objects and Menu Variables
        int itemArray = 0;
        int itemSelect;
        boolean itemAuth = false; // If set to false, that means no items have been registered in the apps yet.
        
        // Customer Variables 
        int customerID;
        String customerName;
        String phoneNum;
        Date date;
        // Customer Object and Menu Variables
        int CustomerOption = 0;
        int customerArray = 0;
        boolean customerAuth = false; // If set to false, Administrator can't access Customer's Info.
        
        // Admin Variables
        String adminID;
        String adminPass;
        // Admin Checking and Menu Variables
        boolean authentifiction = true;
        String userinput = "null";
        int purchaseinput = 0;
        int AdminOption = 1;
        
        // Date Veriables
        int day, month, year;
        
        // End of Variables Section
        // Arrays:
        Customer[] custom = new Customer[6];
        Item[] product = new Item[10];
        product[itemArray] = new ManualAppliance();
        product[itemArray] = new ElectricalAppliance();
        
        
        // START OF CODE:
        // Section 1: Date Check:
        System.out.println("Please Enter Today's Date:");
        System.out.println("Day:");
        day = item.nextInt();
        while (day > 31 || day < 1){
            System.out.println("ALERT: Invalid Date Entered! Please Try Again...");
            System.out.println("Day:");
            day = item.nextInt();
        }
        System.out.println("Month:");
        month = item.nextInt();
        while (month > 12 || month < 1){
            System.out.println("ALERT: Invalid Month Entered! Please Try Again...");
            System.out.println("Month:");
            month = item.nextInt();
        }
        System.out.println("Year:");
        year = item.nextInt();
        while (year > 2025 || year < 2018){
            if (year > 2025){
                System.out.println("ALERT: System Clock has not been registered for the year provided! Please Try Again...");
            } else {
                System.out.println("ALERT: EzJay's Enterprises does not have any records for the year provided! Please Try Again...");
            }
            System.out.println("Year:");
            year = item.nextInt();
        }
        date = new Date(day, month, year);
        item.nextLine();
        
        // Section 2: Login Section:
        do {
            System.out.println("*** LOGIN MENU ***");
            System.out.println("Are you a Customer [C] or an Administrator [A]? You may type [E] to exit the program.");
            userinput = item.nextLine();
            
            // ADMINISTRATOR
            if (userinput.equalsIgnoreCase("A")){ // Administrator Route
                System.out.println("[Please Refer to Admin.txt if You are Having Trouble Logging In!]");
                System.out.println("Insert Administrator ID");
                adminID = item.nextLine();
                System.out.println("Insert Administrator password:");
                adminPass = item.nextLine();

                Administrator admin = new Administrator(adminID, adminPass);
                if (admin.authentifiction() == true){
                    System.out.println("Login Successful! Redirecting to Home Menu...");
                    try { // 3 Second Delay by using Thread.sleep() method
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    
                    do {
                        //PHASE 2.2: HOME MENU SECTION:
                        admin.homeMenu();
                        AdminOption = item.nextInt();
                        switch (AdminOption){
                            case 1: // 1. Manage Items Section
                                System.out.println("*** MANAGE ITEMS ***");
                                System.out.println("List of Items:");
                                if (itemAuth == false){
                                    System.out.println("There is nothing on stock right now.");
                                } else {
                                    do {
                                        // Display Items
                                        for (int i = 1; i <= itemArray; i++){
                                            if (product[i] instanceof ElectricalAppliance){
                                                System.out.println(i + ".\n" + product[i].toString());
                                            } else {
                                                System.out.println(i + ".\n" + product[i].toString());
                                            }      
                                        } 
                                            
                                        System.out.println("Options:\n1. Edit [E]\n2. Quit [Q]");
                                        userinput = item.next();
                                        
                                        if (userinput.equalsIgnoreCase("E")){ // Edit Item
                                            System.out.println("Select which Item to Edit:");
                                            itemSelect = item.nextInt();
                                            
                                            while (itemSelect > itemArray){
                                                System.out.println("ERROR: Unable to Find Item. Try Again...");
                                                System.out.println("Select which Item to Edit:");
                                                itemSelect = item.nextInt();
                                            }
                                            System.out.println("*** EDITING ITEM " + itemSelect + " ***");
                                            
                                            System.out.println("Edit Item ID:");
                                            itemID = item.nextInt();
                                            item.nextLine();
                                            System.out.println("Edit Item Name:");
                                            itemName = item.nextLine();
                                            System.out.println("Edit Item Price:");
                                            itemPrice = item.nextDouble();
                                            System.out.println("Quantity of Item:");
                                            quantityStock = item.nextInt();
                                            if (product[itemSelect] instanceof ElectricalAppliance){
                                                item.nextLine();
                                                System.out.println("Edit Brand Name:");
                                                brandName = item.nextLine();
                                                System.out.println("Edit Serial Number:");
                                                serialNum = item.nextInt();
                                                
                                                ElectricalAppliance electricproduct = (ElectricalAppliance) product[itemSelect];
                                                electricproduct.setElectricalAppliance(itemID, itemName, itemPrice, quantityStock, brandName, serialNum);
                                                
                                            } else if (product[itemSelect] instanceof ManualAppliance){
                                                item.nextLine();
                                                System.out.println("Manual Type:");
                                                manualType = item.nextLine(); 
                                                System.out.println("Serial Number:");
                                                serialNum = item.nextInt();
                                                
                                                ManualAppliance manualproduct = (ManualAppliance) product[itemSelect];
                                                manualproduct.setManualAppliance(itemID, itemName, itemPrice, quantityStock, manualType, serialNum);
                                                
                                            }
                                            System.out.println("Edit Completed Sucessfully! Returning to Home Menu...");
                                            
                                        }
                                
                                    } while (userinput.equalsIgnoreCase("Q") == false);
                                }

                            break;
                                
                            case 2: // 2. Manage Customers Section
                                System.out.println("*** MANAGE CUSTOMERS ***");
                                System.out.println("Today's Customers ( " + date.toString() + " ):");
                                if (customerAuth == false){
                                    System.out.println("There is no Customer Information Registered into this System");
                                } else {
                                    do{
                                        for (int i = 1; i <= customerArray; i++){
                                            System.out.println(i + ".\nName: " + custom[i].getCustomerName() + "\nPhone Number: " + custom[i].getPhoneNum() + "\nCustomer ID: " + custom[i].getCustomerID() + "\n");
                                        }
                                        System.out.println("Options:\n1. Edit Customer's Phone Number [E]\n2. Quit [Q]");
                                        userinput = item.next();
                                        
                                        if (userinput.equalsIgnoreCase("E")){
                                            System.out.println("Select which Customer to Edit:");
                                            CustomerOption = item.nextInt();
                                            
                                            while (CustomerOption > customerArray){
                                                System.out.println("ERROR: Unable to Find Customer. Try Again...");
                                                System.out.println("Select which Customer to Edit:");
                                                CustomerOption = item.nextInt();
                                            }
                                            System.out.println("*** EDITING CUSTOMER'S PHONE NUMBER ***");
                                            item.nextLine();
                                            System.out.println("Edit Customer's Phone Number");
                                            phoneNum = item.nextLine();
                                            
                                            custom[CustomerOption].setPhoneNum(phoneNum);
                                            System.out.println("Editing Customer's Phone Number Successful!");
                                        }
                                    } while (userinput.equalsIgnoreCase("Q") == false);
                                }
                            break;
                            
                            case 3: // 3. Add Items
                                System.out.println("*** ADD ITEMS ***");
                                System.out.println("List of Items:");
                                if (itemAuth == false){
                                    System.out.println("There is nothing on stock right now.");
                                } else {
                                    for (int i = 1; i <= itemArray ; i++){
                                            if (product[i] instanceof ElectricalAppliance){
                                                System.out.println(i + ".\n" + product[i].toString());
                                            } else {
                                                System.out.println(i + ".\n" + product[i].toString());
                                            }                                          
                                    }
                                }
                                System.out.println("Would you like to add a new item into the stock? [Y/N]");
                                userinput = item.next();
                                if (userinput.equalsIgnoreCase("Y")){
                                    if (itemArray < 11){
                                        itemArray = itemArray + 1;
                                        itemAuth = true;
                                        System.out.println("*** ADD ITEM ***");
                                        System.out.println("Insert Item ID:");
                                        itemID = item.nextInt();
                                        item.nextLine();
                                        System.out.println("Insert Item Name:");
                                        itemName = item.nextLine();
                                        System.out.println("Insert Item Price:");
                                        itemPrice = item.nextDouble();
                                        System.out.println("Quantity of Item:");
                                        quantityStock = item.nextInt();
                                        System.out.println("Electrical or Manual Appliance? [E/M]");
                                        userinput = item.next();
                                        while (userinput.equalsIgnoreCase("E") == false && userinput.equalsIgnoreCase("M") == false){
                                            System.out.println("ERROR: Unable to Read Code. Try Again...");
                                            System.out.println("Electrical or Manual Appliance? [E/M]");
                                            userinput = item.next();
                                        }
                                            if (userinput.equalsIgnoreCase("E")){
                                                item.nextLine();
                                                System.out.println("Brand Name:");
                                                brandName = item.nextLine();
                                                System.out.println("Serial Number:");
                                                serialNum = item.nextInt();
                                                
                                                product[itemArray] = new ElectricalAppliance(itemID, itemName, itemPrice, quantityStock, brandName, serialNum); 
                                            } else if (userinput.equalsIgnoreCase("M")){
                                                item.nextLine();
                                                System.out.println("Manual Type:");
                                                manualType = item.nextLine(); 
                                                System.out.println("Serial Number:");
                                                serialNum = item.nextInt();
                                                
                                                product[itemArray] = new ManualAppliance(itemID, itemName, itemPrice, quantityStock, manualType, serialNum);
                                            }
                                        
                                        System.out.println("Item Added Successfully! Returning to Home Menu...");
                                    } else {
                                        System.out.println("ALERT: Maximum Stock Overload! Either Delete an Item from the Stock or Come Back the Next Day.");
                                    }
                                    
                                } else if (userinput.equalsIgnoreCase("N")){
                                        System.out.println("Returning to Home Menu...");
                                } else {
                                        System.out.println("ERROR: Unable to Read Code! Returning to Home Menu...");
                                }
                            break;
                            case 4: // 4. Comapany's Statistics
                                System.out.println("*** COMPANY'S STATISTICS ***");
                                if (ElectricalCount > ManualCount){
                                    System.out.println("Highest Demanding Item: Electrical Appliance");
                                } else if(ElectricalCount < ManualCount){
                                    System.out.println("Highest Demanding Item: Manual Appliance");
                                } else if (ElectricalCount == ManualCount){
                                    System.out.println("Highest Demanding Item: Equal");
                                }
                                System.out.println("Total Revenue on " + date.toString() + " : RM" + totPriceStats + "\n\n");
                            break;
                            }
                            
                            
                    } while (AdminOption != 5);
                    // End of Administrator's Menu
                    System.out.println("Returning back to Login Menu...");
                    userinput = "null";
                    item.nextLine();
                } else { // When Verification Fails
                    System.out.println("Login Failed! Please try again later.");
                    System.out.println("Returning back to Login Menu...");
                } // End of Administrator Section
                
            // CUSTOMER    
            } else if (userinput.equalsIgnoreCase("C")){ // Customer Route
                if (itemAuth == true){ // If set to false, that means the store is still closed
                    customerAuth = true;
                    customerArray = customerArray + 1;
                    if (customerArray < 5){
                        System.out.println("Enter Your Name:");
                        customerName = item.nextLine();
                        
                        // When a User Inputs a Name that has numeric values, an Alert will appear:
                        boolean containsNum = customerName.matches(".*\\d+.*");
                        while (containsNum == true){
                            System.out.println("ALERT: You have inserted digits into your name. Try again.");
                            System.out.println("Enter Your Name:");
                            customerName = item.nextLine();
                            containsNum = customerName.matches(".*\\d+.*");
                        }
                        
                        System.out.println("Enter Your Phone Number");
                        phoneNum = item.nextLine();
                        System.out.println("Enter Your Designated ID:");
                        customerID = item.nextInt();
                        
                        custom[customerArray] = new Customer(customerID, customerName, phoneNum, date);
                        System.out.println("Processing...Please Wait.");
                        try { // 3 Second Delay by using Thread.sleep() method
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }     
                        System.out.println("Done!");
                        //PHASE 2.3: CUSTOMER HOME MENU SECTION
                        do {
                            custom[customerArray].customerMenu();
                            CustomerOption = item.nextInt();
                            switch(CustomerOption){
                               case 1: // 1. Purchase Items 
                                    System.out.println("*** KITCHEN APPLIANCE SHOPPING MENU ***");
                                    do {
                                        for (int i = 1; i <= itemArray; i++){
                                            if (product[i] instanceof ElectricalAppliance){
                                                System.out.println(i + ".\n" + product[i].toString());
                                            } else {
                                                System.out.println(i + ".\n" + product[i].toString());
                                            }       
                                        }   
                                        System.out.println("Options:\n1. Purchase Item(s) [P]\n2. Quit [Q]");
                                        userinput = item.next();
                                        
                                        if (userinput.equalsIgnoreCase("P")){
                                            do { // Purchasing Items Section + Continue Shopping if value is set to 1.
                                                System.out.println("Select an Item you want to purchase: ");
                                                itemSelect = item.nextInt();
                                                
                                                while (itemSelect > itemArray){
                                                    System.out.println("ERROR: Unable to Find Item. Try Again...");
                                                    System.out.println("Select which Item to Edit:");
                                                    itemSelect = item.nextInt();
                                                }
                                                // Check if Quantity of Stock is still above than 0:
                                                if (product[itemSelect].getQuantity() == 0){
                                                    System.out.println("ALERT: " + product[itemSelect].getItemName() + " is out of stock! Please choose a different Item...");
                                                    itemSelect = 0;
                                                } else {
                                                    System.out.println("*** PURCHASING ITEM " + itemSelect + " ***");
                                                    System.out.println("How Many [" + product[itemSelect].getItemName() + "]s Would You Like to Purchase? [1-" + product[itemSelect].getQuantity() + "]");
                                                    purchaseinput = item.nextInt();
                                                    while (purchaseinput > product[itemSelect].getQuantity()){
                                                        System.out.println("ERROR: Value goes beyond what the Stock can provide. Re-enter your value again:");
                                                        purchaseinput = item.nextInt();
                                                    }
                                                    // TO VERIFY DISCOUNT AND THE HIGHEST DEMAND OF KITCHEN APPLIANCE TYPE:
                                                        if (product[itemSelect] instanceof ElectricalAppliance){
                                                            discountVerify1 = true;
                                                            ElectricalCount = ElectricalCount + purchaseinput;
                                                        } else if (product[itemSelect] instanceof ManualAppliance){
                                                            discountVerify2 = true;
                                                            ManualCount = ManualCount + purchaseinput;
                                                        }
                                                    // Change the Stock Quantity
                                                        product[itemSelect].setQuantity((product[itemSelect].getQuantity() - purchaseinput));
                                                    // Calculate Total Price
                                                        totalPrice = totalPrice + product[itemSelect].calcPrice(purchaseinput);
                                                    System.out.println("Total: RM" + totalPrice + "\nOptions:\n1. Continue Shopping\n2. Proceed to Checkout\n\n");
                                                    itemSelect = item.nextInt();
                                                    while (itemSelect != 1 && itemSelect != 2){
                                                        System.out.println("ERROR: Unable to Read Code. Try Again.");
                                                        itemSelect = item.nextInt();
                                                    }
                                                }
                                            } while (itemSelect != 2); // When value is 2, immediately goes into checkout.
                                            // Discount Verification Section:
                                            if (discountVerify1 == true && discountVerify2 == true){
                                                System.out.println("Congratulations! You have obtained a 60% Discount.");
                                                totalPrice = totalPrice - (totalPrice * 0.6);
                                            }
                                            System.out.println("*** CHECKOUT ***\nTotal Bill: RM" + totalPrice + "\nPayment Method: Debit or Cash? [D/C]");
                                            userinput = item.next();
                                            while (userinput.equalsIgnoreCase("D") == false && userinput.equalsIgnoreCase("C") == false){
                                                System.out.println("ERROR: Unable to Read Code. Try Again.");
                                                userinput = item.next();
                                            }
                                            if (userinput.equalsIgnoreCase("D")){
                                                System.out.println("Enter Your Amount Here:");
                                                pricePayment = item.nextDouble();
                                                if (pricePayment < totalPrice){
                                                    System.out.println("ALERT: Insufficient Amount! Please Re-type the Amount Needed to be Paid...");
                                                    pricePayment = item.nextDouble();
                                                }
                                                double balance = pricePayment - totalPrice;
                                                System.out.println("Processing Payment...");
                                                try { // 3 Second Delay by using Thread.sleep() method
                                                    Thread.sleep(3000);
                                                } catch (InterruptedException e) {
                                                    Thread.currentThread().interrupt();
                                                }
                                                System.out.println("Payment Successful!\n\n*** Receipt (" + date.toString() + ") ***\nTotal Amount: RM" + totalPrice + "\nPaid Amount: RM" + pricePayment + "\nBalance: RM" + balance + "\nPayment Method: Debit Card\nThank you for purchasing at EzJay's Enterprises!\nReturning to Home Menu...\n\n");
                                                
                                                userinput = "Q";
                                                CustomerOption = 2;
                                            } else if (userinput.equalsIgnoreCase("C")) {
                                                System.out.println("Please visit your nearest EzJay's Enterprises Branch and show them this receipt to proceed with payment.");
                                                System.out.println("Payment Successful!\n\n*** Receipt (" + date.toString() + ") ***\nTotal Amount: RM" + totalPrice + "\nPayment Method: Cash\n\nCustomer Information:\nName:" + custom[customerArray].getCustomerName() + "\nPhone Number: " + custom[customerArray].getPhoneNum() + "\n\n[YOU ARE REQUIRED TO FULFILL PAYMENT WITHIN 5 DAYS]\n\n");
                                                System.out.println("Returning to Home Menu...");
                                                
                                                userinput = "Q";
                                                CustomerOption = 2;
                                            }
                                            totPriceStats = totPriceStats + totalPrice;
                                            //Reset Values:
                                                totalPrice = 0;
                                                discountVerify1 = false;
                                                discountVerify2 = false;
                                            
                                        }
                                    } while (userinput.equalsIgnoreCase("Q") == false);
                               break;
                            }
                        } while (CustomerOption != 2);
                        // End of Customer's Menu
                        System.out.println("Returning back to Login Menu...");
                        item.nextLine();
                    } else {
                        System.out.println("Apologies, but EzJay's Enterprises is closed for today! Come again soon.");
                        System.out.println("Returning back to Login Menu...");
                    } // End of Customer Section
                } else {
                    System.out.println("Apologies, Ezjay's Enterprises has not been opened yet for today! Come back later."); 
                    System.out.println("Returning back to Login Menu...");
                }
                
            } else if (userinput.equalsIgnoreCase("E")){ // Exit
                continue;    
            } else {
                System.out.println("Error! Unable to Read Code. Returning to Login Menu..."); //When an Invalid Code is detected
                userinput = "null";
            }
            
        } while (userinput.equalsIgnoreCase("E") == false); // When [E] is entered, the program ends.
        System.out.println("Exiting Program...");
        
        try { // 3 Second Delay by using Thread.sleep() method
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
        
        System.out.println("Program has Terminated Successfully. See You Again Next Time!");
    }
}