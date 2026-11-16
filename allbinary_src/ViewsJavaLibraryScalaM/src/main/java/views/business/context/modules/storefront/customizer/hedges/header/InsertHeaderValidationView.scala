/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.customizer.hedges.header

import _root_.java.util.HashMap
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.http.request.MultipartRequestParams
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.template.customizer.hedges.heading.HeadingValidation
import _root_.org.allbinary.logic.visual.transform.template.customizer.widgets.logo.LogoData
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.views.business.context.modules.storefront.customizer.CustomizerUtil

class InsertHeaderValidationView(param_transformInfoInterface : TransformInfoInterface) extends TopBarView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_InsertHeaderValidationView : LogUtil = LogUtil.getInstance()

    private val LOGOPATH : String = "logo/"

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        var multipartRequestHashMap : HashMap[Object, Object] = new MultipartRequestParams(this.getPageContext()).toHashMap().asInstanceOf[HashMap[Object, Object]]
        /*             HashMap multipartRequestHashMap = (HashMap)          this.getTransformInfoInterface().getPropertiesHashMap().get(             MultipartRequestParamsData.HASHMAP); */
        var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getWeblisketSession().getStoreName())
        var fullPath : String = (URLGLOBALS.getWebappPath() + storeFrontInterface.getCurrentHostNamePath()) + this.LOGOPATH
        multipartRequestHashMap.put(LogoData.getInstance().IMAGEPATH, fullPath)
        this.heading = new HeadingValidation(multipartRequestHashMap)
    }

    override def toXmlDoc() : Document = {
        return null
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_InsertHeaderValidationView.putF("topbarValidation", this, this.commonStrings.IS_VALID)
            }
            var isValid : _root_.java.lang.Boolean = this.heading.isValid()
            if (isValid == _root_.java.lang.Boolean.TRUE) {
                //Insert XML into the view specified by the Object Config for this view
                CustomizerUtil.getInstance().insert(this.getTransformInfoInterface(), this.asInstanceOf[DomNodeInterface])
            }
            return isValid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_InsertHeaderValidationView.put("Failed to validate", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.heading.validationInfo())
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_InsertHeaderValidationView.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Getting Validation Info"
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

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


