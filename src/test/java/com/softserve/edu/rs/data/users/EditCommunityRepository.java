package com.softserve.edu.rs.data.users;

public class EditCommunityRepository {
	
	 private static volatile EditCommunityRepository instance = null;

		private EditCommunityRepository() {
		}
		
	    public static EditCommunityRepository get() {
	        if (instance == null) {
	            synchronized (UserRepository.class) {
	                if (instance == null) {
	                    instance = new EditCommunityRepository();
	                }
	            }
	        }
	        return instance;
	    }
	    
	    public EditCommunity getNewCommunityForEdit() {
	    	return EditCommunity.get().setnameCommunityEdit("Полтавська територіальна громада")
	    			.setregisterNumberEdit("122:22:23:222:22222")
	    			.build();
	    }
	    
}
