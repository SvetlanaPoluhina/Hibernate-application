package hibernate.main;

import org.hibernate.Session;
import hibernate.dao.TesterEntity;
import hibernate.utils.HibernateSessionFactory;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        TesterEntity tester = new TesterEntity();

        tester.setNameTester("Petr Petrov");

        session.save(tester);
        session.getTransaction().commit();

        session.close();


    }
}