[![Build Status](https://travis-ci.org/youngmonkeys/ezyfox-db.svg?branch=master)](https://travis-ci.org/youngmonkeys/ezyfox-db)
[![Dependency Status](https://www.versioneye.com/user/projects/575f3c52b17079000d8fb81e/badge.svg?style=flat)](https://www.versioneye.com/user/projects/575f3c52b17079000d8fb81e)
[![Coverage Status](https://coveralls.io/repos/github/youngmonkeys/ezyfox-db/badge.svg?branch=master)](https://coveralls.io/github/youngmonkeys/ezyfox-db?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.tvd12/ezyfox-db/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.tvd12/ezyfox-db)
[![Javadoc](https://javadoc-emblem.rhcloud.com/doc/com.tvd12/ezyfox-db/badge.svg)](http://www.javadoc.io/doc/com.tvd12/ezyfox-db)

#Synopsis

A SQL convenience library for Java built on top of Hibernate

#Code Example

**1. Load session factory configuration**

Lets say you want to load hibernate configration file:

```
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.connection.driver_class=com.mysql.jdbc.Driver
hibernate.connection.url=jdbc:mysql://localhost/test?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
hibernate.connection.username=root
hibernate.connection.password=123
hibernate.hbm2ddl.auto=update
hibernate.show_sql=true
hibernate.connection.pool_size=10
hibernate.jdbc.batch_size=25
hibernate.cache.use_second_level_cache=true
hibernate.cache.use_query_cache=true
hibernate.cache.region.factory_class=org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory
net.sf.ehcache.configurationResourceName=/ehcache.xml
hibernate.cache.use_structured_entries=false
hibernate.generate_statistics=true
```
You can do like this:

```java
SessionFactoryProvider.getInstance()
    .loader()
    .context(Context.class)
    .setProperties("hibernate_h2.properties")
    .addAnnotatedClass(GameUser.class)
    .load();
```

**2. Save a list of entities**
```java
  List<GameUser> users = new ArrayList<>();
  for(int i = 0 ; i < 5 ; i++) {
      GameUser user = new GameUser();
      user.setId(id ++);
      user.setName("dungtv14#" + id);
      user.setMoney(123456);
      user.setLastLoginTime(new Date());
      user.setLastLogoutTime(new Date());
      user.setIp("1.2.3.4");
      users.add(user);
  }
  new QueryExecutor().execute(Context.class, new SaveCollection().batchSize(3).entities(users));
```

**3. Fetch list of entities**

```java
  List<GameUser> users = new QueryExecutor()
      .execute(Context.class, new FetchListByEntity()
      .entityType(GameUser.class)
      .from(1)
      .size(3));
```

**4. Fetch list of entities and sort to list of pages**

```java
  List<Page> pages = new QueryExecutor()
      .execute(Context.class, new FetchPagesByEntity()
      .entityType(GameUser.class)
      .from(1)
      .pageCount(2)
      .pageSize(2));

```

**5. Fetch an entity by id**

```java
  GameUser user = new QueryExecutor()
      .execute(Context.class, new FetchById().id(1)
      .entityType(GameUser.class));
```

#Motivation

Read, write, update data from a SQL database always spend a lot of time, and we think using Hibernate is a good choice, but we still need to design our library for easy-to-use purpose 

#Installation

```xml
	<dependency>
		<groupId>com.tvd12</groupId>
		<artifactId>ezyfox-db</artifactId>
		<version>1.0.0</version>
	</dependency>
```

#API Reference

http://www.javadoc.io/doc/com.tvd12/ezyfox-db

#Tests

mvn test

#Contributors

- Project management 
  - [NamCV](mailto:cungvinhnam@gmail.com)
- Project development
 - [DungTV](mailto:dungtv192@gmail.com)
- Project documentation
 - [DungTV](mailto:dungtv192@gmail.com)
 - [DatNT](mailto:dat.fithou@gmail.com)

#License

- Apache License, Version 2.0
	

