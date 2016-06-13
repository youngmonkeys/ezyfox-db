/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import java.util.List;

import com.tvd12.ezyfox.db.query.FetchPagesByEntity;
import com.tvd12.ezyfox.db.support.Page;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import com.tvd12.ezyfox.db.testing.GameUser;
import static org.testng.Assert.*;

/**
 * @author tavandung12
 *
 */
public class FetchPagesByEntityTest extends BaseDbTest {

    @Override
    public void doSomeThing() {
        List<Page> pages = execute(new FetchPagesByEntity()
                .entityType(GameUser.class)
                .from(1)
                .pageCount(2)
                .pageSize(2));
        assertEquals(pages.size(), 2);
        
        pages = execute(new FetchPagesByEntity()
                .entityType(GameUser.class)
                .from(0)
                .pageCount(3)
                .pageSize(2));
        assertEquals(pages.size(), 3);
        assertEquals(pages.get(2).getSize(), 1);
        
        pages = execute(new FetchPagesByEntity()
                .entityType(GameUser.class)
                .from(0)
                .pageCount(5)
                .pageSize(1));
        assertEquals(pages.size(), 5);
        
        pages = execute(new FetchPagesByEntity()
                .entityType(GameUser.class)
                .from(0)
                .pageCount(0)
                .pageSize(1));
        assertEquals(pages.size(), 0);
        
        deleteAll();
        
        pages = execute(new FetchPagesByEntity()
                .entityType(GameUser.class)
                .from(0)
                .pageCount(5)
                .pageSize(1));
        assertEquals(pages.size(), 0);
    }
    
}
