package com.dequiz.DeQuiz.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dequiz.DeQuiz.dto.DeQuizMaster;

public interface DeQuizMasterDBRepo extends JpaRepository <DeQuizMaster, Integer>{
	
	@Transactional
	public List<DeQuizMaster> findByDeqmQuizId(Integer deqmQuizId);
//	public List<DeQuizMaster> findByDeqmQuizIdAndUsersDquUserName(Integer deqmQuizId, String dquUserName);
	
}
