/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.customizer.template.objectConfig

import _root_.java.util.HashMap
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.regex.replace.Replace
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfig
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigData
import _root_.org.allbinary.logic.visual.transform.template.util.TransformTemplateCustomizerUtil
import _root_.org.w3c.dom.Document

class NoTemplateTransformInfoObjectConfig private (super_1 : TransformInfoInterface, super_2 : String, super_3 : String, constructor_ : Unit) extends TransformInfoObjectConfig(super_1, super_2, super_3) {

    val logUtil_NoTemplateTransformInfoObjectConfig : LogUtil = LogUtil.getInstance()

    def this(transformInfoInterface : TransformInfoInterface, name : String, `type` : String) = {
        this(transformInfoInterface, name, type, ())
        this.setDocument(this.generate(this.toXmlDoc()))
    }

    def this(transformInfoInterface : TransformInfoInterface, document : Document) = {
        this(transformInfoInterface, document, null, ())
        this.setDocument(this.generate(this.toXmlDoc()))
    }

    def this(transformInfoInterface : TransformInfoInterface) = {
        this(transformInfoInterface, null, null, ())
    }

    def generate(objectConfigDocument : Document) : Document = {
        var docString : String = XmlDocumentHelper.toString(objectConfigDocument)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_NoTemplateTransformInfoObjectConfig.putF("Initial ObjectConfig: " + docString, this, "generate()")
        }
        var storeName : String = this.getTransformInfoInterface().getStoreName()
        var viewName : String = this.getTransformInfoInterface().getName()
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        val VARKEY : String = TransformInfoObjectConfigData.getInstance().VARKEY
        hashMap.put(VARKEY + StoreFrontData.getInstance().NAME, storeName)
        hashMap.put(VARKEY + TransformInfoData.getInstance().OWNER, viewName)
        //created by objectconfigfactory or better yet use multiple objectconfig files
        var pageName : String = TransformTemplateCustomizerUtil.getInstance().getPageNameHack(this.getTransformInfoInterface().getName(), this.getTransformInfoInterface().getStoreName())
        hashMap.put(VARKEY + TransformInfoData.getInstance().PARTIAL, pageName)
        var replace : Replace = new Replace(hashMap)
        var newObjectConfigDocument : Document = DomDocumentHelper.create(replace.all(docString))
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_NoTemplateTransformInfoObjectConfig.putF("Final ObjectConfig: " + XmlDocumentHelper.toString(newObjectConfigDocument), this, "generate()")
        }
        return newObjectConfigDocument
    }

}


