package CRUD;

import POJO.*;
import Sandbox.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Select {

    public static void test1(String query1, String query2,String query3,String query4){
        Session session = null;
        Transaction transaction = null;
        List<Empleado> resultadoEmpleado = null;
        List<Departamento> resultadoDepartamento = null;
        List<Proyecto> resultadoProyecto = null;
        List<Trabaja> resultadoTrabaja = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query queryAllEmpl = session.createQuery(query1);
            resultadoEmpleado=queryAllEmpl.list();
            Query queryAllDept = session.createQuery(query2);
            resultadoDepartamento=queryAllDept.list();
            Query queryAllProy= session.createQuery(query3);
            resultadoProyecto=queryAllProy.list();
           // Query queryAllTrab = session.createQuery(query4);
            //resultadoTrabaja = queryAllTrab.list();

            for(Departamento departamento:resultadoDepartamento){
                for (Empleado empleado:resultadoEmpleado){
                    for (Proyecto proyecto:resultadoProyecto){
                        System.out.println("El empleado: " + empleado.getNombre() + " que trabaja en el departamento: " + departamento.getNombre() + " participa en el proyecto: " + proyecto.getNombre());
                    }
                }
            }

        }catch (NullPointerException npe){
            System.out.println(npe.getMessage());
        } finally {
            if (session != null){
                session.close();
            }
        }
        HibernateUtil.shutdown();


    }


    public static List getListOfEmpleadosFromDB(String query){
        Session session = null;
        Transaction transaction;
        List<Empleado> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query queryAllEmp = session.createQuery(query);
            list = queryAllEmp.list();
            if(list.isEmpty()){
                System.out.println("El listado empleados está vacio.");

            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        //HibernateUtil.shutdown();

        return list;
    }
}
