package org.jsp.manytooneuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindAnswerDataById {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AnswerData Id : ");
		AnswerData ans = em.find(AnswerData.class, sc.nextInt());
		if(ans!=null) {
			System.out.println(ans);
		}
		else {
			System.err.println("No Record Found!!!");
		}
		try {}
		finally {
			sc.close();
		}
	}
}
