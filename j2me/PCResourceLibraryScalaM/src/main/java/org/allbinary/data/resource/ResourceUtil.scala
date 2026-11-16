/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.resource

import _root_.java.io.ByteArrayInputStream
import _root_.java.io.ByteArrayOutputStream
import _root_.java.io.FileInputStream
import _root_.java.io.InputStream
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

//J2SE - PC
class ResourceUtil private() {
    import _root_.org.allbinary.data.resource.ResourceUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var path : String = StringUtil.getInstance().EMPTY_STRING

    private var ext : String = StringUtil.getInstance().EMPTY_STRING

    def setLoadingPaths(path : String, ext : String) : Unit = {
        this.path = path
        this.ext = ext
    }

    //    }
    def setClassLoader(classLoader : ClassLoader) : Unit = {
    }

    def getResourceAsStream(resource : String) : InputStream = {
        var inputStream : InputStream = this.getResourceAsStreamAtStart(resource, 2)
        if (inputStream == null) {
            inputStream = this.getResourceAsStreamAtStart(resource, 1)
            if (inputStream == null) {
                throw new Exception(new StringMaker().append("Unable to obtain: ").append(resource).toString())
            }
        }
        return inputStream
    }

    //private final String METHOD_NAME = "getResourceAsStream";
    private def getResourceAsStreamAtStart(resource : String, startIndex : Int) : InputStream = {
        //Try getting resource with normal resource access
        var inputStream : InputStream = new FileInputStream(new StringMaker().append(this.path).append(resource).append(this.ext).toString())
        if (inputStream != null) {
            //            this.logUtil.putF(stringMaker.append(RESOURCE_FOUND).append(resource).toString(), this, METHOD_NAME);
            val byteArray : Array[Byte] = new Array[Byte](inputStream.available())
            StreamUtil.getInstance().getByteArray(inputStream, new ByteArrayOutputStream(), byteArray)
            return new ByteArrayInputStream(byteArray)
        }
        return inputStream
    }

    def addResource(resource : String, value : Integer) : Unit = {
    }

}

object ResourceUtil {
    private val instance : ResourceUtil = new ResourceUtil()

    def getInstance() : ResourceUtil = {
        return ResourceUtil.instance
    }

}


