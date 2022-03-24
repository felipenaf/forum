package github.io.forum;

import github.io.forum.entity.UserEntity;
import github.io.forum.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUserTest() {
//        If I save the userEntity in the database the userRepository set an id to UserEntity automagically
        UserEntity userEntity = new UserEntity("Felipe", "felipe@felipe", "123");
        assertThat(userEntity.getId()).isNull();
        userRepository.save(userEntity);
        assertThat(userEntity.getEmail()).isEqualTo("felipe@felipe");
        assertThat(userEntity.getName()).isEqualTo("Felipe");
        assertThat(userEntity.getPassword()).isEqualTo("123");
        assertThat(userEntity.getId()).isEqualTo(1);
    }

    @Test
    public void getAllTest() {
        UserEntity userEntity = new UserEntity("Felipe", "felipe@felipe", "123");
        UserEntity userEntity2 = new UserEntity("Dunha", "dunha@test", "123");
        userEntity2.setDeleted(true);
        this.userRepository.save(userEntity);
        this.userRepository.save(userEntity2);

        List<UserEntity> result = userRepository.findAllByDeleted(false);
        assertThat(result.size()).isEqualTo(1);
    }

}
