/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.properties

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class CategoryPropertiesValidationView(param_categoryPropertiesInterface : CategoryPropertiesInterface) extends CategoryPropertiesView(param_categoryPropertiesInterface) with ValidationInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val categoryPropertiesInterface : CategoryPropertiesInterface = param_categoryPropertiesInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        return this.categoryPropertiesInterface.isValid()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.categoryPropertiesInterface.validationInfo())
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put("Failed to generate validation info error", this, "validationInfo()", e)
                }
                return "Error Validating Data"
            }
        }
        throw new IllegalStateException()
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

}


