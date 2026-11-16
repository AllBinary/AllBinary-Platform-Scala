/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom.document

import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.regex.replace.Replace

class DocumentToNode private() {
    import _root_.org.allbinary.data.tree.dom.document.DocumentToNode.{*}

}

object DocumentToNode {
    //null;
    private val XMLROOT : String = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"

    private val XMLROOTSTART : String = "<?xml"

    private val XMLROOTEND : String = "?>"

    private val XMLJSPROOTSTART : String = "<jsp:root"

    private val XMLEND : String = ">"

    private val XMLJSPROOTENDSTART : String = "</jsp:root"

    /*     public static final Node createTempNode(Document document)     {     return document.createElement(TEMPNODE);     }      public static String getKey()     {     return tempNodeStr;     }      */
    def convertDocumentToNodeString(param_documentString : String) : String = {
        var documentString : String = param_documentString
        //TWB - Remove jsp:root from inserted component
        documentString = DocumentToNode.remove(documentString, DocumentToNode.XMLJSPROOTSTART, DocumentToNode.XMLEND)
        //"1: " + documentString);
        documentString = DocumentToNode.remove(documentString, DocumentToNode.XMLJSPROOTENDSTART, DocumentToNode.XMLEND)
        //this replaces the xml info and could cause a problem with different transformations
        var replaceXmlRoot : Replace = new Replace(XMLROOT, StringUtil.getInstance().EMPTY_STRING)
        return replaceXmlRoot.all(documentString)
    }

    def removeXmlDefinitionFromDocumentString(documentString : String) : String = {
        return DocumentToNode.remove(documentString, XMLROOTSTART, XMLROOTEND)
    }

    def remove(documentString : String, start : String, end : String) : String = {
        //this replaces the xml info and could cause a problem with different transformations
        var startIndex : Int = 0

        {
            while (({ startIndex = documentString.indexOf(start); startIndex }) != -1) {
                if (startIndex >= 0) {
                    var endIndex : Int = documentString.indexOf(end, startIndex)
                    if (endIndex >= 0) {
                        var startString : String = documentString.substring(0, startIndex)
                        var resultString : String = documentString.substring(endIndex + 1)
                        return startString + resultString
                    }
                }
            }
        }
        return documentString
    }

}


