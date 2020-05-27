package com.dequiz.DeQuiz;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeQuizUserDBRepo extends JpaRepository<DeQuizUser, Integer> {

	@Query("SELECT u FROM DeQuizUser u WHERE u.dquUserId = dquUserId")
	public DeQuizUser find(@Param("dquUserId") Integer dquUserId);

	@Query("UPDATE DeQuizUser u SET u.dquMarks = dquMarks, u.dquAnswer= dquAnswer , u.dquTotalMarks= dquTotalMarks where u.dquUserId = dquUserId ")
	@Transactional()
	@Modifying(clearAutomatically = true)
	int updateUser(@Param("dquMarks") Integer dquMarks, @Param("dquAnswer") String dquAnswer,
			@Param("dquTotalMarks") Integer dquTotalMarks, @Param("dquUserId") Integer dquUserId);

}
