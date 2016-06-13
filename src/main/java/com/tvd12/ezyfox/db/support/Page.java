/**
 * 
 */
package com.tvd12.ezyfox.db.support;

import java.util.List;

/**
 * Represents to a page contains list of items
 * 
 * @author tavandung12
 *
 */
public interface Page {
    
    int getFrom();
    
    int getEnd();

    int getIndex();
    
    int getSize();
    
    <T> List<T> getItems();
    
}
