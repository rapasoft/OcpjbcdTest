package sk.erni.ejb.html;

import org.jsoup.nodes.Element;

/**
 * @author rap
 */
public class NullElement extends HtmlElement {
	public NullElement(Element element) {
		super(element);
	}

	@Override
    public String getTag() {
        return HtmlConstants.EMPTY.toString();
    }

	@Override
	public String getData() {
		return "N/A";
	}
}
