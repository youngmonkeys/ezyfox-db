/**
 * 
 */
package com.tvd12.ezyfox.db;

import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.tvd12.properties.file.exception.PropertiesFileException;
import com.tvd12.properties.file.reader.BaseFileReader;

/**
 * Support to create an SessionFactory object, map its to a context and provide its
 * 
 * @author tavandung12
 *
 */
public class SessionFactoryProvider {

    // map of context and SessionFactory object
    private ConcurrentHashMap<Class<?>, SessionFactory> 
            sessionFactories = new ConcurrentHashMap<>();
    
    // Singleton instance
    private static final SessionFactoryProvider INSTANCE 
            = new SessionFactoryProvider();
    
    /**
     *  prevent new instance
     */
    private SessionFactoryProvider() {}
    
    /**
     * Get singleton instance
     * 
     * @return singleton instance
     */
    public static SessionFactoryProvider getInstance() {
        return INSTANCE;
    }
    
    /**
     * Create a ConfigurationLoader object
     * 
     * @return a ConfigurationLoader object
     */
    public ConfigurationLoader loader() {
        return new ConfigurationLoader(this);
    }
    
    /**
     * Provide the SessionFactory object mapped to the context class
     * 
     * @param context the context class
     * @return the SessionFactory object
     */
    public SessionFactory provide(Class<?> context) {
        return sessionFactories.get(context);
    }
    
    /**
     * Support to load the Hibernate configuration
     * 
     * @author tavandung12
     *
     */
    public static class ConfigurationLoader {
        
        // Context class
        private Class<?> context = getClass();
        
        // Configuration object
        private Configuration configuration
                = new Configuration();
        
        // Parent
        private SessionFactoryProvider provider;
        
        /**
         * Construct with parent
         * 
         * @param provider parent
         */
        public ConfigurationLoader(SessionFactoryProvider provider) {
            this.provider = provider;
        }
        
        /**
         * Set context class
         * 
         * @param clazz the context class
         * @return this pointer
         */
        public ConfigurationLoader context(Class<?> clazz) {
            this.context = clazz;
            return this;
        }
        
        /**
         * Set a property (name-value pair) to the configuration object
         * 
         * @param name name
         * @param value value
         * @return this pointer
         */
        public ConfigurationLoader setProperty(String name, String value) {
            configuration.setProperty(name, value);
            return this;
        }
        
        /**
         * Read the properties file and set all properties to the configuration object
         * 
         * @param propertiesFile the properties file
         * @return this pointer
         */
        public ConfigurationLoader setProperties(String propertiesFile) {
            return setProperties(readPropertiesFile(context, propertiesFile));
        }
        
        /**
         * Set all properties to the configuration object
         * 
         * @param properties the properties
         * @return this pointer
         */
        public ConfigurationLoader setProperties(Properties properties) {
            configuration.setProperties(properties);
            return this;
        }
        
        /**
         * Add a persistent class to the configuration object 
         * 
         * @param clazz a persistent class
         * @return this pointer
         */
        public ConfigurationLoader addAnnotatedClass(Class<?> clazz) {
            return addAnnotatedClasses(clazz);
        }
        
        /**
         * Add a collection of persistent classes to configuration object
         * 
         * @param classes the collection of persistent classes
         * @return this pointer
         */
        public ConfigurationLoader addAnnotatedClasses(Collection<Class<?>> classes) {
            return addAnnotatedClasses(classes.toArray(new Class[classes.size()]));
        }
        
        /**
         * Add a array of persistent classes to configuration object
         * 
         * @param classes the array of persistent classes 
         * @return this pointer
         */
        public ConfigurationLoader addAnnotatedClasses(Class<?>... classes) {
            for(Class<?> clazz : classes) {
                configuration.addAnnotatedClass(clazz);
            }
            return this;
        }
        
        /**
         * Load the configuration and create the SessionFactory object and map to the context class
         * 
         * @return the SessionFactory object
         */
        public SessionFactory load() {
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()); 
            SessionFactory sessionFactory = configuration
                    .buildSessionFactory(builder.build());
            provider.sessionFactories.putIfAbsent(context, sessionFactory);
            return provider.sessionFactories.get(context);
        }
        
        /**
         * Read the properties file
         * 
         * @param context the context class
         * @param file the properties file path
         * @return the properties object
         */
        private Properties readPropertiesFile(Class<?> context, String file) {
            try {
                return new BaseFileReader().read(getClass(), file);
            } catch (PropertiesFileException e) {
                throw new IllegalStateException(e);
            }
        }
    }
    
}
