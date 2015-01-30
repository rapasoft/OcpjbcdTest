package sk.erni.ejb.html;

import org.jsoup.nodes.Element;
import sk.erni.ejb.parser.HtmlConstants;

import java.util.Set;

/**
 * @author rap
 */
public abstract class HtmlElement {

	protected Element element;

	protected HtmlElement(Element element) {
		this.element = element;
	}

	public abstract HtmlConstants getTag();

	public abstract String getData();

	public Set<String> getClasses() {
		return element.classNames();
	}

	public Element getUnderliningElement() {
		return element;
	}

}
