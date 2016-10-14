package ru.innopolis.course.java2016.girevoy.home.homeworks.lab1.devourers;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by masterlomaster on 14.10.16.
 */
public class DevourerTest {
	private static Logger logger = LoggerFactory.getLogger(DevourerTest.class);
	private Synchroniser synchroniser = new Synchroniser();
	private Mockery context;

	@BeforeClass
	public static void beforeTest() {
		logger.info("This is @BeforeClass method");
	}
	@Before
	public void before() {
		logger.info("This is @Before method");
		this.context = new JUnit4Mockery() {{
			this.setImposteriser(ClassImposteriser.INSTANCE);
			this.setThreadingPolicy(synchroniser);
		}};;

	}
//	@Test
//	public void testDevourer() {
//		logger.info("This is @Test method testDevourer");
//		ThreadGroup threadGroup= new ThreadGroup("testGroup");
//		Object testObject = new Object();
//		Resource resource = context.mock(Resource.class);
//
//		final States progress = context.states("progress").startsAs("none");
//		context.checking(new Expectations(){{
//			oneOf(logica).logica(testObject);
//			will(new CheckLogicaAction(testObject));
//			then(progress.is("done"));
//		}});
//		DeepThought deepThought = new DeepThought(logica, threadGroup);
//		try {
//			deepThought.addData(testObject);
//			deepThought.start();
//			synchroniser.waitUntil(progress.is("done"), TimeUnit.SECONDS.toMillis(1));
//			threadGroup.interrupt();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		assertTrue("Deepthroug не выполнил логику, или передал не тот объект",((CheckBox)testObject).isFlag());
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
