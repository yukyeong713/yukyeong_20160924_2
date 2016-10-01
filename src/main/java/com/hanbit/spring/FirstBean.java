//package com.hanbit.spring;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
////pojo 상속받지 않는 순수 자바
//
////@Scope("prototype")//@Scope("prototype") 가져올 때 새로 생성
//@Component
//public class FirstBean {
//	
//	@Autowired
//	private secondBean secondBean; //의존성을 위해서
//	private int value;
//	
//	
////	//@Autowired 스프링 컨테이너 알아서 이 타입에 맞는 bean을 주입시켜준다.
////	@Autowired
////	public void setSecondBean (secondBean secondBean){
////		this.secondBean = secondBean;
////	}
//
//	
//	public void callSecond(){
//		System.out.println(value ++ );
//		secondBean.printName();
//	}
//	public int getValue(){
//		return value++;
//	}
//	
//	
//	
//	
//	
//	
//}
