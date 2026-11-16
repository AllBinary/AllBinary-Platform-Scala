/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.thirdparty.store

import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

/**  *  * @author user  */
class NoThirdPartyStore() extends ThirdPartyStore(StringUtil.getInstance().EMPTY_STRING) {

    override def authorize(clientInformationInterface : AbeClientInformationInterface) : Unit = {
        this.setAuthorized(true)
    }

}


