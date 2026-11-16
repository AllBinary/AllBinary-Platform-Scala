/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.org.allbinary.globals.FREEBLISKET_PATH_GLOBALS
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.control.search.SearchRequest
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

class TransformInfoHttpSearch(param_searchRequest : SearchRequest) extends TransformInfoHttp(param_searchRequest.getPropertiesHashMap(), param_searchRequest.getPageContext()) {

    //Constructor
    {
        val searchRequest : SearchRequest = param_searchRequest
        if (searchRequest.getStoreFront().getName() != null) {
            this.setStoreName(searchRequest.getStoreFront().getName())
        } else {
            this.setStoreName(StringUtil.getInstance().EMPTY_STRING)
        }
        var dataFileName : String = searchRequest.getXslFile()
        this.setTemplateFile(dataFileName)
    }

    private def getPath() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(URLGLOBALS.getMainPath())
        stringBuffer.append(FREEBLISKET_PATH_GLOBALS.getInstance().XSLPATH)
        stringBuffer.append(this.getStoreName())
        stringBuffer.append(AbPathData.getInstance().SEPARATOR)
        return stringBuffer.toString()
    }

    override def getTemplateFilePath() : AbPath = {
        return new AbPath(this.getPath(), this.getTemplateFile())
    }

    override def getObjectConfigFilePath() : AbPath = {
        return new AbPath(this.getPath(), this.getObjectConfigFile())
    }

    override def getDataFilePath() : AbPath = {
        return new AbPath(this.getPath(), this.getDataFile())
    }

}


