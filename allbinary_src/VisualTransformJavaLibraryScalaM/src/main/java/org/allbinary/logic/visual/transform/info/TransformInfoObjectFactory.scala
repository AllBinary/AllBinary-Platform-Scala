/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.system.loader.AbeFactory
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.org.allbinary.logic.visual.transform.TransformInterface
import _root_.org.allbinary.string.CommonStrings

class TransformInfoObjectFactory private() {
    import _root_.org.allbinary.logic.visual.transform.info.TransformInfoObjectFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def getInstance(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface) : TransformInterface = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORY)) {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.putF("Creating View: " + transformInfoInterface.getName(), this, commonStrings.GET_INSTANCE)
            }
            //validate view data before creating view object
            var params : Array[Object] = new Array[Object](1)
            var classes : Array[Class[?]] = new Array[Class[?]](1)
            //TWB - Moved to obf on everything that is no bolted to dynamic loading
            classes(0) = classOf[TransformInfoInterface]
            //Add arguments
            params(0) = transformInfoInterface.asInstanceOf[Object]
            val anyType : TransformInterface = AbeFactory.getInstance().getInstance(abeClientInformation, transformInfoInterface.getObjectFile(), classes, params).asInstanceOf[TransformInterface]
            if (anyType == null) {
                if (transformInfoInterface != null) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append("\nNo Such View Name: ")
                    stringBuffer.append(transformInfoInterface.getName())
                    stringBuffer.append("\nNo Such View Object: ")
                    stringBuffer.append(transformInfoInterface.getObjectFile())
                    throw new Exception(stringBuffer.toString())
                } else {
                    throw new Exception("No Such View Object since transformInfo is null")
                }
            }
            return anyType
        } catch {
            case e : LicensingException => {
                var error : String = "Failed To Get Instance: "
                if (transformInfoInterface != null) {
                    error = error + transformInfoInterface.getName()
                }
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(error, this, commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
            case e : Exception => {
                var error : String = "Failed To Get Instance: "
                if (transformInfoInterface != null) {
                    error = error + transformInfoInterface.getName()
                }
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERFACTORYERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put(error, this, commonStrings.GET_INSTANCE, e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object TransformInfoObjectFactory {
    private val instance : TransformInfoObjectFactory = new TransformInfoObjectFactory()

    def getInstance() : TransformInfoObjectFactory = {
        return TransformInfoObjectFactory.instance
    }

}


