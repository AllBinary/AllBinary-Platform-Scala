/* * AllBinary Open License Version 1 * Copyright (c) 2022 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.java.io.ByteArrayOutputStream
import _root_.javax.xml.transform.stream.StreamResult
import _root_.javax.xml.transform.stream.StreamSource
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.path.AbPath

/**  *  * @author User  */
class AbXslHelper {
    import _root_.org.allbinary.data.tree.dom.AbXslHelper.{*}

    def translate(xslFile : AbFile, xmlFile : AbFile) : String = {
        return this.translate(xslFile.getAbsolutePath(), xmlFile.getAbsolutePath())
    }

    def translate(xslPath : AbPath, xmlPath : AbPath) : String = {
        return this.translate(xslPath.getPath(), xmlPath.getPath())
    }

    def translate(xsltFilePath : String, xmlFilePath : String) : String = {
        try {
            val outputStream : ByteArrayOutputStream = new ByteArrayOutputStream()
            return XslHelper.getInstance().translate(new StreamSource(xsltFilePath), new StreamSource(xmlFilePath), new StreamResult(outputStream)).toString()
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

}

object AbXslHelper {
    private val instance : AbXslHelper = new AbXslHelper()

    /**      * @return the instance      */
    def getInstance() : AbXslHelper = {
        return AbXslHelper.instance
    }

}


