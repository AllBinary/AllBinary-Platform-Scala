/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.workflow.request

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.RequestParams
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSession
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.workflow.WorkFlowData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

/*  *This basic workflow is the workflow representation for the workflow Dom  *in a workflow entry.  *  */
class BasicWorkFlow() {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var workFlowDoc : Document = null

    private var workFlowName : String = null

    private var storeName : String = null

    //create a new empty workflow
    //Constructor
    {
        this.workFlowName = StringUtil.getInstance().EMPTY_STRING
        this.workFlowDoc = DomDocumentHelper.create()
        var workFlowNode : Node = this.workFlowDoc.createElement(WorkFlowData.getInstance().WORKFLOW)
        this.workFlowDoc.appendChild(workFlowNode)
    }

    //used for creating or updating a workflow
    def this(hashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this()
        var weblisketSession : WeblisketSession = new WeblisketSession(hashMap, pageContext)
        this.storeName = weblisketSession.getStoreName()
        var requestHashMap : HashMap[Object, Object] = new RequestParams(pageContext).toHashMap().asInstanceOf[HashMap[Object, Object]]
        this.workFlowName = requestHashMap.get(WorkFlowData.getInstance().NAME).asInstanceOf[String]
        this.workFlowDoc = DomDocumentHelper.create(requestHashMap.get(WorkFlowData.getInstance().DATA).asInstanceOf[String])
    }

    //Used by user request and for validating a delete, edit, and/or view
    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.workFlowName = hashMap.get(WorkFlowData.getInstance().NAME).asInstanceOf[String]
        this.storeName = hashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String]
        this.workFlowDoc = DomDocumentHelper.create(hashMap.get(WorkFlowData.getInstance().DATA).asInstanceOf[String])
    }

    def getName() : String = {
        return this.workFlowName
    }

    def getStoreName() : String = {
        return this.storeName
    }

    /*    public  process()    {       try       {          //BasicWorkFlow          return "Name: " + this.workFlowName + "<br />Data: " + DomHelper.toString(this.workFlowDoc);       }       catch(Exception e)       {          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLTAGSERROR))          {             LogUtil.put(commonStrings.EXCEPTION,this,commonStrings.PROCESS,e);          }          return null;       }    } */
    def getKey() : Object = {
        return this.getName().asInstanceOf[Object]
    }

    def toVector() : BasicArrayList = {
        var values : BasicArrayList = new BasicArrayListD()
        values.add(this.workFlowName)
        values.add(this.storeName)
        values.add(XmlDocumentHelper.toString(this.workFlowDoc))
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
        values.add(time)
        values.add(time)
        return values
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(WorkFlowData.getInstance().NAME, this.workFlowName)
        hashMap.put(StoreFrontData.getInstance().NAME, this.storeName)
        hashMap.put(WorkFlowData.getInstance().DATA, XmlDocumentHelper.toString(this.workFlowDoc))
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
        hashMap.put(EntryData.getInstance().LASTMODIFIED, time)
        return hashMap
    }

    //This returns a node for the view and not the
    def toXmlNode(document : Document) : Node = {
        try {
            var hashMap : HashMap[Object, Object] = this.toHashMap().asInstanceOf[HashMap[Object, Object]]
            var keySet : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
            var node : Node = document.createElement(WorkFlowData.getInstance().WORKFLOW)
            val nameArray : Array[Object] = keySet.toArray()
            val size : Int = nameArray.length

            {
                var index : Int = 0
                while (index < size) {
                    var name : String = nameArray(index).asInstanceOf[String]
                    var value : String = hashMap.get(name).asInstanceOf[String]
                    node.appendChild(ModDomHelper.createNameValueNodes(document, name, value))
                    index += 1
                }
            }
            return node
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "toXmlNode()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    def toXmlDoc() : Document = {
        try {
            return this.workFlowDoc
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "toXmlDoc()", e)
                }
                return null
            }
        }
        throw new IllegalStateException()
    }

    /*    public String view()    {       try       {          return stringUtil.EMPTY_STRING;       }       catch(Exception e)       {          String error = "Failed to view WorkFlow";          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().TAGHELPERERROR))          {             LogUtil.put(this.commonStrings.EXCEPTION,this,"view()",e);          }          return error;       }    }    */
    def isValid() : _root_.java.lang.Boolean = {
        try {
            var returnBoolean : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (this.workFlowName == null) {
                returnBoolean = _root_.java.lang.Boolean.FALSE
            }
            return returnBoolean
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put("Failed to validate", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            if (this.workFlowName == null) {
                stringBuffer.append("No WorkFlow name specified.")
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
                    this.logUtil.put("Failed to generate validation error info", this, "validationInfo()", e)
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

}


