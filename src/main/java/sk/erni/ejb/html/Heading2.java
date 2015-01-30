package sk.erni.ejb.html;

import org.jsoup.nodes.Element;
import sk.erni.ejb.parser.HtmlConstants;

/**
 * @author rap
 */
public class Heading2 extends HtmlElement {

	protected Heading2(Element element) {
		super(element);
	}

	@Override
	public HtmlConstants getTag() {
		return HtmlConstants.H2;
	}

	@Override
	public String getData() {
		return element.data();
	}

}
