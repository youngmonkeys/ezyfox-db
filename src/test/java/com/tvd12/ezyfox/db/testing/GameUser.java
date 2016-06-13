/**
 * 
 */
package com.tvd12.ezyfox.db.testing;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author tavandung12
 *
 */
@Data
@Entity
@Cacheable
@NaturalIdCache
@Table(name = "ezyfox_db_user")
@DynamicUpdate(false)
@DynamicInsert(false)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,
       region = "com.tvd12.ezyfox.db.testing.GameUser")
@EqualsAndHashCode(callSuper = false)
public class GameUser {
    
    @Column(name = "money")
    private long money = 200000; 
    
    @Transient
    private long gameMoney = 0;
    
    @Column(name = "last_login")
    private Date lastLoginTime = new Date();
    
    @Column(name = "last_logout")
    private Date lastLogoutTime;
    
    @Id
    private int id;
    
    @NaturalId(mutable = false)
    @Column(name = "username")
    private String name;
    
    @Column(name = "last_login_ip")
    private String ip;
    
    
}
