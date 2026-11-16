/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.init.db

import _root_.org.allbinary.logic.system.loader.AbeFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class InitDbHelperFactory private() {
    import _root_.org.allbinary.business.init.db.InitDbHelperFactory.{*}

}

object InitDbHelperFactory {
    private val CLASSNAME : String = "org.allbinary.business.installer.InitDbCrypted"

    def getInstance(abeClientInformation : AbeClientInformationInterface, databaseConnectionInfoInterface : DatabaseConnectionInfoInterface) : Object = {
        var params : Array[Object] = new Array[Object](1)
        var classes : Array[Class[?]] = new Array[Class[?]](1)
        //Add param types
        classes(0) = classOf[DatabaseConnectionInfoInterface]
        //Add arguments
        params(0) = databaseConnectionInfoInterface.asInstanceOf[Object]
        //Object object = AbeFactory.getInstance().getNoLicenseInstance(CLASSNAME, classes, params);
        var anyType : Object = AbeFactory.getInstance().getInstance(abeClientInformation, CLASSNAME, classes, params)
        return anyType
    }

    def getInstance(abeClientInformation : AbeClientInformationInterface) : Object = {
        //Object object = AbeFactory.getInstance().getNoLicenseInstance(CLASSNAME, null, null);
        var anyType : Object = AbeFactory.getInstance().getInstance(abeClientInformation, CLASSNAME, null, null)
        return anyType
    }

}


