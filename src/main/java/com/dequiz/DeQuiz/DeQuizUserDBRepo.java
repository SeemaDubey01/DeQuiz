package com.dequiz.DeQuiz;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DeQuizUserDBRepo extends JpaRepository <DeQuizUser, Integer>{
	
	
   
}
