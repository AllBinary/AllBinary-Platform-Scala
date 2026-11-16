/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.resource

import _root_.java.io.InputStream
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

//J2SE - J2ME
class ResourceUtil private() {
    import _root_.org.allbinary.data.resource.ResourceUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def setLoadingPaths(path : String, ext : String) : Unit = {
        this.logUtil.putF(CommonStrings.getInstance().NOT_IMPLEMENTED, this, "setLoadingPaths")
    }

    //    }
    def setClassLoader(classLoader : ClassLoader) : Unit = {
        this.logUtil.putF(new StringMaker().append("Resource Loader: ").append(classLoader.getClass().getName()).toString(), this, "setClassLoader")
        ResourceUtil.classLoader = classLoader
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
        //final StringMaker stringMaker = new StringMaker();
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val index : Int = resource.indexOf(commonSeps.COLON)
        val resourcePath : String = resource.substring(index + startIndex)
        //Try getting resource with normal resource access
        var inputStream : InputStream = resource.getClass().getResourceAsStream(resourcePath)
        if (inputStream != null) {
            //            this.logUtil.putF(stringMaker.append(RESOURCE_FOUND).append(resourcePath).toString(), this, METHOD_NAME);
            return inputStream
        }
        //Try getting resource with ClassLoader
        val classLoader : ClassLoader = ResourceUtil.classLoader.asInstanceOf[ClassLoader]
        inputStream = classLoader.getResourceAsStream(resourcePath)
        if (inputStream != null) {
            //            this.logUtil.putF(stringMaker.append(RESOURCE_FOUND_WITH).append(resourcePath).append(commonSeps.COMMA).append(ResourceUtil.classLoader.getClass().getName()).toString(), this, METHOD_NAME);
            return inputStream
        }
        inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath)
        if (inputStream != null) {
            //            this.logUtil.putF(stringMaker.append(RESOURCE_FOUND_WITH_CONTEXT_CLASS_LOADER).append(resourcePath).append(commonSeps.COMMA).append(Thread.currentThread().getContextClassLoader().getClass().getName()).toString(), this, METHOD_NAME);
            return inputStream
        }
        /*       if(inputStream != null)       {          this.logUtil.putF("Resource Found In Specified Jar", this, METHOD_NAME);           return inputStream;       }              //Try getting the resource from the jar again using the custom Imp       //inputStream = JarResourceUtil.getResourceAsStream(resourcePath);        if(inputStream != null)       {          this.logUtil.putF("Resource Found In Jar", this, METHOD_NAME);           return inputStream;       }        //Try getting the resource from a normal file outside of the jar       //inputStream = FileResourceUtil.getResourceAsStream(".").append(resourcePath);        if(inputStream != null)       {          this.logUtil.putF("Resource Found In File", this, METHOD_NAME);           return inputStream;       }        //inputStream = FileResourceUtil.getResourceAsStream(resourcePath);        if(inputStream != null)       {          this.logUtil.putF("Resource Found In File - Absolute Path", this, METHOD_NAME);       }          */
        return inputStream
    }

    def addResource(resource : String, value : Integer) : Unit = {
    }

}

object ResourceUtil {
    private var classLoader : Object = NullUtil.getInstance().NULL_OBJECT

    private val instance : ResourceUtil = new ResourceUtil()

    def getInstance() : ResourceUtil = {
        return ResourceUtil.instance
    }

}


