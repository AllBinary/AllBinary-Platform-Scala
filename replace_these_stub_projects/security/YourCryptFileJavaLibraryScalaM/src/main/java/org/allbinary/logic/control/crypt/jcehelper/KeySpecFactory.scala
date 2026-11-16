/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.crypt.jcehelper

import _root_.java.security.spec.KeySpec

class KeySpecFactory private() {
    import _root_.org.allbinary.logic.control.crypt.jcehelper.KeySpecFactory.{DES as _, DESEDE as _, *}
    def DES : String = _root_.org.allbinary.logic.control.crypt.jcehelper.KeySpecFactory.DES
    def DESEDE : String = _root_.org.allbinary.logic.control.crypt.jcehelper.KeySpecFactory.DESEDE

}

object KeySpecFactory {
    val DES : String = "DES"

    //requires 24byte key mininum
    val DESEDE : String = "DESede"

    def getInstance(algorithm : String, keyData : Array[Byte]) : KeySpec = {
        return null
    }

}


