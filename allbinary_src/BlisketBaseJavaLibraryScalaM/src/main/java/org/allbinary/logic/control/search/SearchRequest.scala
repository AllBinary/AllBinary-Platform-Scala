/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.search

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.AbContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class SearchRequest(param_storeFront : StoreFrontInterface, param_searchParams : SearchParams, param_xslFile : String, param_contentType : String, param_propertiesHashMap : HashMap[Object, Object], param_pageContext : PageContext) extends AbContext(param_propertiesHashMap, param_pageContext) {

    private var xslFile : String = null

    private var pageName : String = null

    private var contentType : String = null

    //private String keywords;
    private var searchParams : SearchParams = null

    private var storeFront : StoreFrontInterface = null

    //Constructor
    {
        val storeFront : StoreFrontInterface = param_storeFront
        val searchParams : SearchParams = param_searchParams
        val xslFile : String = param_xslFile
        val contentType : String = param_contentType
        val propertiesHashMap : HashMap[Object, Object] = param_propertiesHashMap
        val pageContext : PageContext = param_pageContext
        //String keywords,
        this.storeFront = storeFront
        //this.keywords = keywords;
        this.searchParams = searchParams
        this.xslFile = xslFile
        this.pageName = this.pageName
        this.contentType = contentType
    }

    def setStoreFront(storeFront : StoreFrontInterface) : Unit = {
        this.storeFront = storeFront
    }

    /*    public void setKeywords(String value)    {       this.keywords = value;    }    */
    def setParams(searchParams : SearchParams) : Unit = {
        this.searchParams = searchParams
    }

    def setXslFile(value : String) : Unit = {
        this.xslFile = value
    }

    def setFileBaseName(value : String) : Unit = {
        this.pageName = value
    }

    def setContentType(value : String) : Unit = {
        this.contentType = value
    }

    def getStoreFront() : StoreFrontInterface = {
        return this.storeFront
    }

    /*    public String getKeywords()    {       return this.keywords;    }    */
    def getParams() : SearchParams = {
        return this.searchParams
    }

    def getXslFile() : String = {
        return this.xslFile
    }

    def getFileBaseName() : String = {
        return this.pageName
    }

    def getContentType() : String = {
        return this.contentType
    }

    def getFileBaseNameNode(document : Document) : Node = {
        return ModDomHelper.createNameValueNodes(document, SearchData.FILENAME, this.getFileBaseName())
    }

}


