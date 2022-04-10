package com.adafpc.letscode.banco.repository;

import com.adafpc.letscode.banco.dto.UserResponse;
import com.adafpc.letscode.banco.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryIntegrationTest {

    @Autowired
    UserRepository repository;

    @Test
    @Sql("file:src/test/resources/users.sql")
    void shouldListAll(){
        List<User> users = repository.findAll();
        assertThat(users)
                .isNotNull()
                .isNotEmpty()
                .hasSize(6);
    }

    @Test
    @Sql("file:src/test/resources/users.sql")
    void shouldListAllByPage(){
        Page<User> users = repository.findAll(PageRequest.of(0,2));
        assertThat(users.getContent())
                .isNotNull()
                .isNotEmpty()
                .hasSize(2);
    }

    @Test
    @Sql("file:src/test/resources/users.sql")
    void shouldFindByCPF(){
        List<UserResponse> users = repository.findByCpf("82048837456");
        assertThat(users)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);
    }

}