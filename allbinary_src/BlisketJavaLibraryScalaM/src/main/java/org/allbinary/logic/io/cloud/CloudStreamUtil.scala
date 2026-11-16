/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io

import _root_.java.io.InputStream
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.AbFile

/**  *  * @author user  */
class CloudStreamUtil {
    import _root_.org.allbinary.logic.io.CloudStreamUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getFile(file : AbFile) : InputStream = {
        var inputStream : InputStream = AbFileInputStream.createFromAbFile(file)
        var available : Int = inputStream.available()
        if (available > 0) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("Cloud File Bytes: " + available, this, "processRequest()")
            }
        }
        return inputStream
    }

    def getFileAnyWhere(file : AbFile) : InputStream = {
        var inputStream : InputStream = new AbFileLocalInputStream(file)
        var available : Int = inputStream.available()
        if (available > 0) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("Local File Bytes: " + available, this, "processRequest()")
            }
        } else {
            inputStream = AbFileInputStream.createFromAbFile(file)
            available = inputStream.available()
            if (available > 0) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.putF("Cloud File Bytes: " + available, this, "processRequest()")
                }
            }
        }
        return inputStream
    }

    def getFileLocal(file : AbFile) : InputStream = {
        var inputStream : InputStream = new AbFileLocalInputStream(file)
        var available : Int = inputStream.available()
        if (available > 0) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("Local File Bytes: " + available, this, "processRequest()")
            }
        }
        return inputStream
    }

}

object CloudStreamUtil {
    private val instance : CloudStreamUtil = new CloudStreamUtil()

    /**      * @return the instance      */
    def getInstance() : CloudStreamUtil = {
        return CloudStreamUtil.instance
    }

}


