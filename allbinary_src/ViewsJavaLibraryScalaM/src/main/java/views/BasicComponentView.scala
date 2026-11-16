/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views

import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory
import _root_.org.allbinary.logic.visual.transform.BasicTransformer
import _root_.org.allbinary.logic.visual.transform.TransformInterface
import _root_.org.allbinary.logic.visual.transform.data.TransformDocumentFactory
import _root_.org.allbinary.logic.visual.transform.data.TransformDocumentInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class BasicComponentView(param_transformInfoInterface : TransformInfoInterface) extends TransformInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var transformDocumentInterface : TransformDocumentInterface = null

    private var transformInfoInterface : TransformInfoInterface = null

    var NO_TYPE : Int = 0

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil.putF("View Name: " + transformInfoInterface.getName(), this, this.commonStrings.CONSTRUCTOR)
        }
        this.setTransformInfoInterface(transformInfoInterface)
        this.setTransformDocumentInterface(TransformDocumentFactory.getInstance())
    }

    def getTypeId() : Int = {
        return this.NO_TYPE
    }

    def getTransformDocumentInterface() : TransformDocumentInterface = {
        return this.transformDocumentInterface
    }

    def setTransformDocumentInterface(transformDocumentInterface : TransformDocumentInterface) : Unit = {
        this.transformDocumentInterface = transformDocumentInterface
    }

    def getTransformInfoInterface() : TransformInfoInterface = {
        return this.transformInfoInterface
    }

    def setTransformInfoInterface(transformInfoInterface : TransformInfoInterface) : Unit = {
        this.transformInfoInterface = transformInfoInterface
    }

    def toXmlDoc() : Document = {
        return this.transformDocumentInterface.getDoc()
    }

    def getDoc() : Document = {
        var document : Document = this.getTransformInfoInterface().getDataDocument()
        var dataNode : Node = this.getTransformDocumentInterface().getDoc().importNode(document.getFirstChild(), true)
        if (dataNode != null) {
            this.getTransformDocumentInterface().getBaseNode().appendChild(dataNode)
        }
        return this.getTransformDocumentInterface().getDoc()
    }

    def view() : String = {
        try {
            var success : String = XmlDocumentHelper.toString(this.getDoc())
            var result : String = new BasicTransformer(this.abeClientInformation, this.getTransformInfoInterface()).translate(success)
            return result
        } catch {
            case e : Exception => {
                //String error = "Failed to Component view";
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

}


