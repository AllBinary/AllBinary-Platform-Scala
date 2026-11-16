/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.workflow

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.DynamicObjectData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.system.loader.AbeFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.string.CommonStrings

class NewWorkFlowFactory private() {
    import _root_.org.allbinary.logic.control.workflow.NewWorkFlowFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //hashMap is for Tag properties that may override request data
    def getInstance(abeClientInformation : AbeClientInformationInterface, hashMap : HashMap[Object, Object], pageContext : PageContext) : WorkFlowInterface = {
        try {
            val className : String = hashMap.get(DynamicObjectData.NAME).asInstanceOf[String]
            //final String workFlowName = (String) hashMap.get(WorkFlowData.getInstance().NAME);
            val params : Array[Object] = new Array[Object](2)
            val classes : Array[Class[?]] = new Array[Class[?]](2)
            //Add param types
            classes(0) = hashMap.getClass()
            classes(1) = AbeFactory.getInstance().getClass(abeClientInformation, "javax.servlet.jsp.PageContext")
            //Add arguments
            params(0) = hashMap.asInstanceOf[Object]
            params(1) = pageContext.asInstanceOf[Object]
            val anyType : Object = AbeFactory.getInstance().getInstance(abeClientInformation, className, classes, params)
            return (new WorkFlowWrapper(anyType)).asInstanceOf[WorkFlowInterface]
        } catch {
            case e : LicensingException => {
                //String error = "Failed To Get Instance Args: HashMap=" + hashMap.toString();
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, "getInstance(HashMap)", e)
                }
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, "getInstance(HashMap)", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    //For creating a new empty workflow
    def getInstance(abeClientInformation : AbeClientInformationInterface, className : String) : WorkFlowInterface = {
        try {
            val stringUtil : StringUtil = StringUtil.getInstance()
            if ((className != null) && (className.compareTo(stringUtil.EMPTY_STRING) != 0)) {
                val anyType : Object = AbeFactory.getInstance().getInstance(abeClientInformation, className, null, null)
                return (new WorkFlowWrapper(anyType)).asInstanceOf[WorkFlowInterface]
            } else {
                throw new Exception("No WorkFlow ClassName")
            }
        } catch {
            case e : LicensingException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object NewWorkFlowFactory {
    private val instance : NewWorkFlowFactory = new NewWorkFlowFactory()

    def getInstance() : NewWorkFlowFactory = {
        return NewWorkFlowFactory.instance
    }

}


