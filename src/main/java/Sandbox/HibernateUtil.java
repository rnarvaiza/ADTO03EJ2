package Sandbox;

import POJO.Departamento;
import POJO.Empleado;
import POJO.Proyecto;
import POJO.Trabaja;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Crear registro
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

                // Crear MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                sources.addAnnotatedClass(Empleado.class);
                sources.addAnnotatedClass(Departamento.class);
                sources.addAnnotatedClass(Proyecto.class);
                sources.addAnnotatedClass(Trabaja.class);

                // Crear Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Crear SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);

        }
    }
}

