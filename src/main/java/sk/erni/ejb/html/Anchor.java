package sk.erni.ejb.html;

import org.jsoup.nodes.Element;

/**
 * @author rap
 */
public class Anchor extends HtmlElement {

	private static final String HREF = "href";

	protected Anchor(Element element) {
		super(element);
	}

	@Override
    public String getTag() {
        return HtmlConstants.A.toString();
    }

	@Override
	public String getData() {
		return getUnderliningElement().attr(HREF);
	}

    @Override
    public String toString() {
        return getData();
    }
}
