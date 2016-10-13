package ru.innopolis.course.java2016.girevoy.lessons.lesson9.testjMock;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.course.java2016.girevoy.lessons.lesson9.testjMock.streams.StreamWriter;
import ru.innopolis.course.java2016.girevoy.lessons.lesson9.testjMock.streams.WSStreamWriter;

import static org.junit.Assert.assertEquals;

/**
 * Created by masterlomaster on 13.10.16.
 */
public class TestjMockTest {
	private static Logger logger = LoggerFactory.getLogger(TestjMockTest.class);
	private TestjMock testjMock;


	@BeforeClass
	public static void beforeTest() {
		logger.info("This is @BeforeClass method");
	}
	@Before
	public void before() {
		logger.info("This is @Before method");
		this.testjMock = new TestjMock();
	}
	@Test
	public void testSum() {
		logger.info("This is @Test method testSum");
		StreamWriter sw = new WSStreamWriter() {
			@Override
			public Long write(String obj) {
				return new Long(5);
			}
		};
		testjMock.setStreamWriter(sw);
		assertEquals(new Long(5),testjMock.handle("SomeText"));
	}
	@After
	public void after() {
		logger.info("This is @Arter method");
	}
	@AfterClass
	public static void afterClass() {
		logger.info("This is @ArterClass method");
	}

}
