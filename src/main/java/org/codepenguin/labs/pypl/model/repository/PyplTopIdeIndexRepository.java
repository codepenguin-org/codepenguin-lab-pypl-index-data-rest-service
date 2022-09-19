package org.codepenguin.labs.pypl.model.repository;

import org.codepenguin.labs.pypl.model.entity.PyplTopIdeIndex;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class PyplTopIdeIndexRepository extends AbstractPyplTopIndexRepository<PyplTopIdeIndex> {

    PyplTopIdeIndexRepository() {
        super("https://pypl.github.io/IDE.html");
    }


    @Override
    protected PyplTopIdeIndex buildIndex(final List<String> values) {
        return new PyplTopIdeIndex(getRank(values), getShare(values), getTrend(values), getDescription(values));
    }
}
