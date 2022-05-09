package com.paf.exercise.exercise;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ExerciseApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	public void testContextLoaded() {
		Assert.assertNotNull(context);
	}

}
