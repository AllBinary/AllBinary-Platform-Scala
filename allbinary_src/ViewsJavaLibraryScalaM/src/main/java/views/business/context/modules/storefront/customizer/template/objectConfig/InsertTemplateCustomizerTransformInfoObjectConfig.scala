/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.business.context.modules.storefront.customizer.template.objectConfig

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoDomNodeView
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfosData
import _root_.org.allbinary.logic.visual.transform.info.objectConfig.TransformInfoObjectConfigData
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class InsertTemplateCustomizerTransformInfoObjectConfig private (super_1 : TransformInfoInterface, super_2 : String, super_3 : String, constructor_ : Unit) extends NoTemplateTransformInfoObjectConfig(super_1, super_2, super_3) {

    val logUtil_InsertTemplateCustomizerTransformInfoObjectConfig : LogUtil = LogUtil.getInstance()

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

    //set root component that is the template
    def set(aParentViewName : String) : Unit = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_InsertTemplateCustomizerTransformInfoObjectConfig.putF("Setting: " + aParentViewName, this, "set()")
        }
        var document : Document = this.toXmlDoc()
        var parentComponentsNodeList : NodeList = document.getElementsByTagName(TransformInfosData.getInstance().NAME)
        if ((parentComponentsNodeList != null) && (parentComponentsNodeList.getLength() > 0)) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_InsertTemplateCustomizerTransformInfoObjectConfig.putF("Replacing", this, "set()")
            }
            var componentNode : Node = parentComponentsNodeList.item(0).getChildNodes().item(0)
            if (componentNode != null) {
                document.removeChild(componentNode)
            }
            parentComponentsNodeList.item(0).appendChild(new TransformInfoDomNodeView(aParentViewName).toXmlNode(document))
        } else {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil_InsertTemplateCustomizerTransformInfoObjectConfig.putF("Setting", this, "set()")
            }
            var objectConfigNode : Node = document.getElementsByTagName(TransformInfoObjectConfigData.getInstance().NAME).item(0)
            var parentComponentsNode : Node = document.createElement(TransformInfosData.getInstance().NAME)
            objectConfigNode.appendChild(parentComponentsNode)
            var transformInfoDomNodeView : TransformInfoDomNodeView = new TransformInfoDomNodeView(aParentViewName)
            parentComponentsNode.appendChild(transformInfoDomNodeView.toXmlNode(document))
        }
    }

}


