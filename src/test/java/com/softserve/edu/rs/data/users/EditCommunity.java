package com.softserve.edu.rs.data.users;


	interface InameCommunityEdit{
		IregisterNumberEdit setnameCommunityEdit(String nameCommunityEdit);
		}

	interface IregisterNumberEdit {
		IBuildCommunityEdit setregisterNumberEdit(String registerNumberEdit);
	}

	interface IBuildCommunityEdit {
		EditCommunity build();
	}


	public class EditCommunity  implements InameCommunityEdit, IregisterNumberEdit, IBuildCommunityEdit, IEditCommunity {
			private String nameCommunityEdit;
			private String registerNumberEdit;
			
			private EditCommunity(){
				
			}
			
			
			// static factory - - - - - - - - - -
			
			public static InameCommunityEdit get() {
				return new EditCommunity();
			}

			// set - - - - - - - - - -

			public IregisterNumberEdit setnameCommunityEdit(String nameCommunityEdit) {
				this.nameCommunityEdit = nameCommunityEdit;
				return this;
			}

			public IBuildCommunityEdit setregisterNumberEdit(String registerNumberEdit) {
				this.registerNumberEdit = registerNumberEdit;
				return this;
			}

			public EditCommunity build() {
				return this;
			}
		

			
			// get - - - - - - - - - -
			public String getNameCommunityEdit() {
				return nameCommunityEdit;
			}
			
			public String getRegisterNumberEdit() {
				return registerNumberEdit;
			}


			

			

}
