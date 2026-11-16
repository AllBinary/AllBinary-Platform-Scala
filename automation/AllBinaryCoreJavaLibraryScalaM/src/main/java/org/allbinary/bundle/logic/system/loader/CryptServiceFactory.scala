/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.bundle.logic.system.loader

import _root_.org.osgi.framework.Bundle
import _root_.org.osgi.framework.ServiceFactory
import _root_.org.osgi.framework.ServiceRegistration
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class CryptServiceFactory() extends ServiceFactory {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var cryptService : CryptService = new CryptService()

    def getService(bundle : Bundle, registration : ServiceRegistration) : Object = {
        this.logUtil.putF(this.commonStrings.START, this, "getService")
        return this.cryptService
    }

    def ungetService(bundle : Bundle, registration : ServiceRegistration, service : Object) : Unit = {
    }

}


