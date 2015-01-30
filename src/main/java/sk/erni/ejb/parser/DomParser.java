package sk.erni.ejb.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import sk.erni.ejb.html.Anchor;
import sk.erni.ejb.html.Heading2;
import sk.erni.ejb.html.HtmlElement;
import sk.erni.ejb.html.HtmlElementFactory;
import sk.erni.ejb.logging.Log;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author rap
 */
public class DomParser {

	@Inject
	@Log(forClass = DomParser.class)
	private Logger logger;

	public Document readDocument(String url) {
		try {
			return Jsoup.connect(url).get();
		} catch (IOException e) {
			logger.severe("Could not parser URL: " + url + ", cause: \n" + e);
		}

		return Document.createShell("empty");
	}

	@SuppressWarnings("unchecked")
	public List<Anchor> parseAnchors(Document document) {
		return (List<Anchor>) parse(document, HtmlConstants.A);
	}

	@SuppressWarnings("unchecked")
	public List<Heading2> parseHeading2(Document document) {
		return (List<Heading2>) parse(document, HtmlConstants.H2);
	}

	private List<? extends HtmlElement> parse(Document document, HtmlConstants htmlConstants) {
		Elements anchors = document.select(htmlConstants.name());

		List<HtmlElement> results = new ArrayList<>();
		anchors.forEach(el -> {
			results.add(HtmlElementFactory.forTag(htmlConstants,el));
			logger.info(el.toString());
		});
		return results;
	}

	public Map<String, List<Anchor>> parseAnchorsGroup(Document document) {
		List<Anchor> result = parseAnchors(document);

		Set<String> classes = result.stream().flatMap(anchor -> anchor.getClasses().stream()).collect(Collectors.toSet());

		String s =
				result
						.stream().flatMap(anchor -> anchor.getClasses().stream()).collect(Collectors.toList()).toString();
		return null;
	}
}
