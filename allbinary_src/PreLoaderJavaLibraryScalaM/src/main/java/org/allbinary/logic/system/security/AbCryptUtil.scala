/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *  * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *  * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *  * Created By: Travis Berthelot  *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security

import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.InputStream
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.system.security.crypt.jcehelper.AbCrypt
import _root_.org.allbinary.logic.system.security.crypt.jcehelper.KeySpecFactory

class AbCryptUtil private() {
    import _root_.org.allbinary.logic.system.security.AbCryptUtil.{*}

    private val streamUtil : StreamUtil = StreamUtil.getInstance()

    def decrypt(inputStream : InputStream, key : String) : Array[Byte] = {
        var outputStream : ByteArrayOutputStream = null
        try {
            outputStream = this.streamUtil.get(inputStream, new ByteArrayOutputStream(), new Array[Byte](16384)).asInstanceOf[ByteArrayOutputStream]
            val abCrypt : AbCrypt = new AbCrypt(KeySpecFactory.getInstance().DESEDE)
            abCrypt.init(key)
            return abCrypt.decrypt(outputStream.toByteArray())
        } finally {
            this.streamUtil.close(outputStream)
            this.streamUtil.close(inputStream)
        }
        throw new IllegalStateException()
    }

}

object AbCryptUtil {
    private val instance : AbCryptUtil = new AbCryptUtil()

    def getInstance() : AbCryptUtil = {
        return AbCryptUtil.instance
    }

}


