/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom.document

import _root_.javax.xml.transform.Transformer
import _root_.javax.xml.transform.TransformerFactory
import _root_.javax.xml.transform.dom.DOMSource
import _root_.javax.xml.transform.stream.StreamResult
import _root_.org.allbinary.logic.io.AbDataOutputStream
import _root_.org.allbinary.logic.io.AbFileInputStream
import _root_.org.allbinary.logic.io.DataOutputStreamFactory
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.w3c.dom.Document

class DomDocumentFileHelper private() {
    import _root_.org.allbinary.data.tree.dom.document.DomDocumentFileHelper.{*}

}

object DomDocumentFileHelper {
    /*    public static Document create(AbFile xmlFile) throws Exception    {       return DomDocumentFileHelper.create(xmlFile);    }    */
    def createDocument(xmlFile : AbFile) : Document = {
        try {
            //return document;
            return DomDocumentHelper.create(AbFileInputStream.createFromAbFile(xmlFile))
        } catch {
            case e : Exception => {
                throw e
            }
        }
        throw new IllegalStateException()
    }

    def save(file : AbFile, document : Document) : Unit = {
        var dataOutputStream : AbDataOutputStream = null
        try {
            var copyTransformerFactory : TransformerFactory = TransformerFactory.newInstance()
            var copyTransformer : Transformer = copyTransformerFactory.newTransformer()
            var domSource : DOMSource = new DOMSource(document)
            if (file.isFile()) {
                file.delete()
            }
            file.createNewFile()
            dataOutputStream = DataOutputStreamFactory.getInstance().getInstanceForAbFile(file)
            var streamResult : StreamResult = new StreamResult(dataOutputStream)
            //new StreamResult(file.getFile());
            copyTransformer.transform(domSource, streamResult)
            dataOutputStream.flush()
        } catch {
            case e : Exception => {
                throw e
            }
        } finally {
            StreamUtil.getInstance().close(dataOutputStream)
        }
    }

}


