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

class StoreTagWorkFlowFactory private() {
    import _root_.org.allbinary.logic.control.workflow.StoreTagWorkFlowFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(abeClientInformation : AbeClientInformationInterface, propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) : StoreWorkFlowInterface = {
        try {
            var workFlowClassName : String = propertiesHashMap.get(DynamicObjectData.NAME).asInstanceOf[String]
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("Creating WorkFlow: ")
                stringBuffer.append(workFlowClassName)
                stringBuffer.append("->")
                stringBuffer.append(StoreTagWorkFlowFactory.instance.getClass().getName())
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.putF(stringBuffer.toString(), this, commonStrings.GET_INSTANCE)
            }
            var params : Array[Object] = new Array[Object](2)
            var classes : Array[Class[?]] = new Array[Class[?]](2)
            //Add param types
            classes(0) = propertiesHashMap.getClass()
            classes(1) = AbeFactory.getInstance().getClass(abeClientInformation, "javax.servlet.jsp.PageContext")
            //Add arguments
            params(0) = propertiesHashMap.asInstanceOf[Object]
            params(1) = pageContext.asInstanceOf[Object]
            return AbeFactory.getInstance().getInstance(abeClientInformation, workFlowClassName, classes, params).asInstanceOf[StoreWorkFlowInterface]
        } catch {
            case e : LicensingException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    var workFlowClassName : String = propertiesHashMap.get(DynamicObjectData.NAME).asInstanceOf[String]
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Error Creating WorkFlow: ")
                    stringBuffer.append(workFlowClassName)
                    stringBuffer.append("->")
                    stringBuffer.append(StoreTagWorkFlowFactory.instance.getClass().getName())
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(stringBuffer.toString(), this, commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    var workFlowClassName : String = propertiesHashMap.get(DynamicObjectData.NAME).asInstanceOf[String]
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("Error Creating WorkFlow: ")
                    stringBuffer.append(workFlowClassName)
                    stringBuffer.append("->")
                    stringBuffer.append(StoreTagWorkFlowFactory.instance.getClass().getName())
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(stringBuffer.toString(), this, commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object StoreTagWorkFlowFactory {
    private val instance : StoreTagWorkFlowFactory = new StoreTagWorkFlowFactory()

    def getInstance() : StoreTagWorkFlowFactory = {
        return StoreTagWorkFlowFactory.instance
    }

}


