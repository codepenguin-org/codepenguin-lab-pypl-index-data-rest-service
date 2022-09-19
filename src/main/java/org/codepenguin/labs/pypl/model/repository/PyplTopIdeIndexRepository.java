package org.codepenguin.labs.pypl.model.repository;

import org.codepenguin.labs.pypl.model.entity.PyplTopIdeIndex;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PyplTopIdeIndexRepository extends AbstractPyplTopIndexRepository<PyplTopIdeIndex> {

    public PyplTopIdeIndexRepository() {
        super("https://pypl.github.io/IDE.html");
    }

    @Override
    protected Optional<Node> getScriptNode(final Document document) {
        return Optional.ofNullable(document.childNode(2).childNode(1).childNode(41).firstChild());
    }

    @Override
    protected int getStartIndex(final List<String> lines) {
        return lines.indexOf("table = \"<!-- begin section All-->\\");
    }

    @Override
    protected int getEndIndex(final List<String> lines) {
        return lines.indexOf("<!-- end section All-->\\");
    }

    @Override
    protected List<Node> getFragmentChildNodes(final Document fragment) {
        return fragment.childNode(0).childNode(1).childNodes();
    }

    @Override
    protected boolean removeFromValues(final String value) {
        return value.startsWith("<img src=\"");
    }


    @Override
    protected PyplTopIdeIndex buildIndex(final List<String> values) {
        return new PyplTopIdeIndex(
                Integer.parseInt(values.get(0)),
                values.get(1),
                Double.parseDouble(values.get(2).replace('%', ' ').trim()),
                Double.parseDouble(values.get(3).replace('%', ' ').trim())
        );
    }
}
