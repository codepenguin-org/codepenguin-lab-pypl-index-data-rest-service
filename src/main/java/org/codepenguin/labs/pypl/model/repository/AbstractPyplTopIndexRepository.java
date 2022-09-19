/*
 * codepenguin-lab-pypl-index-data-rest-service 2022 CodePenguin.org - Jorge Alfonso Garcia Espinosa
 *
 * Creative Commons Attribution 3.0 Unported
 *
 * THE WORK (AS DEFINED BELOW) IS PROVIDED UNDER THE TERMS OF THIS CREATIVE COMMONS PUBLIC LICENSE ("CCPL" OR "LICENSE"). THE
 * WORK IS PROTECTED BY COPYRIGHT AND/OR OTHER APPLICABLE LAW. ANY USE OF THE WORK OTHER THAN AS AUTHORIZED UNDER THIS
 * LICENSE OR COPYRIGHT LAW IS PROHIBITED.
 *
 * BY EXERCISING ANY RIGHTS TO THE WORK PROVIDED HERE, YOU ACCEPT AND AGREE TO BE BOUND BY THE TERMS OF THIS LICENSE. TO THE
 * EXTENT THIS LICENSE MAY BE CONSIDERED TO BE A CONTRACT, THE LICENSOR GRANTS YOU THE RIGHTS CONTAINED HERE IN
 * CONSIDERATION OF YOUR ACCEPTANCE OF SUCH TERMS AND CONDITIONS.
 */

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

/**
 * The type Abstract pypl top index repository.
 *
 * @param <T> the type parameter
 * @author Jorge Garcia
 * @version 1.0.0
 * @since 17
 */
abstract class AbstractPyplTopIndexRepository<T> implements PyplTopIndexRepository<T> {

    private final String url;

    /**
     * Instantiates a new Abstract pypl top index repository.
     *
     * @param url the url
     */
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

    /**
     * Gets script node.
     *
     * @param document the document
     * @return the script node
     */
    protected Optional<Node> getScriptNode(final Document document) {
        return Optional.ofNullable(document.childNode(2).childNode(1).childNode(41).firstChild());
    }

    /**
     * Gets start index.
     *
     * @param lines the lines
     * @return the start index
     */
    protected int getStartIndex(final List<String> lines) {
        return lines.indexOf("table = \"<!-- begin section All-->\\");
    }

    /**
     * Gets end index.
     *
     * @param lines the lines
     * @return the end index
     */
    protected int getEndIndex(final List<String> lines) {
        return lines.indexOf("<!-- end section All-->\\");
    }

    /**
     * Gets fragment child nodes.
     *
     * @param fragment the fragment
     * @return the fragment child nodes
     */
    protected List<Node> getFragmentChildNodes(final Document fragment) {
        return fragment.childNode(0).childNode(1).childNodes();
    }

    /**
     * Remove from values boolean.
     *
     * @param value the value
     * @return the boolean
     */
    protected boolean removeFromValues(final String value) {
        return value.startsWith("<img src=\"");
    }

    /**
     * Build index t.
     *
     * @param values the values
     * @return the t
     */
    protected abstract T buildIndex(final List<String> values);

    /**
     * Gets description.
     *
     * @param values the values
     * @return the description
     */
    protected String getDescription(final List<String> values) {
        return values.get(1);
    }

    /**
     * Gets trend.
     *
     * @param values the values
     * @return the trend
     */
    protected double getTrend(final List<String> values) {
        return getParsePercentDouble(values.get(3));
    }

    /**
     * Gets parse percent double.
     *
     * @param value the value
     * @return the parse percent double
     */
    protected double getParsePercentDouble(final String value) {
        return Double.parseDouble(replacePercent(value).trim());
    }

    /**
     * Gets share.
     *
     * @param values the values
     * @return the share
     */
    protected double getShare(final List<String> values) {
        return getParsePercentDouble(values.get(2));
    }

    /**
     * Gets rank.
     *
     * @param values the values
     * @return the rank
     */
    protected int getRank(final List<String> values) {
        return Integer.parseInt(values.get(0));
    }

    /**
     * Replace percent string.
     *
     * @param value the value
     * @return the string
     */
    protected String replacePercent(final String value) {
        return value.replace('%', ' ');
    }
}
