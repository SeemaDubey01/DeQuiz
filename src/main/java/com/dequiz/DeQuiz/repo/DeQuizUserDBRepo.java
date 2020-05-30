package com.dequiz.DeQuiz.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dequiz.DeQuiz.dto.DeQuizUser;

@Repository
public interface DeQuizUserDBRepo extends JpaRepository<DeQuizUser, Integer> {

	//@Query("SELECT dqu_total_marks,dqu_user_name\r\n" + 
	//		"  FROM de_quiz_user where dqu_quiz_id ='101'  order by  dqu_total_marks desc")
	public List<DeQuizUser> findByDquQuizId(@Param("dquUserId") Integer dquUserId);

	@Query("SELECT u FROM DeQuizUser u WHERE u.dquUserId = dquUserId")
	public DeQuizUser findByDquUserId(@Param("dquUserId") Integer dquUserId);
	
	@Query("UPDATE DeQuizUser u SET u.dquMarks = dquMarks, u.dquAnswer= dquAnswer , u.dquTotalMarks= dquTotalMarks where u.dquUserId = dquUserId ")
	@Transactional()
	@Modifying(clearAutomatically = true)
	int updateUser(@Param("dquMarks") Integer dquMarks, @Param("dquAnswer") String dquAnswer,
			@Param("dquTotalMarks") Integer dquTotalMarks, @Param("dquUserId") Integer dquUserId);
	//public DeQuizUser save (DeQuizUser user);
	
	

}
