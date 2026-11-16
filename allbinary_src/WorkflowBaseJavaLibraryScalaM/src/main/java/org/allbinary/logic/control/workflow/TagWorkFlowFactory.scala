/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.workflow

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.DynamicObjectData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.loader.AbeFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.string.CommonStrings

class TagWorkFlowFactory private() {
    import _root_.org.allbinary.logic.control.workflow.TagWorkFlowFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(abeClientInformation : AbeClientInformationInterface, propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) : WorkFlowInterface = {
        try {
            val workFlowClassName : String = propertiesHashMap.get(DynamicObjectData.NAME).asInstanceOf[String]
            val params : Array[Object] = new Array[Object](2)
            val classes : Array[Class[?]] = new Array[Class[?]](2)
            //Add param types
            classes(0) = propertiesHashMap.getClass()
            classes(1) = AbeFactory.getInstance().getClass(abeClientInformation, "javax.servlet.jsp.PageContext")
            //Add arguments
            params(0) = propertiesHashMap.asInstanceOf[Object]
            params(1) = pageContext.asInstanceOf[Object]
            return AbeFactory.getInstance().getInstance(abeClientInformation, workFlowClassName, classes, params).asInstanceOf[WorkFlowInterface]
        } catch {
            case e : LicensingException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val workFlowClassName : String = propertiesHashMap.get(DynamicObjectData.NAME).asInstanceOf[String]
                    val stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Failed To Get Instance: ")
                    stringBuffer.append(workFlowClassName)
                    stringBuffer.append("->")
                    stringBuffer.append(TagWorkFlowFactory.instance.getClass().getName())
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(stringBuffer.toString(), this, commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val workFlowClassName : String = propertiesHashMap.get(DynamicObjectData.NAME).asInstanceOf[String]
                    val stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Failed To Get Instance: ")
                    stringBuffer.append(workFlowClassName)
                    stringBuffer.append("->")
                    stringBuffer.append(TagWorkFlowFactory.instance.getClass().getName())
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(stringBuffer.toString(), this, commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object TagWorkFlowFactory {
    private val instance : TagWorkFlowFactory = new TagWorkFlowFactory()

    def getInstance() : TagWorkFlowFactory = {
        return TagWorkFlowFactory.instance
    }

}


