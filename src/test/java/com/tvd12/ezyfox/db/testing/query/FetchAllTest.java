/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import static org.testng.Assert.assertEquals;

import java.util.List;

import com.tvd12.ezyfox.db.query.FetchAll;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;

/**
 * @author tavandung12
 *
 */
public class FetchAllTest extends BaseDbTest {

    @Override
    public void doSomeThing() {
        List<GameUser> users = execute(new FetchAll()
                    .entityType(GameUser.class));
        assertEquals(users.size(), 5);
    }
    
}
