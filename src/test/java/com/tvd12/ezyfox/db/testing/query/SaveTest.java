/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import java.util.Date;
import java.util.List;

import com.tvd12.ezyfox.db.query.FetchAll;
import com.tvd12.ezyfox.db.query.Save;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;
import static org.testng.Assert.*;

/**
 * @author tavandung12
 *
 */
public class SaveTest extends BaseDbTest {

    @Override
    public void doSomeThing() {
        GameUser user = new GameUser();
        user.setId(id ++);
        user.setName("dungtv14#" + id);
        user.setMoney(123456);
        user.setLastLoginTime(new Date());
        user.setLastLogoutTime(new Date());
        user.setIp("1.2.3.4");
        execute(new Save().entity(user).entityName("GameUser"));
        user.setId(id ++);
        user.setName("dungtv14#" + id);
        execute(new Save(user));
        List<GameUser> users = execute(new FetchAll(GameUser.class));
        assertEquals(users.size(), 7);
    }
    
}
