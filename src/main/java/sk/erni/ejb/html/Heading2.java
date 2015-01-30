package sk.erni.ejb.html;

import org.jsoup.nodes.Element;

/**
 * @author rap
 */
public class Heading2 extends HtmlElement {

	protected Heading2(Element element) {
		super(element);
	}

	@Override
    public String getTag() {
        return HtmlConstants.H2.toString();
    }

	@Override
	public String getData() {
		return element.data();
	}

}
