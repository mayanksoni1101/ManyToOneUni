# Question & Answer Management System (JPA / Hibernate Many-to-One Unidirectional)

A Java application demonstrating **Many-to-One Unidirectional Mapping** between `AnswerData` and `QuestionData` entities using **JPA (Java Persistence API)** and **Hibernate ORM**.

## 📌 Project Overview

In this Many-to-One unidirectional design:

* **`AnswerData` Entity (Child / Owning Side):** Holds a foreign key reference (`@ManyToOne`) pointing to a single `QuestionData` instance. Cascading options (`CascadeType.ALL`) enable implicit operations on parent entities.
* **`QuestionData` Entity (Parent):** Standalone entity containing details about the question and who asked it, with no inverse navigation link back to the collection of answers.

This architecture models scenarios where multiple distinct user responses/answers map back to a single shared question.

## 🛠️ Tech Stack & Prerequisites

* **Language:** Java (JDK 8+)
* **Framework:** JPA 2.0+ / Hibernate ORM
* **Query Language:** JPQL (Java Persistence Query Language)
* **Persistence Management:** `EntityManager`, `EntityManagerFactory`, `EntityTransaction`
* **Database:** MySQL / PostgreSQL / Oracle (or any standard RDBMS)

## 📂 Repository File Structure

```
src/
└── org/jsp/manytooneuni/
    ├── Entities:
    │   ├── QuestionData.java                    # Parent Entity (Question details)
    │   └── AnswerData.java                      # Child Entity (Answer details & @ManyToOne mapping)
    │
    ├── Data Population:
    │   └── InsertRecord.java                    # Class to seed sample questions and answers
    │
    ├── Answer Lookups & Queries:
    │   ├── FindAnswerDataById.java             # Fetch Answer by Primary Key ID
    │   ├── FindAnswerDataByAnswer.java           # Fetch Answer(s) by answer text
    │   ├── FindAnswerDataByquestion.java         # Fetch Answer(s) by target Question text
    │   ├── FindAnswerDataByQuestionDataId.java   # Fetch Answer(s) by target Question ID
    │   └── FindAnswerDataByquestionedBy.java     # Fetch Answer(s) by Questioner's Name
    │
    └── Question Lookups & Queries:
        ├── FindQuestionDataById.java           # Fetch Question by Primary Key ID
        ├── FindQuestionDataByquestion.java       # Fetch Question by question text
        ├── FindQuestionDataByQuestionedBy.java   # Fetch Question by Questioner's Name
        └── FindQuestionDataByAnswerDataId.java   # Traverses relationship from Answer ID to parent Question
```

## ⚙️ JPA Configuration (`persistence.xml`)

Ensure your `src/META-INF/persistence.xml` contains the persistence unit `"M15"`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
                                 http://xmlns.jcp.org/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">

    <persistence-unit name="M15">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        
        <!-- Entity Classes -->
        <class>org.jsp.manytooneuni.QuestionData</class>
        <class>org.jsp.manytooneuni.AnswerData</class>

        <properties>
            <!-- Database Connection Settings -->
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/your_database" />
            <property name="javax.persistence.jdbc.user" value="your_username" />
            <property name="javax.persistence.jdbc.password" value="your_password" />

            <!-- Hibernate Dialect & Logging Settings -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
        </properties>
    </persistence-unit>
</persistence>
```

## 📊 Database Schema Summary

### `QuestionData` Table (Parent)

| Column Name | Data Type | Key Type | Description |
| :--- | :--- | :--- | :--- |
| `id` | `INT` | Primary Key (`AUTO_INCREMENT`) | Unique question identifier |
| `question` | `VARCHAR` | Standard | Text content of the question |
| `questionedBy` | `VARCHAR` | Standard | Author/User who asked the question |

### `AnswerData` Table (Child)

| Column Name | Data Type | Key Type | Description |
| :--- | :--- | :--- | :--- |
| `id` | `INT` | Primary Key (`AUTO_INCREMENT`) | Unique answer identifier |
| `answer` | `VARCHAR` | Standard | Text content of the answer |
| `answeredBy` | `VARCHAR` | Standard | Author/User who provided the answer |
| `qd_id` | `INT` | Foreign Key (`QuestionData(id)`) | References parent question |

## 🚀 Getting Started & Execution Order

1. **Database Setup:** Verify that your target relational database is operational and that `persistence.xml` reflects your local database credentials.
2. **Seed Data:** Run `org.jsp.manytooneuni.InsertRecord` to create and populate sample `QuestionData` and associated `AnswerData` rows via JPA persistence context.
3. **Run Search Utilities:** Execute any of the lookup classes (`FindQuestionDataByquestion`, `FindAnswerDataByQuestionDataId`, `FindQuestionDataByAnswerDataId`, etc.) to perform interactive console queries using JPQL and primary key lookups.
