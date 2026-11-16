/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.installer

import _root_.org.allbinary.business.init.db.DatabaseConnectionInfoInterface
import _root_.org.allbinary.business.init.db.InitDbHelperFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

//Warning you must have sql root access
class DynamicInitDb private () extends InitDb {

    def this(abeClientInformation : AbeClientInformationInterface, databaseConnectionInfoInterface : DatabaseConnectionInfoInterface) = {
        this()
        this.setHelper(InitDbHelperFactory.getInstance(abeClientInformation, databaseConnectionInfoInterface))
    }

    def this(abeClientInformation : AbeClientInformationInterface) = {
        this()
        this.setHelper(InitDbHelperFactory.getInstance(abeClientInformation))
    }

}


