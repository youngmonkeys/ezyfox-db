/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import static org.testng.Assert.assertEquals;

import java.util.List;

import com.tvd12.ezyfox.db.query.DeleteAll;
import com.tvd12.ezyfox.db.query.FetchAll;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;

/**
 * @author tavandung12
 *
 */
public class DeleteAllTest extends BaseDbTest {

    @Override
    public void doSomeThing() {
        execute(new DeleteAll(GameUser.class));
        List<GameUser> users = execute(new FetchAll(GameUser.class));
        assertEquals(users.size(), 0);
    }
    
}
