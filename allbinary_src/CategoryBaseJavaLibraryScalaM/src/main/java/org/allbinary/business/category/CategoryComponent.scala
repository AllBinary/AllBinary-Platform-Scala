/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category

import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.logic.visual.transform.TransformInterface
import _root_.org.allbinary.logic.visual.transform.data.TransformDocumentInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document

class CategoryComponent(param_categoryInterface : CategoryInterface) extends CategoryView(param_categoryInterface) with TransformInterface {

    var NO_TYPE : Int = 0

    //Constructor
    {
        val categoryInterface : CategoryInterface = param_categoryInterface
    }

    def getTypeId() : Int = {
        return this.NO_TYPE
    }

    def getTransformDocumentInterface() : TransformDocumentInterface = {
        return null
    }

    def getTransformInfoInterface() : TransformInfoInterface = {
        return null
    }

    def setTransformDocumentInterface(viewDocumentInterface : TransformDocumentInterface) : Unit = {
    }

    def toXmlDoc() : Document = {
        var document : Document = DomDocumentHelper.create()
        document.appendChild(new CategoryView(this.getCategoryInterface()).toXmlNode(document))
        return document
    }

    def view() : String = {
        return null
    }

}


