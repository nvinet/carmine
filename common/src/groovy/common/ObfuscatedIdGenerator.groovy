package common

import org.hibernate.id.*
import org.hibernate.engine.SessionImplementor

/**
 * Created by IntelliJ IDEA.
 * User: Nico
 * Date: 29/06/11
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
class ObfuscatedIdGenerator extends TableHiLoGenerator   {
    public Serializable generate(SessionImplementor session, Object obj) {
        def id = super.generate(session, obj)
        def newId = (id ^ 4321) // don't ever change this number!!!
        return newId
    }
}
