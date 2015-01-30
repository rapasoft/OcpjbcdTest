package sk.erni.ejb.service;


import org.jsoup.nodes.Document;
import sk.erni.ejb.html.Anchor;
import sk.erni.ejb.html.Heading2;
import sk.erni.ejb.logging.Log;
import sk.erni.ejb.parser.DomParser;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author rap
 */
@Stateless
public class ParserService {

	@Inject
	private DomParser domParser;

	@Inject
	@Log(forClass = ParserService.class)
	private Logger logger;

	public List<Anchor> parseAnchors(String url) {
		Document document = domParser.readDocument(url);
		return domParser.parseAnchors(document);
	}

	public Map<String, List<Anchor>> parseAnchorsGroup(String url) {
		Document document = domParser.readDocument(url);
		return domParser.parseAnchorsGroup(document);
	}

	public List<Heading2> parseHeading2(String url) {
		Document document = domParser.readDocument(url);
		return domParser.parseHeading2(document);
	}

}
