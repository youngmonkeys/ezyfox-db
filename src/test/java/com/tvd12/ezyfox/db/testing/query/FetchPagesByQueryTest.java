/**
 * 
 */
package com.tvd12.ezyfox.db.testing.query;

import java.util.List;

import com.tvd12.ezyfox.db.query.FetchPagesByQuery;
import com.tvd12.ezyfox.db.support.Page;
import com.tvd12.ezyfox.db.testing.BaseDbTest;
import static org.testng.Assert.*;

/**
 * @author tavandung12
 *
 */
public class FetchPagesByQueryTest extends BaseDbTest {

    @Override
    public void doSomeThing() {
        List<Page> pages = execute(new FetchPagesByQuery()
                .from(0)
                .pageCount(2)
                .pageSize(2)
                .query("SELECT u FROM GameUser u WHERE u.id < :id")
                .param("id", 1000000));
        assertEquals(pages.size(), 2);
        assertEquals(pages.get(0).getEnd(), 2);
        assertEquals(pages.get(0).getItems().size(), 2);
        assertEquals(pages.get(0).getFrom(), 0);
        assertEquals(pages.get(1).getFrom(), 2);
        assertEquals(pages.get(0).getIndex(), 0);
    }
    
}
