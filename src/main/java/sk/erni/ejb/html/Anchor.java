package sk.erni.ejb.html;

import org.jsoup.nodes.Element;
import sk.erni.ejb.parser.HtmlConstants;

/**
 * @author rap
 */
public class Anchor extends HtmlElement {

	private static final String HREF = "href";

	protected Anchor(Element element) {
		super(element);
	}

	@Override
	public HtmlConstants getTag() {
		return HtmlConstants.A;
	}

	@Override
	public String getData() {
		return getUnderliningElement().attr(HREF);
	}

}
