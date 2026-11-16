/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker

class TransformInfoHttpStore private (super_1 : HashMap[Object, Object], super_2 : PageContext, super_3 : Boolean, constructor_ : Unit) extends TransformInfoHttp(super_1, super_2, super_3) with TransformInfoHttpStoreInterface {

    val logUtil_TransformInfoHttpStore : LogUtil = LogUtil.getInstance()

    //in a special type of viewinfo
    def this(databaseHashMap : HashMap[Object, Object], propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this(databaseHashMap, propertiesHashMap, pageContext, ())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("Database HashMap: ")
            stringBuffer.append(databaseHashMap.toString())
            stringBuffer.append("\nProperties HashMap: ")
            stringBuffer.append(propertiesHashMap.toString())
            this.logUtil_TransformInfoHttpStore.putF(stringBuffer.toString(), this, "Constructor(HashMap, HashMap , PageContext)")
        }
        this.setStoreName(databaseHashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String])
    }

    def this(storeFrontInterface : StoreFrontInterface, propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this(propertiesHashMap, pageContext, false, ())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_TransformInfoHttpStore.putF("Properties HashMap: " + propertiesHashMap.toString(), this, this.commonStrings.CONSTRUCTOR)
        }
        this.setStoreName(storeFrontInterface.getName())
    }

    //TWB - for Inserting transforms into database
    def this(propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this(propertiesHashMap, pageContext, true, ())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_TransformInfoHttpStore.putF("Properties HashMap: " + propertiesHashMap.toString(), this, this.commonStrings.CONSTRUCTOR)
        }
    }

    private def getPath() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(URLGLOBALS.getMainPath())
        stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
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

    //Needed for polyglot do not remove
    override def setStoreName(value : String) : Unit = {
        super.setStoreName(value)
    }

    //Needed for polyglot do not remove
    override def getStoreName() : String = {
        return super.getStoreName()
    }

}


