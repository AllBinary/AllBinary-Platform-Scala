/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.init.crypt.jcehelper

import _root_.java.io.ByteArrayInputStream
import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.InputStream
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.communication.log.LogUtil

class BasicCryptUtil {
    import _root_.org.allbinary.init.crypt.jcehelper.BasicCryptUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val tsUtil : TsUtil = TsUtil.getInstance()

    private val XML_START : String = "<?xml"

    def getDecryptedInputStream(inputStream : InputStream, cryptInterface : CryptInterface) : InputStream = {
        var buffer : ByteArrayOutputStream = new ByteArrayOutputStream()
        var ch : Int = 0
        //while ((ch = inputStream.read()) != -1)

        {
            scala.util.boundary { (break_N68152 : scala.util.boundary.Label[Unit]) ?=>
                while (true) {
                    ch = inputStream.read()
                    if (ch == -1) {
                        scala.util.boundary.break()(using break_N68152)
                    }
                    //buffer.write((byte) ch);
                    buffer.write(ch)
                }
            }
        }
        //byte[] decrypted = cryptInterface.decrypt(tsUtil.getBytes(responseData));
        var decrypted : Array[Byte] = cryptInterface.decrypt(buffer.toByteArray())
        //TWB - debug output
        var decryptedString : String = new String(decrypted)
        //PreLogUtil.put(decryptedString, this, "decRespXMLRPC");
        var index : Int = decryptedString.indexOf(this.XML_START)
        if (index > 0) {
            ////System.out.println("Removing Pre Decrypted XML data");
            decryptedString = decryptedString.substring(index)
        }
        ////PreLogUtil.put(new String(decryptedString), this, "decRespXMLRPC");
        return new ByteArrayInputStream(this.tsUtil.getByteArray(decryptedString))
    }

}

object BasicCryptUtil {
    private val instance : BasicCryptUtil = new BasicCryptUtil()

    /**      * @return the instance      */
    def getInstance() : BasicCryptUtil = {
        return BasicCryptUtil.instance
    }

}


