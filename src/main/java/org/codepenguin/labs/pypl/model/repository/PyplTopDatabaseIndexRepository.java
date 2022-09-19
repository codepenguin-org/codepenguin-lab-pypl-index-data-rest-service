package org.codepenguin.labs.pypl.model.repository;

import org.codepenguin.labs.pypl.model.entity.PyplTopDatabaseIndex;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class PyplTopDatabaseIndexRepository extends AbstractPyplTopIndexRepository<PyplTopDatabaseIndex> {

    PyplTopDatabaseIndexRepository() {
        super("https://pypl.github.io/DB.html");
    }

    @Override
    protected PyplTopDatabaseIndex buildIndex(List<String> values) {
        return new PyplTopDatabaseIndex(getRank(values), getShare(values), getTrend(values), getDescription(values));
    }
}
