package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import javax.security.auth.login.Configuration;

public class HibernateUtil {

        private static final SessionFactory sessionFactory;
        static {
            try {
// Crée la SessionFactory âpartir du fichier de configuration standard (hibernate.cfg.xml)
                sessionFactory = new
                        Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
// Log l'exception pour le débogage

                System.err.println("Échec de la création de SessionFactory."
                        + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
}
