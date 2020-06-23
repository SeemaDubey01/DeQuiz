package com.dequiz.DeQuiz.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dequiz.DeQuiz.dto.DeQuizMaster;
@Repository
public interface DeQuizMasterDBRepo extends JpaRepository <DeQuizMaster, Integer>{
	
//	@Transactional
	public List<DeQuizMaster> findByDeqmQuizId(Integer deqmQuizId);
//	public List<DeQuizMaster> findByDeqmQuizIdAndUsersDquUserName(Integer deqmQuizId, String dquUserName);
	
	public List<DeQuizMaster> findByDqlUserId(String dqlUserId); 
	
}
