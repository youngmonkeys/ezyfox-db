/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import com.tvd12.ezyfox.db.query.FetchById;
import com.tvd12.ezyfox.db.query.Update;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;
import static org.testng.Assert.*;

import java.util.Date;

/**
 * @author tavandung12
 *
 */
public class UpdateTest extends BaseDbTest {

    @Override
    public void doSomeThing() {
        GameUser user = execute(new FetchById(id - 1, GameUser.class));
        user.setName("hello");
        user.setLastLoginTime(new Date());
        user.setLastLogoutTime(new Date());
        new Update(user);
        execute(new Update().entity(user).entityName("GameUser"));
        assertEquals(user.getName(), "hello");
    }
    
}
