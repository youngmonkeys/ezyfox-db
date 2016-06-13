/**
 * 
 */
package com.tvd12.ezyfox.db.testing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.tvd12.ezyfox.db.Query;
import com.tvd12.ezyfox.db.QueryExecutor;
import com.tvd12.ezyfox.db.SessionFactoryProvider;
import com.tvd12.ezyfox.db.query.DeleteAll;
import com.tvd12.ezyfox.db.query.SaveCollection;
import com.tvd12.test.base.BaseTest;

/**
 * @author tavandung12
 *
 */
public class BaseDbTest extends BaseTest {

    public Logger logger;
    public static int id = 1;
    public static final QueryExecutor EXECUTOR = new QueryExecutor();
    
    static {
        SessionFactoryProvider.getInstance()
            .loader()
            .context(Context.class)
            .setProperties("hibernate_h2.properties")
            .addAnnotatedClass(GameUser.class)
            .load();
    }
    
    public BaseDbTest() {
        logger = LoggerFactory.getLogger(getClass());
    }
    
    @Test
    public void test() {
        SessionFactory factory = SessionFactoryProvider
                .getInstance().provide(Context.class);
        Statistics statistics = factory.getStatistics();
        SecondLevelCacheStatistics secondStat = factory.getStatistics().getSecondLevelCacheStatistics(GameUser.class.getName());
        deleteAll();
        logger.info("==========>>>deleteAll: second level cache hits: " + statistics.getSecondLevelCacheHitCount());
        logger.info("==========>>>deleteAll: query execution hits: " + statistics.getQueryExecutionCount());
        logger.info("==========>>>deleteAll: element count in mem: " + secondStat.getElementCountInMemory());
        intsert5();
        logger.info("==========>>>intsert5: second level cache hits: " + statistics.getSecondLevelCacheHitCount());
        logger.info("==========>>>intsert5: query execution hits: " + statistics.getQueryExecutionCount());
        logger.info("==========>>>intsert5: element count in mem: " + secondStat.getElementCountInMemory());
        doSomeThing();
        logger.info("==========>>>doSomeThing: second level cache hits: " + statistics.getSecondLevelCacheHitCount());
        logger.info("==========>>>doSomeThing: query execution hits: " + statistics.getQueryExecutionCount());
        logger.info("==========>>>doSomeThing: element count in mem: " + secondStat.getElementCountInMemory());
        deleteAll();
        logger.info("==========>>>deleteAll: second level cache hits: " + statistics.getSecondLevelCacheHitCount());
        logger.info("==========>>>deleteAll: query execution hits: " + statistics.getQueryExecutionCount());
        logger.info("==========>>>deleteAll: element count in mem: " + secondStat.getElementCountInMemory());
    }
    
    public void doSomeThing() {}
    
    public <T> T execute(Query query) {
        return EXECUTOR.execute(Context.class, query);
    }
    
    public void deleteAll() {
        EXECUTOR.execute(Context.class, new DeleteAll().entityClass(GameUser.class));
    }
    
    public void intsert5() {
        List<GameUser> users = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++) {
            GameUser user = new GameUser();
            user.setId(id ++);
            user.setName("dungtv14#" + id);
            user.setMoney(123456);
            user.setLastLoginTime(new Date());
            user.setLastLogoutTime(new Date());
            user.setIp("1.2.3.4");
            users.add(user);
        }
        EXECUTOR.execute(Context.class, new SaveCollection().batchSize(3).entities(users));
    }
}
