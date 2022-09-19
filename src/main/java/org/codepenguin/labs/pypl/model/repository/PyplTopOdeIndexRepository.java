package org.codepenguin.labs.pypl.model.repository;

import org.codepenguin.labs.pypl.model.entity.PyplTopOdeIndex;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class PyplTopOdeIndexRepository extends AbstractPyplTopIndexRepository<PyplTopOdeIndex> {

    PyplTopOdeIndexRepository() {
        super("https://pypl.github.io/ODE.html");
    }

    @Override
    protected PyplTopOdeIndex buildIndex(List<String> values) {
        return new PyplTopOdeIndex(getRank(values), getShare(values), getTrend(values), getDescription(values));
    }
}
