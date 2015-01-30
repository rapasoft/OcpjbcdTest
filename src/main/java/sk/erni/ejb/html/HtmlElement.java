package sk.erni.ejb.html;

import org.jsoup.nodes.Element;

import java.util.Set;

/**
 * @author rap
 */
public abstract class HtmlElement {

	protected Element element;

	protected HtmlElement(Element element) {
		this.element = element;
	}

    public abstract String getTag();

	public abstract String getData();

	public Set<String> getClasses() {
		return element.classNames();
	}

	public Element getUnderliningElement() {
		return element;
	}

}
