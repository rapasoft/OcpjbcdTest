package sk.erni.ejb.html;

import org.jsoup.nodes.Element;

/**
 * @author rap
 */
public class HtmlElementFactory {

	public static HtmlElement forTag(HtmlConstants tag, Element element) {
		switch (tag) {
			case A: return new Anchor(element);
			case H2: return new Heading2(element);
			default: return new NullElement(element);
		}
	}

}
