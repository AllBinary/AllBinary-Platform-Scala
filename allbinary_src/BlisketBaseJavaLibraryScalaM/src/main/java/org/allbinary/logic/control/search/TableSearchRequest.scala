/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.search

import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class TableSearchRequest(param_keywords : String, param_searchParams : SearchParams, param_xslFile : String, param_contentType : String) {

    private var xslFile : String = null

    private var pageName : String = null

    private var contentType : String = null

    private var keywords : String = null

    private var searchParams : SearchParams = null

    //Constructor
    {
        val keywords : String = param_keywords
        val searchParams : SearchParams = param_searchParams
        val xslFile : String = param_xslFile
        val contentType : String = param_contentType
        this.keywords = keywords
        this.searchParams = searchParams
        this.xslFile = xslFile
        this.pageName = this.pageName
        this.contentType = contentType
    }

    def setKeywords(value : String) : Unit = {
        this.keywords = value
    }

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

    def getKeywords() : String = {
        return this.keywords
    }

    def getParams() : SearchParams = {
        return this.searchParams
    }

    def getXslFile() : String = {
        var path : String = (URLGLOBALS.getMainPath() + FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH) + this.xslFile
        return path
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


