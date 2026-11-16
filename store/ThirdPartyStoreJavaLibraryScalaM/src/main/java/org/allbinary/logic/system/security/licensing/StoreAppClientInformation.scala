/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.thirdparty.store.LongArrayIdentifierInterface

/**  *  * @author user  */
class StoreAppClientInformation(param_name : String, param_version : String, param_specialName : String, param_shortName : String, param_longArrayIdentifier : Array[Long]) extends AbeClientInformation(param_name, param_version, param_specialName, param_shortName) with LongArrayIdentifierInterface {

    private var longArrayIdentifier : Array[Long] = null

    //Constructor
    {
        val name : String = param_name
        val version : String = param_version
        val specialName : String = param_specialName
        val shortName : String = param_shortName
        val longArrayIdentifier : Array[Long] = param_longArrayIdentifier
        this.longArrayIdentifier = longArrayIdentifier
    }

    /**      * @return the longArrayIdentifier      */
    override def getLongArrayIdentifier() : Array[Long] = {
        return this.longArrayIdentifier
    }

}


