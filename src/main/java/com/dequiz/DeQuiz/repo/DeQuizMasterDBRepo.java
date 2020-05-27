package com.dequiz.DeQuiz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeQuizMasterDBRepo extends JpaRepository <DeQuizMaster, Integer>{
	
	
	public List<DeQuizMaster> findByDeqmQuizId(Integer deqmQuizId);
	
}
