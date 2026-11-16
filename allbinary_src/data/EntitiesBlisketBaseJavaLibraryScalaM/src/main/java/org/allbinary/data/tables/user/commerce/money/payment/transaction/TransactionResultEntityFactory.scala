/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user.commerce.money.payment.transaction

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class TransactionResultEntityFactory private() {
    import _root_.org.allbinary.data.tables.user.commerce.money.payment.transaction.TransactionResultEntityFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getTransactionResultEntityInstance() : TransactionResultEntity = {
        try {
            //return (TransactionEntityInterface) InterfaceCastProxy.newInstance(object);
            return new _root_.org.allbinary.data.tables.user.commerce.money.payment.transaction.TransactionResultEntity()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().ENTITYFACTORYERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

}

object TransactionResultEntityFactory {
    private val instance : TransactionResultEntityFactory = new TransactionResultEntityFactory()

    /**      * @return the instance      */
    def getInstance() : TransactionResultEntityFactory = {
        return TransactionResultEntityFactory.instance
    }

}


