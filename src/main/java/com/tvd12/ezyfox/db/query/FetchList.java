/**
 * 
 */
package com.tvd12.ezyfox.db.query;

import com.tvd12.ezyfox.db.Query;

/**
 * Base class to support fetch list of records in a table
 * 
 * @author tavandung12
 *
 */
public abstract class FetchList implements Query {

    protected int from;
    protected int size;
    
    @SuppressWarnings("unchecked")
    public <T extends FetchList> T from(int from) {
        this.from = from;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends FetchList> T size(int size) {
        this.size = size;
        return (T) this;
    }
    
}
