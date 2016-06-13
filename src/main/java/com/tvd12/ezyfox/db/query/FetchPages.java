/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.tvd12.ezyfox.db.Query;
import com.tvd12.ezyfox.db.support.BasePage;
import com.tvd12.ezyfox.db.support.Page;

/**
 * Base class supports to fetch list of records in a table and sort them to list of pages
 * 
 * @author tavandung12
 *
 */
public abstract class FetchPages implements Query {

    protected int from;
    protected int pageCount;
    protected int pageSize;
    
    protected abstract List<?> getEntities(Session session);
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<Page> execute(Session session) {
        List entities = getEntities(session);
        List<Page> answer = createPages(entities.size());
        for(int i = 0 ; i < answer.size() ; i++) {
            List items = new ArrayList<>();
            for(int k = 0 ; k < pageSize ; k ++) {
                int index = i * pageSize + k;
                if(index == entities.size())
                    break;
                items.add(entities.get(index));
            }
            ((BasePage)answer.get(i)).setItems(items);
        }
        return answer;
    }
    
    private List<Page> createPages(int entityCount) {
        List<Page> answer = new ArrayList<>();
        for(int i = 0 ; i < pageCount && entityCount > 0 ; i++) { 
            BasePage page = new BasePage();
            page.setIndex(i);
            page.setFrom(from + i * pageSize);
            answer.add(page);
            entityCount -= pageSize;
        }
        return answer;
    }
    
    @SuppressWarnings("unchecked")
    public <T extends FetchPages> T from(int from) {
        this.from = from;
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    public <T extends FetchPages> T pageCount(int count) {
        this.pageCount = count;
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    public <T extends FetchPages> T pageSize(int size) {
        this.pageSize = size;
        return (T) this;
    }
}
