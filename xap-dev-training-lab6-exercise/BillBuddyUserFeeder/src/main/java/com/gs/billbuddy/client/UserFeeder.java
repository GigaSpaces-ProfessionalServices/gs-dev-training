package com.gs.billbuddy.client;
import java.util.ArrayList;

import com.gs.billbuddy.model.AccountStatus;
import com.gs.billbuddy.model.User;
import org.openspaces.core.GigaSpace;

/** 
 * User Feeder class reads userNameList which is stored in users data member. 
 * The class performing loop on the list and create user class and write it into space
 * 
 * The Class also enables creating one static user & write into the space
 * 
 * @author gsUniversity
 */


public class UserFeeder {
	
	@SuppressWarnings("serial")
	private static final ArrayList<String> users=new ArrayList<String>(){{
	    add("James Johnson"); add("Peter Gardener"); add("Andrei Saizovsky"); add("Petr Kirul"); 
	    add("Gerard Bourtagne"); add("Hans Freihof"); add("Sami Filppula"); add("Niklas Nilsson"); 	
	    add("Marian Varga"); add("Sigur Briem"); add("Bill Klien"); add("David King"); add("Magic Jordan"); 
	    add("Hana Brill"); add("Mustafa Cohen"); add("Michel Peet"); add("Samnta Gold");
	    add("Snoop Cat"); add("Marian Vog"); add("Suger Baby");
	}};
	
	public UserFeeder(){
	}

	// Method loads a list of users from users data member.
	// It then writes them into the space using a GigaSpace space proxy.
	// It reads users from the space & displays them into the console.
	
	public static void loadData(GigaSpace gigaSpace) throws Exception {
		System.out.println("Starting User Feeder");
		System.out.println("Method: loadData");
        
        Integer userAccountId = 1;
        
        // Read a list of user & iterate over them one by one.
        
        for (String userName : UserFeeder.users) {
          
        	// Check if user by the selected id already exists in the space.
     		
        	User foundUser = gigaSpace.readById(User.class,userAccountId);
            
            // Write a user to the space only if it does not exist already in the space
            
     		if (foundUser == null) {
            	
            	// create user
            	
            	User user = new User();
            	user.setName(userName);
                user.setBalance(0.0);
                user.setCreditLimit(-10000.0);
                
                user.setStatus(AccountStatus.ACTIVE);
                user.setUserAccountId(userAccountId);
                
                // Write user to the space
                
                gigaSpace.write(user);
            }
            userAccountId++;
        }

        System.out.println("Stopping User Feeder writing process");
        System.out.println("Start User reader");
        
        //Creating a template for query (And Equal conditions)
       
        User templateUser = new User();
        
        //Reading first 100 user objects that meet the template
        
        User userList []  = gigaSpace.readMultiple(templateUser,100);
      
        // Display users read from the space to the console
        
        for (User user : userList){
        	System.out.print(" User ID: " + user.getUserAccountId());
        	System.out.print(" User Name: " + user.getName());
        	System.out.print(" User Balance: " + user.getBalance());
        	System.out.print(" User Status: " + user.getStatus());
        	System.out.println();
        }
    }
}
