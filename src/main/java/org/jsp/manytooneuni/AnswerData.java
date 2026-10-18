package org.jsp.manytooneuni;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerData {
	@Override
	public String toString() {
		return "AnswerData [id=" + id + ", question=" + answer + ", questionedBy=" + answeredBy + ", qd=" + qd
				+ "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String answer;
	private String answeredBy;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private QuestionData qd;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String question) {
		this.answer = question;
	}
	public String getAnsweredBy() {
		return answeredBy;
	}
	public void setAnsweredBy(String answeredBy) {
		this.answeredBy = answeredBy;
	}
	public QuestionData getQd() {
		return qd;
	}
	public void setQd(QuestionData qd) {
		this.qd = qd;
	}
}
