/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import java.util.List;

import com.tvd12.ezyfox.db.query.FetchListByEntity;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;
import static org.testng.Assert.*;

/**
 * @author tavandung12
 *
 */
public class FetchListByEntityTest extends BaseDbTest {

    @Override
    public void doSomeThing() {
        List<GameUser> users = execute(new FetchListByEntity()
                .entityType(GameUser.class)
                .from(1)
                .size(3));
        assertEquals(users.size(), 3);
    }
    
}
