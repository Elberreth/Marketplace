package se.lexicon.advertisement_creation_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import se.lexicon.entity.User;


    public interface UserRepository extends JpaRepository<User, String> {

        @Query("Select u from User u where u.username = :username and u.password = :password and u.email = :email")
        public User findUser(String username, String password, String email);
}
