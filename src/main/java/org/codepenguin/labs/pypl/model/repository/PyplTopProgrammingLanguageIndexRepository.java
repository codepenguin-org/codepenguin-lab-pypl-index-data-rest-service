package org.codepenguin.labs.pypl.model.repository;

import org.codepenguin.labs.pypl.model.entity.PyplTopProgrammingLanguageIndex;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class PyplTopProgrammingLanguageIndexRepository extends AbstractPyplTopIndexRepository<PyplTopProgrammingLanguageIndex> {

    PyplTopProgrammingLanguageIndexRepository() {
        super("https://pypl.github.io/PYPL.html");
    }

    @Override
    protected PyplTopProgrammingLanguageIndex buildIndex(List<String> values) {
        return new PyplTopProgrammingLanguageIndex(getRank(values), getShare(values), getTrend(values),
                getDescription(values));
    }
}
