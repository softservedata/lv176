package com.softserve.edu.rs.data.users;

interface InameCommunity{
	IregisterNumber setnameCommunity(String nameCommunity);
	}

interface IregisterNumber {
	IBuildCommunity setregisterNumber(String registerNumber);
}

interface IBuildCommunity {
	AddNewCommunity build();
}


public class AddNewCommunity  implements InameCommunity, IregisterNumber, IBuildCommunity, IAddNewCommunity {
		private String nameCommunity;
		private String registerNumber;
		
		private AddNewCommunity(){
			
		}
		
		
		// static factory - - - - - - - - - -
		
		public static InameCommunity get() {
			return new AddNewCommunity();
		}

		// set - - - - - - - - - -

		public IregisterNumber setnameCommunity(String nameCommunity) {
			this.nameCommunity = nameCommunity;
			return this;
		}

		public IBuildCommunity setregisterNumber(String registerNumber) {
			this.registerNumber = registerNumber;
			return this;
		}

		public AddNewCommunity build() {
			return this;
		}
	

		
		// get - - - - - - - - - -
		public String getnameCommunity() {
			return nameCommunity;
		}
		
		public String getregisterNumber() {
			return registerNumber;
		}


	}
	


