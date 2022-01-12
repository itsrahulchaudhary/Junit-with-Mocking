package in.rahulit.mockito.api.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.rahulit.mockito.api.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{
	
	List<User> findByAddress(String address);

}
