package se.lexicon.advertisement_serving_api;


    import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
    import se.lexicon.advertisement_creation_api.entity.User;
    import se.lexicon.

    @SpringBootTest
    @Rollback
    @Transactional
    public class UserRepositoryTest {

        @Autowired
        UserRepository repo;

        @Test
        public void TestEmail(){
            User testUser = new User("testuser", "testpass", "test@test.te");
            User testUser2 = new User("testuser", "testpass", "test@test.te");
            repo.save(testUser);
            if(repo.findById(testUser2.getEmail()).isPresent()){
                System.out.println("Email already exist");
            }
            else repo.save(testUser2);
            int actual = repo.findAll().size();
            int expected = 1;
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void TestUserLogin(){
            User testUser = new User("testuser", "testpass", "test@test.te");
            repo.save(testUser);

            testUser = repo.findUser(testUser.getUsername(), testUser.getPassword(), testUser.getEmail());
            System.out.println(testUser);
            Assertions.assertNotNull(testUser);


        }
    }
}
