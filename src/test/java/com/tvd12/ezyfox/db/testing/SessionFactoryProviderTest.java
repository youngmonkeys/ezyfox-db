/**
 * 
 */
package com.tvd12.ezyfox.db.testing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import com.tvd12.ezyfox.db.QueryExecutor;
import com.tvd12.ezyfox.db.SessionFactoryProvider;
import com.tvd12.ezyfox.db.query.Save;
import com.tvd12.test.base.BaseTest;

/**
 * @author tavandung12
 *
 */
public class SessionFactoryProviderTest extends BaseTest {
    
    @Test
    public void test() {
        List<Class<?>> classes = new ArrayList<>();
        classes.add(GameUser.class);
        SessionFactoryProvider.getInstance()
            .loader().setProperty("a", "b")
            .addAnnotatedClasses(classes);
    }
    
    @Test(expectedExceptions = {IllegalStateException.class})
    public void test1() {
        List<Class<?>> classes = new ArrayList<>();
        classes.add(GameUser.class);
        SessionFactoryProvider.getInstance()
            .loader().setProperty("a", "b")
            .addAnnotatedClasses(classes)
            .setProperties("abc");
    }
    
    public static void main(String[] args) {
        SessionFactoryProvider.getInstance()
            .loader()
            .context(SessionFactoryProviderTest.class)
            .setProperties("hibernate_h2.properties")
            .addAnnotatedClass(GameUser.class)
            .load();
        GameUser user = new GameUser();
        user.setId(1);
        user.setName("dungtv14");
        user.setMoney(123456);
        user.setLastLoginTime(new Date());
        user.setLastLogoutTime(new Date());
        user.setIp("1.2.3.4");
        user = new QueryExecutor().execute(SessionFactoryProviderTest.class, new Save(user));
        System.out.println(user);
    }
    
}
