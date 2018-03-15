package test;

import com.leon.learnspringboot.Application;
import com.leon.learnspringboot.model.Contact;
import com.leon.learnspringboot.service.ContactService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created on 15/03/2018.
 *
 * @author Xiaolei-Peng
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class SpringBootApplicationTest {

    @Autowired
    private ContactService contactService;

    @Test
    public void testService() {
        List<Contact> contacts = contactService.findAllContact(0, 3);
        Assert.assertNotNull(contacts);
    }
}
