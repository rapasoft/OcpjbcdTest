package sk.erni.ejb;

import org.junit.*;
import sk.erni.ejb.html.Anchor;
import sk.erni.ejb.html.Heading2;
import sk.erni.ejb.service.ParserService;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author rap
 */
public class ParserServiceTest {

	@EJB
	private ParserService parserService;

	private static EJBContainer container;

	@BeforeClass
	public static void initContainer() {
		container = EJBContainer.createEJBContainer();
	}

	@Before
	public void initContext() throws NamingException {
		container.getContext().bind("inject", this);
	}

	@AfterClass
	public static void closeContainer() {
		if (container != null) {
			container.close();
		}
	}

	@Test
	public void testParseAnchors() throws Exception {
		List<Anchor> nodes = parserService.parseAnchors("http://blog.rapasoft.eu/");

		Assert.assertNotNull(nodes);
		Assert.assertTrue(!nodes.isEmpty());
	}

	@Test
	public void testParseHeading1() throws Exception {
		List<Heading2> nodes = parserService.parseHeading2("http://blog.rapasoft.eu/");

		Assert.assertNotNull(nodes);
		Assert.assertTrue(!nodes.isEmpty());
	}

	@Test
	public void testParseAnchorsGroup() throws Exception {
		Map<String, List<Anchor>> nodes = parserService.parseAnchorsGroup("http://blog.rapasoft.eu/");

		Assert.assertNotNull(nodes);
		Assert.assertTrue(!nodes.isEmpty());
	}

}
