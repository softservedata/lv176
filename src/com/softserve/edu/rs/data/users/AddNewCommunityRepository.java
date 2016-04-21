package com.softserve.edu.rs.data.users;

public class AddNewCommunityRepository {
	 private static volatile AddNewCommunityRepository instance = null;

		private AddNewCommunityRepository() {
		}
		
	    public static AddNewCommunityRepository get() {
	        if (instance == null) {
	            synchronized (UserRepository.class) {
	                if (instance == null) {
	                    instance = new AddNewCommunityRepository();
	                }
	            }
	        }
	        return instance;
	    }
	    
	    public AddNewCommunity getCreateNewCommunityForEdit() {
	    	
			return AddNewCommunity.get().setnameCommunity("Черкаська")
					.setregisterNumber("111:34:22:222:22222")
					.build();			
	    }
	    public AddNewCommunity getNewCommunityForClear() {
			// TODO Read from file
	    	
			return AddNewCommunity.get().setnameCommunity("Ланівецька")
					.setregisterNumber("111:22:22:222:22222")
					.build();			
	    }
	   public AddNewCommunity getNewCommunityForDelete() {
			// TODO Read from file
	    	
			return AddNewCommunity.get().setnameCommunity("Житомирська")
					.setregisterNumber("122:22:22:222:22222")
					.build();			
	    }
	    
	    public AddNewCommunity getNewCommunityAlphabetical() {
			// TODO Read from file
	    	
			return AddNewCommunity.get().setnameCommunity("Poltava")
					                    .setregisterNumber("122:42:85:222:89295")
					                    
					                    .build();
			      
			
	    }
	    
	    public AddNewCommunity getNewCommunityCyrillic() {
			// TODO Read from file
	    	
			return AddNewCommunity.get().setnameCommunity("Винники")
					.setregisterNumber("122:22:22:222:22222")
					.build();			
	    }
	    
	   public AddNewCommunity getNewCommunityNumber() {
			// TODO Read from file
	    	
			return AddNewCommunity.get().setnameCommunity("12345")
					.setregisterNumber("122:22:05:222:28295")
					
					.build();	
	   }
			
	    public AddNewCommunity getNewCommunityEmptyNumber() {
			// TODO Read from file
	    	
			return AddNewCommunity.get().setnameCommunity("EmptyNumber")
					.setregisterNumber("")
					.build();			
	    }						
}
