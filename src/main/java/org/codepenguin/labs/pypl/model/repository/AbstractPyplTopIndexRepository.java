package org.codepenguin.labs.pypl.model.repository;

import org.codepenguin.labs.pypl.model.exception.PyplTopIndexException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

abstract class AbstractPyplTopIndexRepository<T> implements PyplTopIndexRepository<T> {

    private final String url;

    AbstractPyplTopIndexRepository(final String url) {
        this.url = url;
    }

    @Override
    public List<T> getCurrentIndices() throws PyplTopIndexException {
        final Document document;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new PyplTopIndexException(e);
        }

        final var scriptNode = getScriptNode(document);
        if (scriptNode.isEmpty()) {
            throw new PyplTopIndexException("Empty Script Node");
        }

        final var scriptHtml = scriptNode.get().outerHtml();
        final var lines = Arrays.asList(scriptHtml.split("\\n"));
        final var startIndex = getStartIndex(lines);
        final var endIndex = getEndIndex(lines);
        final var tableTags = lines.subList(startIndex + 1, endIndex);

        final var indices = new ArrayList<T>();
        for (var tableTag : tableTags) {
            final var fragment = Jsoup.parseBodyFragment(tableTag);
            final var values = new ArrayList<>(getFragmentChildNodes(fragment).stream()
                    .map(node -> node.outerHtml().trim())
                    .toList());
            values.removeIf(this::removeFromValues);

            indices.add(buildIndex(values));
        }

        return indices;
    }

    protected Optional<Node> getScriptNode(final Document document) {
        return Optional.ofNullable(document.childNode(2).childNode(1).childNode(41).firstChild());
    }

    protected int getStartIndex(final List<String> lines) {
        return lines.indexOf("table = \"<!-- begin section All-->\\");
    }

    protected int getEndIndex(final List<String> lines) {
        return lines.indexOf("<!-- end section All-->\\");
    }

    protected List<Node> getFragmentChildNodes(final Document fragment) {
        return fragment.childNode(0).childNode(1).childNodes();
    }

    protected boolean removeFromValues(final String value) {
        return value.startsWith("<img src=\"");
    }

    protected abstract T buildIndex(final List<String> values);

    protected String getDescription(final List<String> values) {
        return values.get(1);
    }

    protected double getTrend(final List<String> values) {
        return getParsePercentDouble(values.get(3));
    }

    protected double getParsePercentDouble(final String value) {
        return Double.parseDouble(replacePercent(value).trim());
    }

    protected double getShare(final List<String> values) {
        return getParsePercentDouble(values.get(2));
    }

    protected int getRank(final List<String> values) {
        return Integer.parseInt(values.get(0));
    }

    protected String replacePercent(final String value) {
        return value.replace('%', ' ');
    }
}
