package com.dequiz.DeQuiz.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dequiz.DeQuiz.DTO.DeQuizLogin;
import com.dequiz.DeQuiz.DTO.DeQuizMaster;
import com.dequiz.DeQuiz.Repo.DeQuizLoginDBRepo;
import com.dequiz.DeQuiz.Repo.DeQuizMasterDBRepo;
import com.dequiz.DeQuiz.Repo.DeQuizUserDBRepo;

@Service
public class DeQuizDBService {

	@Autowired
	DeQuizLoginDBRepo deQuizLoginDBRepo;
	
	@Autowired
	DeQuizUserDBRepo deQuizUserDBRepo;
	
	@Autowired
	DeQuizMasterDBRepo deQuizMasterDBRepo;
	
	public DeQuizLogin getAdmin(String userId){
		Optional<DeQuizLogin> deQuizLoginMap =deQuizLoginDBRepo.findById(userId);
		DeQuizLogin deQuizLogin = new DeQuizLogin();
		deQuizLogin.setDqlUserId(" ");
		deQuizLogin.setDqlPassword(" ");
		if(deQuizLoginMap.isPresent()) {
			deQuizLogin = deQuizLoginMap.get();
System.out.println("debug: getAdmin for " + deQuizLogin.getDqlUserId());
		}
		return deQuizLogin;
	}
	
	public List<DeQuizMaster> getExistingQuizes(String userId){
		List<DeQuizMaster> qMlist = deQuizMasterDBRepo.findByDqlUserId(userId);
		return qMlist;
	}

	public void saveLogin(DeQuizLogin deQuizLogin) {
		if (deQuizLogin != null) {
			deQuizLoginDBRepo.save(deQuizLogin);
		}
	}

	public List<DeQuizMaster> findByDeqmQuizId(Integer deqmQuizId) {
		return deQuizMasterDBRepo.findByDeqmQuizId(deqmQuizId);
	}

	public void saveMaster(DeQuizMaster deQuizMaster) {
		if (deQuizMaster != null) {
			deQuizMasterDBRepo.save(deQuizMaster);
		}
	}

	public void deleteByDeqmQuizId(Integer deqmQuizId) {
		deQuizMasterDBRepo.deleteByDeqmQuizId(deqmQuizId);
	}

	public void deleteByDquQuizId(Integer dquQuizId) {
		deQuizUserDBRepo.deleteByDquQuizId(dquQuizId);
	}

	public Optional<DeQuizMaster> findByMasterId(Integer deqmQuizId) {
		return deQuizMasterDBRepo.findById(deqmQuizId);
	}

}
