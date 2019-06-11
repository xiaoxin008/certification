package com.xiaoxin.certification;

import com.xiaoxin.certification.dao.AccountMapper;
import com.xiaoxin.certification.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private AccountMapper mapper;

    @Test
    public void selects() {
        Account admin = mapper.getAccountByUsername("admin");
        System.out.println(admin.toString());
    }

}
