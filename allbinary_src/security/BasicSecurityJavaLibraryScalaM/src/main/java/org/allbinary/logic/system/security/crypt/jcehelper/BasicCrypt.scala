/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.crypt.jcehelper

import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.init.crypt.jcehelper.CryptInterface
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.java.byteutil.ByteUtil
import _root_.org.allbinary.string.CommonStrings

class BasicCrypt(param_keyAsString : String) extends CryptInterface {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val byteUtil : ByteUtil = ByteUtil.getInstance()

    private var key : Array[Byte] = null

    //Constructor
    {
        val keyAsString : String = param_keyAsString
        var key : Array[Byte] = NullUtil.getInstance().NULL_BYTE_ARRAY
        try {
            key = TsUtil.getInstance().getByteArray(keyAsString)
        } catch {
            case e : Exception => {
                //{
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                PreLogUtil.putOE(commonStrings.EXCEPTION, this, "AbCrypt(alg,key)", e)
            }
        }
        this.key = key
    }

    override def encrypt(array : Array[Byte]) : Array[Byte] = {
        try {
            return this.mutilate(array)
        } catch {
            case e : Exception => {
                //{
                PreLogUtil.putOE("Encrypt Failed", this, "encrypt", e)
                //}
                return NullUtil.getInstance().NULL_BYTE_ARRAY
            }
        }
        throw new IllegalStateException()
    }

    override def decrypt(array : Array[Byte]) : Array[Byte] = {
        try {
            return this.mutilate(array)
        } catch {
            case e : Exception => {
                //{
                PreLogUtil.putOE("decrypt Failed", this, "decrypt", e)
                //}
                return NullUtil.getInstance().NULL_BYTE_ARRAY
            }
        }
        throw new IllegalStateException()
    }

    /*     public byte[] mutilate(byte [] array)     {     ByteUtil byteUtil = new ByteUtil();     array = byteUtil.not(array);     return array;     }      */
    def mutilate(param_array : Array[Byte]) : Array[Byte] = {
        var array : Array[Byte] = param_array
        var value : Byte = 0

        {
            var index : Int = 0
            while (index < this.key.length) {
                value = this.key(index)
                //{
                array = this.byteUtil.xor(array, value)
                index += 1
            }
        }
        return array
    }

}


