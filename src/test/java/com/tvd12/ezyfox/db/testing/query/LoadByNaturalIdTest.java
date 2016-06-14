/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import static org.testng.Assert.assertNotNull;

import com.tvd12.ezyfox.db.query.LoadByNaturalId;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;

/**
 * @author tavandung12
 *
 */
public class LoadByNaturalIdTest extends BaseDbTest {

    @Override
    public void doSomeThing() {
        GameUser user = execute(new LoadByNaturalId()
                .entityClass(GameUser.class)
                .using("name", "dungtv14#" + (id)));
        assertNotNull(user);
    }
    
}
