package com.example.smarthomes.register.testing;

import com.example.smarthomes.register.entity.model.User;
import com.example.smarthomes.register.entity.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByEmailTest() {
        testEntityManager.persist(new User("Test", "Test", "test.test", "test.test@gmail.com", "Ts@123456"));

        Optional<User> user = Optional.ofNullable(userRepository.findByEmail("test.test@gmail.com"));
        assertEquals("test.test@gmail.com", user.get().getEmail());
    }
}