/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.smtp.event.handler.factory

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.data.tables.user.UserEntityFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.smtp.event.UserEmailEventNameData
import _root_.org.allbinary.logic.communication.smtp.event.handler.EmailEventHandlerUtil
import _root_.org.allbinary.logic.communication.smtp.event.handler.UserEmailEventHandler
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.string.CommonStrings

class StoreAdminUserEmailEventHandlerSingletons private() {
    import _root_.org.allbinary.logic.communication.smtp.event.handler.factory.StoreAdminUserEmailEventHandlerSingletons.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val userEmailEventHandlerHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]

    //Constructor
    {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def getInstance(userEmailEventNameData : UserEmailEventNameData, abeClientInformation : AbeClientInformationInterface, storeFrontInterface : StoreFrontInterface) : UserEmailEventHandler = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.GET_INSTANCE)
        }
        var userEmailEventHandler : UserEmailEventHandler = this.userEmailEventHandlerHashMap.get(userEmailEventNameData).asInstanceOf[UserEmailEventHandler]
        if (userEmailEventHandler == null) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
                this.logUtil.putF("Creating New Named UserEmailEventHandler", this, this.commonStrings.GET_INSTANCE)
            }
            //Each store admin user my subscribe to emails with their email configuration
            var userVector : BasicArrayList = UserEntityFactory.getInstance().getStoreManagers(storeFrontInterface)
            //Create New Handler and add listeners
            var newUserEmailEventHandler : UserEmailEventHandler = EmailEventHandlerUtil.getInstance().getEventHandler(abeClientInformation, userEmailEventNameData, userVector)
            this.userEmailEventHandlerHashMap.put(userEmailEventNameData, newUserEmailEventHandler)
            return newUserEmailEventHandler
        } else {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().EMAILLOGGING)) {
                this.logUtil.putF("Returning existing UserEmailEventHandler", this, this.commonStrings.GET_INSTANCE)
            }
            //Return existing event Handler
            return userEmailEventHandler
        }
        throw new IllegalStateException()
    }

}

object StoreAdminUserEmailEventHandlerSingletons {
    private val instance : StoreAdminUserEmailEventHandlerSingletons = new StoreAdminUserEmailEventHandlerSingletons()

    def getInstance() : StoreAdminUserEmailEventHandlerSingletons = {
        return StoreAdminUserEmailEventHandlerSingletons.instance
    }

}


