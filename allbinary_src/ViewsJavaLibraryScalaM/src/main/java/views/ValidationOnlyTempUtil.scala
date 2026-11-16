/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

//Replace when validation node is added
class ValidationOnlyTempUtil private() {
    import _root_.views.ValidationOnlyTempUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //TWB hack for no store in session for a new store
    def view(validationComponentInterface : ValidationComponentInterface) : String = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("View Name: " + validationComponentInterface.getTransformInfoInterface().getName(), this, "view()")
            }
            /*          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().JSPEXTRAOUTPUT))          {             return validationComponentInterface.validationInfo();          } */
            return StringUtil.getInstance().EMPTY_STRING
        } catch {
            case e : Exception => {
                //String error = "Failed to view: " + validationComponentInterface.getTransformInfoInterface().getName();
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object ValidationOnlyTempUtil {
    private val instance : ValidationOnlyTempUtil = new ValidationOnlyTempUtil()

    def getInstance() : ValidationOnlyTempUtil = {
        return ValidationOnlyTempUtil.instance
    }

}


