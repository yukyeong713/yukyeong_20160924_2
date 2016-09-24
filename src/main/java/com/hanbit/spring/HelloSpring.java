package com.hanbit.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HelloSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//스프링은 스스로 의존성 설정을 함...?
		//컨테이너를 만드는 부분
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-core.xml");
//		
//		//기존 방식의 bean 선언 매번 새로 생성되기 때문에 찍어보면 증가하지 않고 기본값이 나온다.
//		//프로트 스콥?
//		FirstBean oldBean = new FirstBean();
//		FirstBean oldBean2= new FirstBean();
//		
//		System.out.println(oldBean.getValue()); // -> 0
//		System.out.println(oldBean2.getValue()); // -> 0 
//		
//		
//		//스프링 컨테이너 안에 있는 bean을 가져옴 
//		//한번 만들어 놓은 것을 계속 사용함.
//		//리퀘스트 스콥 ? web에서,,> 
//		FirstBean springbean = applicationContext.getBean(FirstBean.class);
//		FirstBean springbean2 = applicationContext.getBean(FirstBean.class);
//		
//		//한번 생성을 했기 때문에 다시 불러오면 증가한 값이 들어 온다.
//		System.out.println(springbean.getValue()); // -> 0
//		System.out.println(springbean2.getValue()); // -> 1
//		
		
		
		
		FirstBean springbean = applicationContext.getBean(FirstBean.class);
		springbean.callSecond();
		
		
		FirstBean springbean2 = applicationContext.getBean(FirstBean.class);
		springbean2.callSecond();
	}

}
