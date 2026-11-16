/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.customizer.includes.style.theme

import _root_.org.allbinary.business.category.CategoryFactoryInterface
import _root_.org.allbinary.business.category.CategoryInterface
import _root_.org.allbinary.business.category.store.theme.StoreThemeCategoryFactory
import _root_.org.allbinary.business.category.store.theme.StoreThemeCategoryInterface
import _root_.org.allbinary.business.category.store.theme.StoreThemeCategoryPathValidationView
import _root_.org.allbinary.data.tree.category.CategoryLoaderFactory
import _root_.org.allbinary.data.tree.category.CategoryLoaderInterface
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.validate.ValidationComponentInterface
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class EditThemeValidationView(param_transformInfoInterface : TransformInfoInterface) extends ThemeCustomizerView(param_transformInfoInterface) with ValidationComponentInterface {

    val logUtil_EditThemeValidationView : LogUtil = LogUtil.getInstance()

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            var isValid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            var categoryFactoryInterface : CategoryFactoryInterface = new StoreThemeCategoryFactory(this.getTransformInfoInterface())
            var categoryLoaderInterface : CategoryLoaderInterface = CategoryLoaderFactory.getInstance(categoryFactoryInterface)
            var rootStoreThemeCategoryInterface : StoreThemeCategoryInterface = categoryFactoryInterface.getRootInstance().asInstanceOf[StoreThemeCategoryInterface]
            var storeThemeCategoryInterface : StoreThemeCategoryInterface = categoryLoaderInterface.getAll(rootStoreThemeCategoryInterface.asInstanceOf[CategoryInterface]).asInstanceOf[StoreThemeCategoryInterface]
            this.validationInterface = new StoreThemeCategoryPathValidationView(storeThemeCategoryInterface.asInstanceOf[StoreThemeCategoryInterface])
            isValid = this.validationInterface.isValid()
            //categoryLoaderInterface.getDoc((CategoryInterface) rootStoreThemeCategoryInterface)
            var domNodeInterface : DomNodeInterface = this.validationInterface.asInstanceOf[DomNodeInterface]
            var document : Document = DomDocumentHelper.create()
            document.appendChild(domNodeInterface.toXmlNode(document))
            var documentString : String = XmlDocumentHelper.toString(document)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                this.logUtil_EditThemeValidationView.putF("Setting Data: " + documentString, this, this.commonStrings.CONSTRUCTOR)
            }
            this.getTransformInfoInterface().setData(documentString)
            return isValid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_EditThemeValidationView.put("Failed to validate", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(this.validationInterface.validationInfo())
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_EditThemeValidationView.put("Failed to generate validation error info", this, "validationInfo()", e)
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


