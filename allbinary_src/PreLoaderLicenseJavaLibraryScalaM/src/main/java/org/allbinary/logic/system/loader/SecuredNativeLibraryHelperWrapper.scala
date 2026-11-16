/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.loader

import _root_.org.allbinary.logic.system.security.AbKeys
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

class SecuredNativeLibraryHelperWrapper(param_securedNativeLibraryInterface : SecuredNativeLibraryInterface) extends NativeLibraryHelperWrapper(param_securedNativeLibraryInterface.getLibraryName()) {

    private var securedNativeLibraryInterface : SecuredNativeLibraryInterface = null

    //Constructor
    {
        val securedNativeLibraryInterface : SecuredNativeLibraryInterface = param_securedNativeLibraryInterface
        this.securedNativeLibraryInterface = securedNativeLibraryInterface
    }

    def unlock(abeClientInformation : AbeClientInformationInterface) : Boolean = {
        return this.securedNativeLibraryInterface.unlock(AbKeys.getInstance().getKey(abeClientInformation, this.securedNativeLibraryInterface.getName()))
    }

}


