package org.jsp.manytooneuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerDataByQuestionDataId {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		Query q = em.createQuery("select a from AnswerData a where a.qd.id = ?1");
		System.out.println("Enter Question Id : ");
		q.setParameter(1, sc.nextInt());
		@SuppressWarnings("unchecked")
		List<AnswerData> ansl = q.getResultList();
		if(!ansl.isEmpty()) {
			ansl.forEach(System.out::println);
		}
		else {
			System.err.println("No Record Found !!!");
		}
		try {}
		finally {
			sc.close();
		}
	
	
	
	}
}
