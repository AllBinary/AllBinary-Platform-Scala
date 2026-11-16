/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.system.security.licensing.AbeClientInformationInterface
import _root_.org.allbinary.logic.system.security.licensing.ServiceClientInformationInterfaceFactory
import _root_.org.allbinary.logic.visual.transform.TransformFactory
import _root_.org.allbinary.logic.visual.transform.TransformInterface
import _root_.org.allbinary.logic.visual.transform.data.TransformDocumentInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document

class ViewHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends TransformInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val abeClientInformation : AbeClientInformationInterface = ServiceClientInformationInterfaceFactory.getInstance()

    private var componentInterface : TransformInterface = null

    var NO_TYPE : Int = 0

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        this.componentInterface = TransformFactory.getInstance().getInstance(this.abeClientInformation, hashMap, pageContext)
    }

    def getTypeId() : Int = {
        return this.NO_TYPE
    }

    def view() : String = {
        try {
            return this.componentInterface.view()
        } catch {
            case e : Exception => {
                var error : String = "Failed to View: "
                if (this.componentInterface != null) {
                    error += this.componentInterface.getClass().getName()
                } else {
                    error += "Unknown"
                }
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def toXmlDoc() : Document = {
        try {
            throw new Exception("Hmm: " + this.componentInterface.getTransformDocumentInterface().getDoc())
        } catch {
            case e : Exception => {
                var error : String = "Failed to View: "
                if (this.componentInterface != null) {
                    error += this.componentInterface.getClass().getName()
                } else {
                    error += "Unknown"
                }
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "view()", e)
                }
                throw e
            }
        }
        throw new IllegalStateException()
    }

    /*    protected PageContext getPageContext()    {       return this.pageContext;    } */
    def getViewObject() : TransformInterface = {
        return this.componentInterface
    }

    def getTransformInfoInterface() : TransformInfoInterface = {
        return this.componentInterface.getTransformInfoInterface()
    }

    def getTransformDocumentInterface() : TransformDocumentInterface = {
        return null
    }

    def setTransformDocumentInterface(viewDocumentInterface : TransformDocumentInterface) : Unit = {
        return
    }

}


