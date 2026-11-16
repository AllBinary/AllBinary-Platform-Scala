/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.crypt.jcehelper

import _root_.java.security.spec.KeySpec
import _root_.javax.crypto.spec.DESKeySpec
import _root_.javax.crypto.spec.DESedeKeySpec
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonStrings

class KeySpecFactory private() {
    import _root_.org.allbinary.logic.system.security.crypt.jcehelper.KeySpecFactory.{*}

    //tested
    val DES : String = "DES"

    //requires 24byte key mininum
    val DESEDE : String = "DESede"

    //untested
    val BLOWFISH : String = "Blowfish"

    def getInstance(algorithm : String, keyData : Array[Byte]) : KeySpec = {
        try {
            val tsUtil : TsUtil = TsUtil.getInstance()
            if (tsUtil.compareTo(algorithm, this.DES) == 0) {
                return new DESKeySpec(keyData)
            } else if (tsUtil.compareTo(algorithm, this.DESEDE) == 0) {
                return new DESedeKeySpec(keyData)
            } else {
                throw new RuntimeException()
            }
        } catch {
            case e : Exception => {
                //{
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                PreLogUtil.putOE(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                //return null;
                throw new RuntimeException()
            }
        }
        throw new IllegalStateException()
    }

}

object KeySpecFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : KeySpecFactory = new KeySpecFactory()

    def getInstance() : KeySpecFactory = {
        return KeySpecFactory.instance
    }

}


