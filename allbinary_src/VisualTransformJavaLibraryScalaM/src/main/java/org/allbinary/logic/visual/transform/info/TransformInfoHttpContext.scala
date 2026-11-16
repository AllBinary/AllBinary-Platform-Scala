/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class TransformInfoHttpContext private (super_1 : HashMap[Object, Object], super_2 : HashMap[Object, Object], super_3 : PageContext, constructor_ : Unit) extends TransformInfoHttp(super_1, super_2, super_3) {

    val logUtil_TransformInfoHttpContext : LogUtil = LogUtil.getInstance()

    //in a special type of viewinfo
    def this(databaseHashMap : HashMap[Object, Object], propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this(databaseHashMap, propertiesHashMap, pageContext, ())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Database HashMap: ")
            stringBuffer.append(databaseHashMap.toString())
            stringBuffer.append("\nProperties HashMap: ")
            stringBuffer.append(propertiesHashMap.toString())
            this.logUtil_TransformInfoHttpContext.putF(stringBuffer.toString(), this, this.commonStrings.CONSTRUCTOR)
        }
        this.setStoreName(StringUtil.getInstance().EMPTY_STRING)
    }

    def this(propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this(propertiesHashMap, pageContext, null, ())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_TransformInfoHttpContext.putF("Properties HashMap: " + propertiesHashMap.toString(), this, this.commonStrings.CONSTRUCTOR)
        }
        this.setStoreName(StringUtil.getInstance().EMPTY_STRING)
    }

    private def getPath() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(URLGLOBALS.getMainPath())
        stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
        stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().INSTALLPATH)
        stringBuffer.append(this.getStoreName())
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        return stringBuffer.toString()
    }

    override def getTemplateFilePath() : AbPath = {
        return new AbPath(this.getPath(), this.getTemplateFile())
    }

    override def getObjectConfigFilePath() : AbPath = {
        return new AbPath(this.getPath(), this.getObjectConfigFile())
    }

    override def getDataFilePath() : AbPath = {
        return new AbPath(this.getPath(), this.getDataFile())
    }

}


