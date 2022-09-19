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

import org.codepenguin.labs.pypl.model.entity.PyplTopProgrammingLanguageIndex;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The type Pypl top programming language index repository.
 * @author Jorge Garcia
 * @version 1.0.0
 * @since 17
 */
@Repository
class PyplTopProgrammingLanguageIndexRepository extends AbstractPyplTopIndexRepository<PyplTopProgrammingLanguageIndex> {

    /**
     * Instantiates a new Pypl top programming language index repository.
     */
    PyplTopProgrammingLanguageIndexRepository() {
        super("https://pypl.github.io/PYPL.html");
    }

    @Override
    protected PyplTopProgrammingLanguageIndex buildIndex(List<String> values) {
        return new PyplTopProgrammingLanguageIndex(getRank(values), getShare(values), getTrend(values),
                getDescription(values));
    }
}
