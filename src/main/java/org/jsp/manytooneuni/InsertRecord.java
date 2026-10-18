package org.jsp.manytooneuni;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etran = em.getTransaction();
		etran.begin();
		
		QuestionData q = new QuestionData();
		q.setQuestion("What is most important thing in your life ?");
		q.setQuestionedBy("Mayank Tripathi Sir");
		
		AnswerData a = new AnswerData();
		a.setAnswer("Money");
		a.setAnsweredBy("Aditya");
		a.setQd(q);
		
		AnswerData a1 = new AnswerData();
		a1.setAnswer("Peace");
		a1.setAnsweredBy("Sakshi");
		a1.setQd(q);
		
		AnswerData a2 = new AnswerData();
		a2.setAnswer("Power");
		a2.setAnsweredBy("Pratyush");
		a2.setQd(q);
		
		AnswerData a3 = new AnswerData();
		a3.setAnswer("Friends");
		a3.setAnsweredBy("Rona");
		a3.setQd(q);
		
		AnswerData a4 = new AnswerData();
		a4.setAnswer("Job");
		a4.setAnsweredBy("Aishwarya");
		a4.setQd(q);
		
		AnswerData a5 = new AnswerData();
		a5.setAnswer("Bikes");
		a5.setAnsweredBy("Mayank Soni");
		a5.setQd(q);
		
		AnswerData a6 = new AnswerData();
		a6.setAnswer("Behaviuor");
		a6.setAnsweredBy("Mayank Verma");
		a6.setQd(q);
		
		AnswerData a7 = new AnswerData();
		a7.setAnswer("Self Respect");
		a7.setAnsweredBy("Mohit Saini");
		a7.setQd(q);
		
		List<AnswerData> ansl = Arrays.asList(a,a1,a2,a3,a4,a5,a6,a7);
		for(AnswerData ans : ansl){
			em.persist(ans);
		}
		etran.commit();
	}
}
