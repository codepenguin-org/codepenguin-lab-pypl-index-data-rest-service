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

public abstract class AbstractPyplTopIndexRepository<T> implements PyplTopIndexRepository<T> {

    private final String url;

    public AbstractPyplTopIndexRepository(final String url) {
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

    protected abstract Optional<Node> getScriptNode(final Document document);

    protected abstract int getStartIndex(final List<String> lines);

    protected abstract int getEndIndex(final List<String> lines);

    protected abstract List<Node> getFragmentChildNodes(final Document fragment);

    protected abstract boolean removeFromValues(final String value);

    protected abstract T buildIndex(final List<String> values);
}
