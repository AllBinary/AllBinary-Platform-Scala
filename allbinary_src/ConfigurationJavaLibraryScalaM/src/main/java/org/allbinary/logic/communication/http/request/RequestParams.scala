/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.request

import _root_.java.util.HashMap
import _root_.java.util.Map
import _root_.java.util.Set
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

//Note: if request is destroyed or messed up this will not work. Use fileRequestParams
class RequestParams() {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var map : Map[Object, Object] = null

    private val KEY : String = "Key: "

    private val VALUE : String = " Value: "

    //Constructor
    {
        this.logUtil.putF("New RequestParams Size: 0", this, this.commonStrings.CONSTRUCTOR)
    }

    def this(request : HttpServletRequest) = {
        this()
        this.map = request.getParameterMap().asInstanceOf[Map[Object, Object]]
        this.logUtil.putF("RequestParams Size: " + this.getMap().keySet().size(), this, this.commonStrings.CONSTRUCTOR)
    }

    def this(pageContext : PageContext) = {
        this()
        this.map = pageContext.getRequest().getParameterMap().asInstanceOf[Map[Object, Object]]
        this.logUtil.putF("Request Params Size: " + this.getMap().keySet().size(), this, this.commonStrings.CONSTRUCTOR)
    }

    def setMap(map : Map[Object, Object]) : Unit = {
        this.map = map
    }

    def getMap() : Map[Object, Object] = {
        return this.map
    }

    def toXmlNode(document : Document) : Node = {
        try {
            val node : Node = document.createElement(RequestData.REQUEST)
            val stringBuffer : StringMaker = new StringMaker()
            val keys : Set[Object] = this.map.keySet().asInstanceOf[Set[Object]]
            val keyArray : Array[Object] = keys.toArray()
            val size : Int = keyArray.length

            {
                var i : Int = 0
                while (i < size) {
                    var key : String = keyArray(i).asInstanceOf[String]
                    var values : Array[String] = this.map.get(key).asInstanceOf[Array[String]]
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append(this.KEY)
                    stringBuffer.append(key)
                    stringBuffer.append(this.VALUE)
                    stringBuffer.append(values(0))
                    this.logUtil.putF(stringBuffer.toString(), this, "toXmlNode(document)")
                    node.appendChild(ModDomHelper.createNameValueNodes(document, RequestData.PARAMETER, new String(key), new String(values(0))))
                    i += 1
                }
            }
            return node
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "toXmlNode(document)", e)
                //throw e;
                return null
            }
        }
        throw new IllegalStateException()
    }

    //do not involve multiple values
    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        var keys : Set[Object] = this.map.keySet().asInstanceOf[Set[Object]]
        var keyArray : Array[Object] = keys.toArray()
        var size : Int = keyArray.length
        var stringBuffer : StringMaker = new StringMaker()

        {
            var i : Int = 0
            while (i < size) {
                var key : String = keyArray(i).asInstanceOf[String]
                //At some point they made them all String[] but you never know if they will go back or what
                var values : Array[String] = this.map.get(key).asInstanceOf[Array[String]]
                hashMap.put(new String(key), new String(values(0)))
                i += 1
            }
        }
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append("RequestParams: ")
        stringBuffer.append(this.map.toString())
        stringBuffer.append("\ntoHashMap: ")
        stringBuffer.append(hashMap.toString())
        this.logUtil.putF(stringBuffer.toString(), this, "toHashMap()")
        return hashMap
    }

}


