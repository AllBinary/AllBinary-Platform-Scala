/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.AbContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigInterface
import _root_.org.w3c.dom.Document
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionInterface

//Hack class should not exist
class TransformInfoBasic(param_storeFrontInterface : StoreFrontInterface, param_propertiesHashMap : HashMap[Object, Object], param_pageContext : PageContext) extends AbContext(param_propertiesHashMap, param_pageContext) with TransformInfoHttpInterface {

    private var storeFrontInterface : StoreFrontInterface = null

    //Constructor
    {
        val storeFrontInterface : StoreFrontInterface = param_storeFrontInterface
        val propertiesHashMap : HashMap[Object, Object] = param_propertiesHashMap
        val pageContext : PageContext = param_pageContext
        this.storeFrontInterface = storeFrontInterface
    }

    def getStoreName() : String = {
        return this.storeFrontInterface.getName()
    }

    def log() : String = {
        return commonStrings.NOT_IMPLEMENTED
    }

    def `override`(hashMap : HashMap[Object, Object]) : Unit = {
    }

    def getName() : String = {
        return null
    }

    def getObjectFile() : String = {
        return null
    }

    def getObject() : Object = {
        return null
    }

    def getObjectConfigInterface() : TransformInfoObjectConfigInterface = {
        return null
    }

    def setObjectConfigInterface(transformInfoObjectConfigInterface : TransformInfoObjectConfigInterface) : Unit = {
    }

    def getTemplateFilePath() : AbPath = {
        return null
    }

    def getTemplateFile() : String = {
        return null
    }

    def getTemplate() : String = {
        return null
    }

    def getDataFilePath() : AbPath = {
        return null
    }

    def getDataFile() : String = {
        return null
    }

    def getDataDocument() : Document = {
        throw new Exception(commonStrings.NOT_IMPLEMENTED)
    }

    def setName(value : String) : Unit = {
    }

    def setStoreName(value : String) : Unit = {
    }

    def setObjectFile(value : String) : Unit = {
    }

    def setObject(anyType : Object) : Unit = {
    }

    def setObjectConfigFile(value : String) : Unit = {
    }

    def setTemplateFile(value : String) : Unit = {
    }

    def setTemplate(value : String) : Unit = {
    }

    def setDataFile(value : String) : Unit = {
    }

    def setData(value : String) : Unit = {
    }

    def setChild() : Unit = {
    }

    def isChild() : Boolean = {
        return true
    }

    def getImportUriPath() : String = {
        return null
    }

    def setImportUriPath(importUriPath : String) : Unit = {
    }

    def getKey() : Object = {
        return null
    }

    def toVector() : BasicArrayList = {
        return null
    }

    def toHashMap() : HashMap[Object, Object] = {
        return null
    }

    //Needed for polyglot do not remove
    override def getWeblisketSession() : WeblisketSessionInterface = {
        return super.getWeblisketSession()
    }

    //Needed for polyglot do not remove
    override def getPageContext() : PageContext = {
        return super.getPageContext()
    }

    //Needed for polyglot do not remove
    override def getPropertiesHashMap() : HashMap[Object, Object] = {
        return super.getPropertiesHashMap()
    }

}


