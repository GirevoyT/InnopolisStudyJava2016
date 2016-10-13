package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica.Logica;
import ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.logica.MyTaskIntegerLogica;

/**
 * Created by Arxan on 13.10.2016.
 */
public class DeepThroughtTest {
	private static Logger logger = LoggerFactory.getLogger(DeepThroughtTest.class);
	private DeepThought deepThought;
	private Mockery context;

	@BeforeClass
	public static void beforeTest() {
		logger.info("This is @BeforeClass method");
	}
	@Before
	public void before() {
		logger.info("This is @Before method");
		ThreadGroup threadGroup= new ThreadGroup("testGroup");
		Object testObject = new Object();
		Logica logica = context.mock(MyTaskIntegerLogica.class);
		context.checking(new Expectations(){{
			oneOf(logica).logica(testObject);
			will()
		}});
		this.deepThought = new DeepThought();
		this.context = new JUnit4Mockery();
	}
//	@Test
//	public void testHandle() {
//		logger.info("This is @Test method testSum");
//		final StreamWriter streamWriter = context.mock(StreamWriter.class);
//
//		context.checking(new Expectations() {{
//			oneOf(streamWriter).write("SomeText");
//			will(returnValue(new Long(5)));
//		}});
//		testjMock.setStreamWriter(streamWriter);
//		assertEquals(new Long(5),testjMock.handle("SomeText"));
//	}
	@After
	public void after() {
		logger.info("This is @Arter method");
	}
	@AfterClass
	public static void afterClass() {
		logger.info("This is @ArterClass method");
	}

}
