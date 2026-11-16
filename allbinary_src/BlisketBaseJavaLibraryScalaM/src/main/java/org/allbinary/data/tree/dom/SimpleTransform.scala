/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.java.io.StringBufferInputStream
import _root_.javax.xml.transform.stream.StreamSource
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.io.AbFileLocalInputStream
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.w3c.dom.Document

class SimpleTransform(param_xsltFilePath : AbPath, param_dataFilePath : AbPath) {

    private var xsltFilePath : AbPath = null

    private var dataFilePath : AbPath = null

    //Constructor
    {
        val xsltFilePath : AbPath = param_xsltFilePath
        val dataFilePath : AbPath = param_dataFilePath
        this.xsltFilePath = xsltFilePath
        this.dataFilePath = dataFilePath
    }

    def transform() : String = {
        val inputStream : AbFileLocalInputStream = new AbFileLocalInputStream(AbFile.createAbFileFromAbPath(this.xsltFilePath))
        val document : Document = DomDocumentHelper.create(new AbFileLocalInputStream(AbFile.createAbFileFromAbPath(this.dataFilePath)))
        val result : String = XslHelper.getInstance().translate(new StreamSource(inputStream), new StreamSource(new StringBufferInputStream(XmlDocumentHelper.toString(document))))
        return result
    }

}


