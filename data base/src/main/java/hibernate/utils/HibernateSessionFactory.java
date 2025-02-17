package hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {

        private static SessionFactory sessionFactory = buildSessionFactory();

        protected static SessionFactory buildSessionFactory() {
            // SessionFactory создается один раз для приложения
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // настраивает парамаетры из hibernate.cfg.xml
                    .build();
            try {
                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                // so destroy it manually.
                StandardServiceRegistryBuilder.destroy( registry );

                throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
            }
            return sessionFactory;
        }


        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        public static void shutdown() {
            // Close caches and connection pools
            getSessionFactory().close();
        }


}
