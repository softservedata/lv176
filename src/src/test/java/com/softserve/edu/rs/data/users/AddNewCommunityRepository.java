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
	    
	    public AddNewCommunity getCreateCommunityForEdit() {
			return AddNewCommunity.get().setnameCommunity("Черкаська територіальна громада")
					.setregisterNumber("111:34:22:222:22222")
					.build();			
	    }
	    
	    public AddNewCommunity getCreateCommunityForCheckEditOption() {
	     	return AddNewCommunity.get().setnameCommunity("Тернопільська територіальна громада")
	 					.setregisterNumber("111:34:22:222:22222")
	 					.build();			
	 	    }
	    
	    public AddNewCommunity getCommunityForClear() {
			return AddNewCommunity.get().setnameCommunity("Київська територіальна громада")
					.setregisterNumber("111:22:22:222:22222")
					.build();			
	    }
	   public AddNewCommunity getCommunityForDelete() {
			// TODO Read from file
	    	
			return AddNewCommunity.get().setnameCommunity("Хмельницька територіальна громада")
					.setregisterNumber("122:22:22:222:22222")
					.build();			
	    }
	    
	    public AddNewCommunity getCommunityWithAlphabeticalSymbols() {
			// TODO Read from file
	    	
			return AddNewCommunity.get().setnameCommunity("USA Community")
					                    .setregisterNumber("122:42:85:222:89295")
					                    
					                    .build();
			      
			
	    }
	    
	    public AddNewCommunity getCommunityWithCyrillicSymbols() {
			// TODO Read from file
	    	
			return AddNewCommunity.get().setnameCommunity("Зборівська територіальна громада")
					.setregisterNumber("122:22:22:222:22222")
					.build();			
	    }
	    
	   public AddNewCommunity getCommunityWithOnlyNumberSymbols() {
			// TODO Read from file
	    	
			return AddNewCommunity.get().setnameCommunity("0123456789")
					.setregisterNumber("122:22:05:222:28295")
					
					.build();	
	   }
	   public AddNewCommunity getCommunityEmptyFields() {
			// TODO Read from file
	    	
			return AddNewCommunity.get().setnameCommunity("")
					.setregisterNumber("")
					.build();			
	    }
			
	    public AddNewCommunity geCommunityEmptyNumberField() {
			// TODO Read from file
	    	
			return AddNewCommunity.get().setnameCommunity("EmptyNumber")
					.setregisterNumber("")
					.build();			
	    }	
	    
	    public AddNewCommunity getCommunityForVerifyUnique() {
	 			// TODO Read from file
	 			return AddNewCommunity.get().setnameCommunity("Lviv")
	 					.setregisterNumber("")
	 					.build();			
	 	    }
}
