/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory
import _root_.org.allbinary.logic.visual.transform.BasicTransformer
import _root_.org.allbinary.logic.visual.transform.TransformInterface
import _root_.org.allbinary.logic.visual.transform.data.TransformDocumentInterface
import _root_.org.allbinary.logic.visual.transform.data.TransformHttpRequestDocumentFactory
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpComposite
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class HttpComponentView(param_transformInfoInterface : TransformInfoInterface) extends TransformInfoHttpComposite(param_transformInfoInterface) with TransformInterface {

    val logUtil_HttpComponentView : LogUtil = LogUtil.getInstance()

    val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var domNodeInterfaceVector : BasicArrayList = null

    private var transformDocumentInterface : TransformDocumentInterface = null

    var NO_TYPE : Int = 0

    //Constructor
    {
        val transformInfoInterface : TransformInfoInterface = param_transformInfoInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
            this.logUtil_HttpComponentView.putF("View Name: " + transformInfoInterface.getName(), this, this.commonStrings.CONSTRUCTOR)
        }
        this.domNodeInterfaceVector = new BasicArrayListD()
        this.setTransformDocumentInterface(TransformHttpRequestDocumentFactory.getInstance(this.getPageContext(), this.getWeblisketSession()))
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

    def addDomNodeInterface(domNodeInterface : DomNodeInterface) : Unit = {
        this.domNodeInterfaceVector.add(domNodeInterface)
    }

    def toXmlDoc() : Document = {
        try {
            val size : Int = this.domNodeInterfaceVector.size()

            {
                var index : Int = 0
                while (index < size) {
                    var domNodeInterface : DomNodeInterface = this.domNodeInterfaceVector.get(index).asInstanceOf[DomNodeInterface]
                    this.transformDocumentInterface.getBaseNode().appendChild(domNodeInterface.toXmlNode(this.transformDocumentInterface.getDoc()))
                    index += 1
                }
            }
            return this.getTransformDocumentInterface().getDoc()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil_HttpComponentView.put(this.commonStrings.EXCEPTION, this, "toXmlDoc()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def getDoc() : Document = {
        var document : Document = this.getTransformInfoInterface().getDataDocument()
        var node : Node = DomNodeHelper.getFirstChildElement(document)
        if (node != null) {
            var dataNode : Node = this.getTransformDocumentInterface().getDoc().importNode(node, true)
            if (dataNode != null) {
                this.getTransformDocumentInterface().getBaseNode().appendChild(dataNode)
            }
        }
        return this.getTransformDocumentInterface().getDoc()
    }

    def view() : String = {
        try {
            this.toXmlDoc()
            var success : String = XmlDocumentHelper.toString(this.getDoc())
            var result : String = new BasicTransformer(this.abeClientInformation, this.getTransformInfoInterface()).translate(success)
            return result
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil_HttpComponentView.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    //Needed for polyglot do not remove
    override def getTransformInfoInterface() : TransformInfoInterface = {
        return super.getTransformInfoInterface()
    }

}


