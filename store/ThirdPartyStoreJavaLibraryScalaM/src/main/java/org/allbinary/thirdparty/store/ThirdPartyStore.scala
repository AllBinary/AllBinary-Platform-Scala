/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.thirdparty.store

import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface

/**  *  * @author user  */
class ThirdPartyStore(param_name : String) {

    private var authorized : Boolean = false

    private var name : String = null

    //Constructor
    {
        val name : String = param_name
        this.name = name
    }

    def authorize(clientInformationInterface : AbeClientInformationInterface) : Unit = {
    }

    /**      * @return the authorized      */
    def isAuthorized() : Boolean = {
        return this.authorized
    }

    /**      * @param authorized the authorized to set      */
    def setAuthorized(authorized : Boolean) : Unit = {
        this.authorized = authorized
    }

    /**      * @return the name      */
    def getName() : String = {
        return this.name
    }

}


