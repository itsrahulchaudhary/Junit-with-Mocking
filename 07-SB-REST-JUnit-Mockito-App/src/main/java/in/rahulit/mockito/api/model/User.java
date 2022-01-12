package in.rahulit.mockito.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "users")
public class User {
	
	@Id
	private int id;
	private String name;
	private int age;
	private String address;
	
	public User(int i, String string, int j, String string2) {
		// TODO Auto-generated constructor stub
	}

}
