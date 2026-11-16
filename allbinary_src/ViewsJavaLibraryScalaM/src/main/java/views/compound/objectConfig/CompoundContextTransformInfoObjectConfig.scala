/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.compound.objectConfig

import _root_.java.io.ByteArrayInputStream
import _root_.java.io.InputStream
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.document.DocumentToNode
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.regex.replace.Replace
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.visual.transform.TransformFactory
import _root_.org.allbinary.logic.visual.transform.TransformInterface
import _root_.org.allbinary.logic.visual.transform.info.RootTransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoData
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoDomNode
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.GenericStoreTransformInfoObjectConfig
import _root_.org.allbinary.string.CommonSeps
import _root_.org.w3c.dom.Document

class CompoundContextTransformInfoObjectConfig private (super_1 : AbeClientInformationInterface, super_2 : TransformInfoInterface, super_3 : String, super_4 : String, constructor_ : Unit) extends GenericStoreTransformInfoObjectConfig(super_1, super_2, super_3, super_4) {

    val logUtil_CompoundContextTransformInfoObjectConfig : LogUtil = LogUtil.getInstance()

    def this(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, name : String, `type` : String) = {
        this(abeClientInformation, transformInfoInterface, name, type, ())
        this.setDocument(this.generate(this.toXmlDoc()))
    }

    def this(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface, document : Document) = {
        this(abeClientInformation, transformInfoInterface, document, null, ())
        this.setDocument(this.generate(this.toXmlDoc()))
    }

    def this(abeClientInformation : AbeClientInformationInterface, transformInfoInterface : TransformInfoInterface) = {
        this(abeClientInformation, transformInfoInterface, null, null, ())
    }

    //returns the result of a compound view
    def get() : String = {
        var storeName : String = this.getTransformInfoInterface().getStoreName()
        //by itself unless it is using a objectconfig that specifies preview as the parent
        var httpTransformInfoInterface : TransformInfoHttpInterface = this.getTransformInfoInterface().asInstanceOf[TransformInfoHttpInterface]
        var templateNameOverride : String = StringUtil.getInstance().getNonNull(httpTransformInfoInterface.getPropertiesHashMap().get(TransformInfoData.getInstance().PARTIAL).asInstanceOf[String])
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(storeName)
        stringBuffer.append(templateNameOverride)
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(RootTransformInfoData.NAME)
        //get parent template 
        var rootComponentInterface : TransformInterface = TransformFactory.getInstance().getInstance(abeClientInformation, stringBuffer.toString(), this.getTransformInfoInterface())
        var viewVector : BasicArrayList = this.getTransformDomNodes()
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_CompoundContextTransformInfoObjectConfig.putF("Root View Called with: " + viewVector.size(), this, "get(transformInfoInterface)")
        }
        var rootView : String = rootComponentInterface.view()
        val startXMLHeader : String = "<xsl:text disable-output-escaping=\"yes\" ><![CDATA["
        val endXMLHeader : String = "]]></xsl:text>"
        //probably should be optimized
        val size : Int = viewVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var objectConfigTransformInfoDomNode : TransformInfoDomNode = viewVector.get(index).asInstanceOf[TransformInfoDomNode]
                var templateKey : String = objectConfigTransformInfoDomNode.getReplaceKey()
                var componentInterface : TransformInterface = TransformFactory.getInstance().getInstance(abeClientInformation, objectConfigTransformInfoDomNode.getTransformInfoInterface().getName(), this.getTransformInfoInterface())
                var replacementViewString : String = componentInterface.view()
                replacementViewString = DocumentToNode.convertDocumentToNodeString(replacementViewString)
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append(startXMLHeader)
                stringBuffer.append(replacementViewString)
                stringBuffer.append(endXMLHeader)
                var templateValue : String = stringBuffer.toString()
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append("Replacing: ")
                    stringBuffer.append(templateKey)
                    stringBuffer.append(" with ")
                    stringBuffer.append(templateValue)
                    this.logUtil_CompoundContextTransformInfoObjectConfig.putF(stringBuffer.toString(), this, "get()")
                }
                var replace : Replace = new Replace(templateKey, templateValue)
                rootView = replace.all(rootView)
                index += 1
            }
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_CompoundContextTransformInfoObjectConfig.putF("End: Result of a compound view: " + rootView, this, "get()")
        }
        return rootView
    }

    def createInputStream() : InputStream = {
        var completeTemplateViewBytes : Array[Byte] = this.get().getBytes()
        var bais : ByteArrayInputStream = new ByteArrayInputStream(completeTemplateViewBytes)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_CompoundContextTransformInfoObjectConfig.putF("Template: " + new String(completeTemplateViewBytes).toString(), this, "createInputStream()")
        }
        return bais
    }

}


