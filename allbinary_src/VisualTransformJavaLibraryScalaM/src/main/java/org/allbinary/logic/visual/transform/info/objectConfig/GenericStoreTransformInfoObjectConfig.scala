/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.objectConfig

import _root_.java.util.HashMap
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.regex.replace.Replace
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.info.RootTransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttp
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.template.TransformTemplateFactory
import _root_.org.allbinary.logic.visual.transform.template.TransformTemplateInterface
import _root_.org.allbinary.logic.visual.transform.template.util.TransformTemplateCustomizerUtil
import _root_.org.allbinary.string.CommonSeps
import _root_.org.w3c.dom.Document

class GenericStoreTransformInfoObjectConfig private (super_1 : TransformInfoInterface, super_2 : String, super_3 : String, constructor_ : Unit) extends TransformInfoObjectConfig(super_1, super_2, super_3) {

    val logUtil_GenericStoreTransformInfoObjectConfig : LogUtil = LogUtil.getInstance()

    var abeClientInformation : AbeClientInformationInterface = null

    def this(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, name : String, `type` : String) = {
        this(transformInfoInterface, name, type, ())
        this.abeClientInformation = abeClientInformation
        this.setDocument(this.generate(this.toXmlDoc()))
    }

    def this(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, document : Document) = {
        this(transformInfoInterface, document, null, ())
        this.abeClientInformation = abeClientInformation
        this.setDocument(this.generate(this.toXmlDoc()))
    }

    def this(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface) = {
        this(transformInfoInterface, null, null, ())
        this.abeClientInformation = abeClientInformation
    }

    //private final int HACK = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx".length();
    def generate(objectConfigDocument : Document) : Document = {
        //final String docString = XmlDocumentHelper.toString(objectConfigDocument);
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            var stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append("TransformInfo: ")
            if (this.getTransformInfoInterface() != null) {
                stringBuffer.append(this.getTransformInfoInterface().getName())
            } else {
                stringBuffer.append("No Owner!?#@")
            }
            //stringBuffer.append(docString);
            this.logUtil_GenericStoreTransformInfoObjectConfig.putF(stringBuffer.toString(), this, "generate()")
        }
        //(TransformInfoHttpStore)
        val transformInfoHttpStoreInterface : TransformInfoHttp = this.getTransformInfoInterface().asInstanceOf[TransformInfoHttp]
        val objectConfigDocumentString : String = XmlDocumentHelper.toString(objectConfigDocument)
        val replaceHashMap : HashMap[Object, Object] = this.createReplaceHashMap(transformInfoHttpStoreInterface, objectConfigDocumentString).asInstanceOf[HashMap[Object, Object]]
        return this.generate(objectConfigDocumentString, replaceHashMap)
    }

    private def createReplaceHashMap(transformInfoHttpStoreInterface : TransformInfoHttp, objectConfigDocumentString : String) : HashMap[Object, Object] = {
        var storeName : String = transformInfoHttpStoreInterface.getStoreName()
        //String viewName = this.getTransformInfoInterface().getName();
        val hashMap : HashMap[Object, Object] = this.createHashMap(transformInfoHttpStoreInterface, objectConfigDocumentString).asInstanceOf[HashMap[Object, Object]]
        val transformInfoObjectConfigData : TransformInfoObjectConfigData = TransformInfoObjectConfigData.getInstance()
        hashMap.put(transformInfoObjectConfigData.VARKEY + StoreFrontData.getInstance().NAME, storeName)
        //created by objectconfigfactory or better yet use multiple objectconfig files
        val pageName : String = TransformTemplateCustomizerUtil.getInstance().getPageNameHack(this.getTransformInfoInterface().getName(), storeName)
        hashMap.put(transformInfoObjectConfigData.VARKEY + TransformInfoData.getInstance().PARTIAL, pageName)
        return hashMap
    }

    //could cause infinite loop is templateNameKey is in root objectconfig
    private def createHashMap(transformInfoHttpStoreInterface : TransformInfoHttp, objectConfigDocumentString : String) : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        var storeName : String = transformInfoHttpStoreInterface.getStoreName()
        //by itself unless it is using a objectconfig that specifies preview as the parent
        var propertiesHashMap : HashMap[Object, Object] = transformInfoHttpStoreInterface.getPropertiesHashMap().asInstanceOf[HashMap[Object, Object]]
        var templateNameOverride : String = StringUtil.getInstance().getNonNull(propertiesHashMap.get(TransformInfoData.getInstance().PARTIAL).asInstanceOf[String])
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_GenericStoreTransformInfoObjectConfig.putF("TemplateNameOverride: " + templateNameOverride, this, "generate()")
        }
        var templateNameStringBuffer : StringMaker = new StringMaker()
        templateNameStringBuffer.append(storeName)
        templateNameStringBuffer.append(templateNameOverride)
        templateNameStringBuffer.append(CommonSeps.getInstance().SPACE)
        templateNameStringBuffer.append(RootTransformInfoData.NAME)
        var templateNameKey : String = TransformInfoObjectConfigData.getInstance().VARKEY + TransformInfoData.getInstance().OWNER
        if (objectConfigDocumentString.indexOf(templateNameKey) != -1) {
            var templateInterface : TransformTemplateInterface = TransformTemplateFactory.getInstance().getInstance(this.abeClientInformation, templateNameStringBuffer.toString(), transformInfoHttpStoreInterface.getPropertiesHashMap(), transformInfoHttpStoreInterface.getPageContext())
            var selectedTemplate : String = templateInterface.getName()
            hashMap.put(templateNameKey, selectedTemplate)
        }
        return hashMap
    }

    private def generate(objectConfigDocumentString : String, hashMap : HashMap[Object, Object]) : Document = {
        var replace : Replace = new Replace(hashMap)
        var newObjectConfigDocument : Document = DomDocumentHelper.create(replace.all(objectConfigDocumentString))
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_GenericStoreTransformInfoObjectConfig.putF("Final ObjectConfig: " + XmlDocumentHelper.toString(newObjectConfigDocument), this, "generate()")
        }
        return newObjectConfigDocument
    }

}


