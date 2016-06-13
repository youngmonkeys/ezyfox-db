/**
 * 
 */
package com.tvd12.ezyfox.db.support;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents to a page contains list of items
 * 
 * @author tavandung12
 *
 */
@Setter
public class BasePage implements Page {

    @Getter
    private int from;
    @Getter
    private int index;
    
    @SuppressWarnings("rawtypes")
    private List items;
    
    public int getSize() {
        return items.size();
    }
    
    public int getEnd() {
        return getFrom() + getSize();
    }
    
    @SuppressWarnings("unchecked")
    public <T> List<T> getItems() {
        return Collections.unmodifiableList(items);
    }
    
}
