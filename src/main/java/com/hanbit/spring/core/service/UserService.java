package com.hanbit.spring.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.spring.core.dao.IUserDAO;
import com.hanbit.spring.core.vo.UserVO;

@Service
public class UserService {
	
	//@Autowired
	@Resource(name = "UserSpringDAO")
	private IUserDAO userDAO;
	
	@Autowired
	private SecurityService securityService; 
	
	//회원가입/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String singUpUser(UserVO userVO){
		
		String email = userVO.getUserEmail();
		
		if (userDAO.countEmail(email) > 0) {
			throw new RuntimeException("이미 가입된 이메일입니다.");
		}
		
		String password = userVO.getUserPassword();
		String encryptedPassword = securityService.encryptPassword(password);
		userVO.setUserPassword(encryptedPassword);
		
		int countInsertedUser = userDAO.insertUser(userVO);
		int countInsertedDetail = userDAO.insertUserDetail(userVO);
		
		if (countInsertedUser < 1 || countInsertedDetail < 1) {
			throw new RuntimeException("서버에 오류가 있어 잠시후 시도해주세요.");
		}
		
		return email;
	}

	//회원정보 수정
	public Boolean modifyUser(UserVO userVO){
		
		String userId = userVO.getUserId();
		String currentPassword = userVO.getUserPassword();
		
		String userPassword = userDAO.selectPassword(userId);
		
		if (!securityService.matchPassword(currentPassword, userPassword)) {
			throw new RuntimeException("패스워드가 다릅니다.");
		}
		
		String newPassword = userVO.getNewPassword();
		String encryptedPassword = securityService.encryptPassword(newPassword);
		
		userVO.setUserPassword(encryptedPassword);
		
		int countUpdated = userDAO.updateUser(userVO);
		
		return countUpdated > 0;
	}
	
	//회원정보 삭제-탈퇴
	public boolean removeUser(String userId){
		
		int countDeletedUser = userDAO.deleteUser(userId);
		int countDeletedDetail = userDAO.deleteUserDetail(userId);
		
		return (countDeletedUser > 0 && countDeletedDetail > 0);
	}
	
	//회원 목록
	public List<UserVO> listUsers(){
			userDAO.selectUsers();
		return null;
	}
	
	//회원 정보 상세보기
	public UserVO getUserDetail(String userid){
			
		return userDAO.selectUserDetail(userid);
	}
	
	
	

}
