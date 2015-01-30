package sk.erni.ejb;

import org.junit.*;
import sk.erni.ejb.html.Anchor;
import sk.erni.ejb.html.Heading2;
import sk.erni.ejb.html.HtmlElement;
import sk.erni.ejb.service.ParserService;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author rap
 */
public class ParserServiceTest {

    private static EJBContainer container;
    @EJB
    private ParserService parserService;

    @BeforeClass
    public static void initContainer() {
        container = EJBContainer.createEJBContainer();
    }

    @AfterClass
    public static void closeContainer() {
        if (container != null) {
            container.close();
        }
    }

    @Before
    public void initContext() throws NamingException {
        container.getContext().bind("inject", this);
    }

    @Test
    public void testParseAnchors() throws Exception {
        List<Anchor> nodes = parserService.parseAnchors("http://blog.rapasoft.eu/");

        Assert.assertNotNull(nodes);
        Assert.assertTrue(!nodes.isEmpty());
        Assert.assertTrue(contains(nodes));
    }

    private boolean contains(Collection<? extends HtmlElement> nodes) {
        return nodes.stream().anyMatch(anchor -> anchor.getUnderliningElement().nodeName().equalsIgnoreCase(anchor.getTag()));
    }

    @Test
    public void testParseHeading2() throws Exception {
        List<Heading2> nodes = parserService.parseHeading2("http://blog.rapasoft.eu/");

        Assert.assertNotNull(nodes);
        Assert.assertTrue(!nodes.isEmpty());
        Assert.assertTrue(contains(nodes));
    }

    @Test
    public void testParseAnchorsGroup() throws Exception {
        Map<String, Set<Anchor>> nodes = parserService.parseAnchorsGroupByCssClass("http://blog.rapasoft.eu/");

        Assert.assertNotNull(nodes);
        Assert.assertTrue(!nodes.isEmpty());
        nodes.values().forEach(anchors -> Assert.assertTrue(contains(anchors)));
    }

}
