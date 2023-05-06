package com.learning.employee;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class EmployeeSystemApiApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	//Just for learning
//	@Test
//	void testAssumeTrue() {
//		System.setProperty("env","prod");
//		assumingThat("test".equals(System.getProperty("env")),
//			()->{
//				assertEquals(1, 1);
//				System.out.println("Perform above assertion only on the test environment");
//			});
//		
//		assumingThat("prod".equals(System.getProperty("env")),
//				()->{
//					assertEquals(1, 1);
//					System.out.println("Perform above assertion only on the prod environment");
//				});
//		assertEquals(2, 2);
//		System.out.println("Perform above assertion on all environments");
//	}
	
//	@Nested
//	class InnerClass {
//		@Test
//		void testMethod() {
//			System.out.println("Inner class test method");
//		}
//		
//		@Nested
//		class InnerMostClass {
//			@BeforeEach
//			void beforeEach() {
//				System.out.println("in beforeEach");
//			}
//			@Test
//			void testMethod2() {
//				System.out.println("in test method 2");
//			}
//		}
//	}
	
	@Test
	void testThrows() {
		Throwable ex = assertThrows(IllegalArgumentException.class, 
				() -> {
					throw new IllegalArgumentException("IllegalArgument Exception occured");
				});
		assertEquals("IllegalArgument Exception occured", ex.getMessage());
	}
}

