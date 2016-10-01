package com.hanbit.spring.core.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hanbit.spring.core.vo.UserVO;

public class UserMybatisDAO implements IUserDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertUser(UserVO userVO) {

		//sqlSession.insert("user.insertUser", userVO);
	
		return sqlSession.insert("user.insertUser", userVO);
	}

	@Override
	public int insertUserDetail(UserVO userVO) {
		return sqlSession.insert("user.insertUserDetail", userVO);
	}

	@Override
	public int countEmail(String email) {
	
		return 	sqlSession.selectOne("user.countEmail", email);
	}

	@Override
	public int updateUser(UserVO userVO) {
		
		return sqlSession.update("user.updateUser", userVO);
	}

	@Override
	public String selectPassword(String userId) {
		// TODO Auto-generated method stub
		return  sqlSession.selectOne("user.selectPassword", userId);
	}

	@Override
	public int deleteUser(String userId) {
		// TODO Auto-generated method stub
		return  sqlSession.delete("user.deleteUser", userId);
	}

	@Override
	public int deleteUserDetail(String userId) {
		
		return sqlSession.delete("user.deleteUserDetail", userId);
	}

	@Override
	public List<UserVO> selectUsers() {
	//	sqlSession.selectList("user.selectUsers");
		return sqlSession.selectList("user.selectUsers");
	}

	@Override
	public UserVO selectUserDetail(String userId) {
	//	sqlSession.selectOne("user.selectUserDetail",userId);
		return sqlSession.selectOne("user.selectUserDetail",userId);
	}

}
