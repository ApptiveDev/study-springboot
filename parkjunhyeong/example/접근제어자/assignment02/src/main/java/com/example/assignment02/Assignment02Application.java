package com.example.assignment02;

//import com.example.assignment02.main.Neighbor;
import com.example.assignment02.main.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment02Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment02Application.class, args);
		Person cho = new Person("cho",23,"Sejong city","01012345678");
		// public 멤버에 대한 접근
		System.out.println("Name: " + cho.name); // 가능

		// protected 멤버에 대한 접근
		//System.out.println("Age: " + cho.age); // 오류! Main 클래스에서는 접근 불가

		// private 멤버에 대한 접근
		// System.out.println("Address: " + person.address); // 오류! 직접 접근 불가
		System.out.println("Address: " + cho.getAddress()); // 가능 (접근자 메서드 사용)

		// 패키지 레벨 멤버에 대한 접근
		//System.out.println("Phone: " + cho.phoneNumber); // 오류! 같은 패키지 내에서만 접근 가능

		// 같은 패키지 내의 다른 클래스에서의 접근
//		Neighbor neighbor = new Neighbor();
//		neighbor.printInfo(cho);

		// 다른 패키지 내의 클래스에서의 접근
		com.example.assignment02.another.Stranger stranger = new com.example.assignment02.another.Stranger();
		stranger.printInfo(cho);


	}
}
