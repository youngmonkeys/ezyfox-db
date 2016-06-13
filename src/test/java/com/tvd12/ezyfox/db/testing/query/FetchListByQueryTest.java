/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import java.util.List;

import com.tvd12.ezyfox.db.query.FetchListByQuery;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;
import static org.testng.Assert.*;

/**
 * @author tavandung12
 *
 */
public class FetchListByQueryTest extends BaseDbTest {

    @Override
    public void doSomeThing() {
        List<GameUser> users = execute(new FetchListByQuery()
                .from(1)
                .size(3)
                .param("id", 1000000)
                .query("SELECT u FROM GameUser u WHERE u.id < :id"));
        assertEquals(users.size(), 3);
    }
    
}
