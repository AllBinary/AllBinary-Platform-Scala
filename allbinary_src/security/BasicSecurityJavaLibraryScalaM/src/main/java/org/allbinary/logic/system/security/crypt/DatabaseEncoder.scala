/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.crypt

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.tokens.Tokenizer
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class DatabaseEncoder private() {
    import _root_.org.allbinary.logic.system.security.crypt.DatabaseEncoder.{*}

}

object DatabaseEncoder {
    def encode(value : Array[Byte]) : String = {
        try {
            var array : Array[Byte] = value
            val stringBuffer : StringMaker = new StringMaker()

            {
                var index : Int = 0
                while (index < array.length) {
                    stringBuffer.append(new _root_.java.lang.Byte(array(index)).toString())
                    if (index < (array.length - 1)) {
                        stringBuffer.append(CommonSeps.getInstance().SPACE)
                    }
                    index += 1
                }
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                //{
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                PreLogUtil.putOE(commonStrings.EXCEPTION, "DatabaseEncoder", "decode", e)
                //}
                return StringUtil.getInstance().EMPTY_STRING
            }
        }
        throw new IllegalStateException()
    }

    def decode(value : String) : Array[Byte] = {
        try {
            val tokenizer : Tokenizer = new Tokenizer(CommonSeps.getInstance().SPACE)
            val vector : BasicArrayList = tokenizer.getTokensFromString(value, new BasicArrayListD())
            val size : Int = vector.size()
            //Each token is parsed straight into the array so no Byte objects are needed
            val decode : Array[Byte] = new Array[Byte](size)
            var byteOfData : String = null

            {
                var index : Int = 0
                while (index < size) {
                    byteOfData = vector.objectArray(index).asInstanceOf[String]
                    decode(index) = _root_.java.lang.Byte.parseByte(byteOfData)
                    index += 1
                }
            }
            return decode
        } catch {
            case e : Exception => {
                //{
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                PreLogUtil.putSE(commonStrings.EXCEPTION, "DatabaseEncoder", "decode", e)
                //}
                return NullUtil.getInstance().NULL_BYTE_ARRAY
            }
        }
        throw new IllegalStateException()
    }

}


