package dao;

import entity.Student;
import jakarta.persistence.*;

public class Dao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("inClass_pu");

    public Student findStudent(String email) {
        EntityManager em = emf.createEntityManager();
        Student student = null;
        try {
            TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.email = :email", Student.class);
            query.setParameter("email", email);
            student = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("No student found with email: " + email);
        } finally {
            em.close();
        }
        return student;
    }

    public void addStudent(Object student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(student);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void updateStudent(String email, Object student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Student existingStudent = findStudent(email);
            if (existingStudent != null) {
                em.merge(student);
            } else {
                System.out.println("No student found with email: " + email);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
