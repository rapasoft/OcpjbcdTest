package sk.erni.ejb.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import sk.erni.ejb.html.*;
import sk.erni.ejb.logging.Log;

import javax.inject.Inject;
import java.io.IOException;
import java.util.*;
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
        anchors.forEach(el -> results.add(HtmlElementFactory.forTag(htmlConstants, el)));
        return results;
    }

    public Map<String, Set<Anchor>> parseAnchorsGroupByCssClass(Document document) {
        List<Anchor> result = parseAnchors(document);

        Map<String, Set<Anchor>> res1 = new HashMap<>();

        result.stream().collect(Collectors.toMap(Function.<Anchor>identity(), Anchor::getClasses))
                .forEach((anchor, set) -> set.forEach(string ->
                {
                    Set<Anchor> anchors = new HashSet<>();
                    if (res1.putIfAbsent(string, anchors) != null) {
                        anchors = res1.get(string);
                    }
                    anchors.add(anchor);

                }));

        return res1;
    }
}
