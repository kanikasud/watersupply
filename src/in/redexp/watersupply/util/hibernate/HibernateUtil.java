package in.redexp.watersupply.util.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
        	 if (sessionFactory == null) {
                 // loads configuration and mappings
                 Configuration configuration = new Configuration().configure();
                /* configuration.addClass(in.redexp.watersupply.model.User.class);
                 configuration.addClass(in.redexp.watersupply.model.UserLocation.class);
                 configuration.addClass(in.redexp.watersupply.model.Scheme.class);
                 configuration.addClass(in.redexp.watersupply.model.District.class); */
                 configuration.addResource("User.hbm.xml");
                 configuration.addResource("Scheme.hbm.xml");
                 configuration.addResource("Division.hbm.xml");
                 configuration.addResource("District.hbm.xml");
                 configuration.addResource("UserLocation.hbm.xml");
                 configuration.addResource("Village.hbm.xml");
                 configuration.addResource("SchemeVillage.hbm.xml");
                 configuration.addResource("SubDivision.hbm.xml");
                 configuration.addResource("VillagePopulation.hbm.xml");
                 configuration.addResource("EstimateDetailsTubeWell.hbm.xml");
                 configuration.addResource("EstimateDetailsCanal.hbm.xml");
                 configuration.addResource("Workflow.hbm.xml");
                 configuration.addResource("EstimateInbox.hbm.xml");
                 ServiceRegistry serviceRegistry
                     = new StandardServiceRegistryBuilder()
                         .applySettings(configuration.getProperties()).build();
                  
                 // builds a session factory from the service registry
                 sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
             }
              
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
		return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}