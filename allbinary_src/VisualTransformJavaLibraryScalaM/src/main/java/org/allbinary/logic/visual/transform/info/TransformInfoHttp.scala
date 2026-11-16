/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.AbContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.http.request.RequestParams
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlData
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfig

class TransformInfoHttp private () extends TransformInfo with TransformInfoHttpInterface {

    val logUtil_TransformInfoHttp : LogUtil = LogUtil.getInstance()

    private var abContext : AbContext = null

    //TWB - for inserting transforms into database
    def this(propertiesHashMap : HashMap[Object, Object], pageContext : PageContext, crud : Boolean) = {
        this()
        this.abContext = new AbContext(propertiesHashMap, pageContext)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_TransformInfoHttp.putF("Properties HashMap: " + propertiesHashMap.toString(), this, "Constructor(HashMap, PageContext, boolean)")
        }
        this.`override`(propertiesHashMap)
    }

    def this(request : HttpServletRequest, propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this()
        this.abContext = new AbContext(propertiesHashMap, pageContext)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_TransformInfoHttp.putF("Properties HashMap: " + propertiesHashMap.toString(), this, "Constructor(HttpServletRequest, HashMap, PageContext)")
        }
        this.set(new RequestParams(request.asInstanceOf[HttpServletRequest]).toHashMap())
        this.`override`(propertiesHashMap)
    }

    def this(databaseHashMap : HashMap[Object, Object], propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this()
        this.abContext = new AbContext(propertiesHashMap, pageContext)
        //super(propertiesHashMap, pageContext);
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_TransformInfoHttp.putF("Properties HashMap: " + propertiesHashMap.toString(), this, "Constructor(HashMap, HashMap, PageContext)")
        }
        this.set(databaseHashMap)
    }

    def this(propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this()
        this.abContext = new AbContext(propertiesHashMap, pageContext)
        //super(propertiesHashMap, pageContext);
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_TransformInfoHttp.putF("Properties HashMap: " + propertiesHashMap.toString(), this, "Constructor(HashMap, PageContext)")
        }
        this.set(propertiesHashMap)
    }

    def this(parentViewOfThisTransformInfoInterface : TransformInfoHttp) = {
        this()
        this.abContext = new AbContext(parentViewOfThisTransformInfoInterface.getPropertiesHashMap(), parentViewOfThisTransformInfoInterface.getPageContext())
    }

    private def set(hashMap : HashMap[Object, Object]) : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_TransformInfoHttp.putF("Properties HashMap: " + hashMap.toString(), this, "set()")
        }
        var transformInfoData : TransformInfoData = TransformInfoData.getInstance()
        this.setName(hashMap.get(transformInfoData.NAME).asInstanceOf[String])
        this.setStoreName(hashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String])
        this.setObjectFile(hashMap.get(transformInfoData.OBJECTFILENAME).asInstanceOf[String])
        this.setObject(hashMap.get(transformInfoData.OBJECT).asInstanceOf[String])
        var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        var objectConfigString : String = hashMap.get(transformInfoData.OBJECTCONFIG).asInstanceOf[String]
        if (stringValidationUtil.isValidRequired(objectConfigString, 10, AbSqlData.MAXBLOB)) {
            this.setObjectConfig(objectConfigString)
        } else {
            this.setObjectConfig(new TransformInfoObjectConfig(this).toString())
        }
        if (!stringValidationUtil.isEmpty(hashMap.get(transformInfoData.OBJECTCONFIGFILENAME).asInstanceOf[String])) {
            this.setObjectConfigFile(hashMap.get(transformInfoData.OBJECTCONFIGFILENAME).asInstanceOf[String])
        }
        this.setTemplateFile(hashMap.get(transformInfoData.TEMPLATEFILENAME).asInstanceOf[String])
        this.setTemplate(hashMap.get(transformInfoData.TEMPLATE).asInstanceOf[String])
        this.setDataFile(hashMap.get(transformInfoData.DATAFILENAME).asInstanceOf[String])
        this.setData(hashMap.get(transformInfoData.DATA).asInstanceOf[String])
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
            this.logUtil_TransformInfoHttp.putF(this.log(), this, "set()")
        }
    }

    def getWeblisketSession() : WeblisketSessionInterface = {
        return this.abContext.getWeblisketSession()
    }

    def getPageContext() : PageContext = {
        return this.abContext.getPageContext()
    }

    def getPropertiesHashMap() : HashMap[Object, Object] = {
        return this.abContext.getPropertiesHashMap()
    }

    override def getTemplateFilePath() : AbPath = {
        return new AbPath(URLGLOBALS.getMainPath() + FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH, this.getTemplateFile())
    }

    override def getObjectConfigFilePath() : AbPath = {
        return new AbPath(URLGLOBALS.getMainPath() + FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH, this.getObjectConfigFile())
    }

    override def getDataFilePath() : AbPath = {
        return new AbPath(URLGLOBALS.getMainPath() + FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH, this.getDataFile())
    }

}


