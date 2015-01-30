package sk.erni.ejb.html;

import org.jsoup.nodes.Element;
import sk.erni.ejb.parser.HtmlConstants;

/**
 * @author rap
 */
public class NullElement extends HtmlElement {
	public NullElement(Element element) {
		super(element);
	}

	@Override
	public HtmlConstants getTag() {
		return HtmlConstants.EMPTY;
	}

	@Override
	public String getData() {
		return "N/A";
	}
}
