package test;

import com.leon.learncache.bean.Role;
import com.leon.learncache.config.ConcurrentMapCacheConfig;
import com.leon.learncache.config.EhCacheConfig;
import com.leon.learncache.config.RedisCacheConfig;
import com.leon.learncache.dao.RoleDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created on 13/03/2018.
 *
 * @author Xiaolei-Peng
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EhCacheConfig.class) // Java配置方式测试
//@ContextConfiguration(locations = {"classpath:spring/spring-mvc.xml"}) //XML配置方式测试
public class CacheTest {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void testFindOne() {
        Role role = roleDao.findOne(1);
        System.out.println(role.getName());
        Assert.assertEquals(1, role.getId());
    }

    @Test
    public void testRemove() {
        roleDao.remove(1);
    }



}
