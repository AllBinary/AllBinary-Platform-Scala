/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.workflow

import _root_.java.util.HashMap
import _root_.org.allbinary.business.DynamicObjectData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.loader.AbeFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.string.CommonStrings

class DbWorkFlowFactory private() {
    import _root_.org.allbinary.logic.control.workflow.DbWorkFlowFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //Created from DB data
    def getInstance(abeClientInformation : AbeClientInformationInterface, hashMap : HashMap[Object, Object]) : WorkFlowInterface = {
        try {
            val className : String = hashMap.get(DynamicObjectData.NAME).asInstanceOf[String]
            //final String workFlowName = (String) hashMap.get(WorkFlowData.getInstance().NAME);
            val params : Array[Object] = new Array[Object](1)
            val classes : Array[Class[?]] = new Array[Class[?]](1)
            //Add param types
            classes(0) = hashMap.getClass()
            //Add arguments
            params(0) = hashMap.asInstanceOf[Object]
            val anyType : Object = AbeFactory.getInstance().getInstance(abeClientInformation, className, classes, params)
            return (new WorkFlowWrapper(anyType)).asInstanceOf[WorkFlowInterface]
        } catch {
            case e : LicensingException => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    //String error = "Failed To Get Instance Args: HashMap=" + hashMap.toString();
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

}

object DbWorkFlowFactory {
    private val instance : DbWorkFlowFactory = new DbWorkFlowFactory()

    def getInstance() : DbWorkFlowFactory = {
        return DbWorkFlowFactory.instance
    }

}


