/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing.registration

import _root_.org.allbinary.logic.string.StringMaker

class RegistrationConfiguration private() {
    import _root_.org.allbinary.logic.system.security.licensing.registration.RegistrationConfiguration.{*}

    private var registrationCode : String = "No Registration Code"

    val NAME : String = "registrationid"

    private def read() : Unit = {
    }

    def write() : Unit = {
    }

    override def toString() : String = {
        return new StringMaker().append("Registration Code: ").append(this.getRegistrationCode()).toString()
    }

    def setRegistrationCode(registrationCode : String) : Unit = {
        this.registrationCode = registrationCode
    }

    def getRegistrationCode() : String = {
        return this.registrationCode
    }

}

object RegistrationConfiguration {
    private val SINGLETON : RegistrationConfiguration = new RegistrationConfiguration()

    def getInstance() : RegistrationConfiguration = {
        return RegistrationConfiguration.SINGLETON
    }

}


