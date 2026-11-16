/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.search

import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.data.tree.dom.ToDomHelper
import _root_.org.allbinary.logic.StdUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class SearchParams(param_request : HttpServletRequest) {

    private var columnsAndSearchValues : HashMap[Object, Object] = null

    private var order : String = null

    private var sortBy : String = null

    private var listLength : String = null

    private var startPage : String = null

    private var endPage : String = null

    //Constructor
    {
        val request : HttpServletRequest = param_request
        this.columnsAndSearchValues = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        this.setLength(request.getParameter(SearchData.LENGTH))
        this.setOrder(request.getParameter(SearchData.ORDER))
        var page : String = request.getParameter(SearchData.PAGE)
        this.setStartPage(page)
        this.setEndPage(page)
        this.setSortBy(request.getParameter(SearchData.SORTBY))
        //this.setType(request.getParameter(BasicItemData.TYPE));
        var index : Int = 0
        var columnName : String = request.getParameter(SearchData.COLUMNNAME + "[0]")
        var columnValue : String = request.getParameter(SearchData.COLUMNVALUE + "[0]")

        {
            while (columnName != null) {
                this.add(columnName, columnValue)
                index += 1
                columnName = request.getParameter(((SearchData.COLUMNNAME + "[") + index) + "]")
                columnValue = request.getParameter(((SearchData.COLUMNVALUE + "[") + index) + "]")
            }
        }
    }

    def add(column : String, value : String) : Unit = {
        this.columnsAndSearchValues.put(column, value)
    }

    def setOrder(value : String) : Unit = {
        this.order = value
    }

    def setSortBy(value : String) : Unit = {
        this.sortBy = value
    }

    def setLength(value : String) : Unit = {
        this.listLength = value
    }

    def setStartPage(value : String) : Unit = {
        this.startPage = value
    }

    def setEndPage(value : String) : Unit = {
        this.endPage = value
    }

    /*    public void setType(String value)    {       this.type = value;    }    */
    def get() : HashMap[Object, Object] = {
        return this.columnsAndSearchValues
    }

    def getOrder() : String = {
        return this.order
    }

    def getSortBy() : String = {
        return this.sortBy
    }

    def getLength() : String = {
        return this.listLength
    }

    def getLengthInt() : Integer = {
        if (this.listLength != null) {
            return new Integer(this.listLength)
        } else {
            return new Integer(0)
        }
        throw new IllegalStateException()
    }

    def getStartPage() : String = {
        return this.startPage
    }

    def getEndPage() : String = {
        return this.endPage
    }

    def getStartPageInt() : Integer = {
        if (this.startPage != null) {
            return new Integer(this.startPage)
        } else {
            return new Integer(0)
        }
        throw new IllegalStateException()
    }

    def getEndPageInt() : Integer = {
        if (this.endPage != null) {
            return new Integer(this.endPage)
        } else {
            return new Integer(0)
        }
        throw new IllegalStateException()
    }

    /*    public String getType()    {       return this.type;    }*/
    def getParamsNode(document : Document) : Node = {
        var paramsNode : Node = ModDomHelper.createNameValueNodes(document, SearchData.PARAMS, SearchData.PARAMS)
        paramsNode.appendChild(this.getFieldsNode(document))
        paramsNode.appendChild(this.getOrderNode(document))
        paramsNode.appendChild(this.getSortByNode(document))
        paramsNode.appendChild(this.getLengthNode(document))
        //searchParams.getTypeNode(document);
        return paramsNode
    }

    private def getFieldsNode(document : Document) : Node = {
        var fieldsNode : Node = ModDomHelper.createNameValueNodes(document, SearchData.FIELDS, new Integer(this.columnsAndSearchValues.size()).toString())
        var set : Set[Object] = this.columnsAndSearchValues.keySet().asInstanceOf[Set[Object]]
        val searchValueArray : Array[Object] = set.toArray()
        val size : Int = searchValueArray.length

        {
            var index : Int = 0
            while (index < size) {
                var key : String = searchValueArray(index).asInstanceOf[String]
                var searchValue : String = this.columnsAndSearchValues.get(key).asInstanceOf[String]
                fieldsNode.appendChild(ModDomHelper.createNameValueNodes(document, SearchData.FIELD, key, ToDomHelper.convertNull(searchValue)))
                index += 1
            }
        }
        return fieldsNode
    }

    private def getOrderNode(document : Document) : Node = {
        return ModDomHelper.createNameValueNodes(document, SearchData.ORDER, ToDomHelper.convertNull(this.getOrder()))
    }

    private def getSortByNode(document : Document) : Node = {
        return ModDomHelper.createNameValueNodes(document, SearchData.SORTBY, ToDomHelper.convertNull(this.getSortBy()))
    }

    private def getLengthNode(document : Document) : Node = {
        return ModDomHelper.createNameValueNodes(document, SearchData.LENGTH, ToDomHelper.convertNull(this.getLength()))
    }

}


