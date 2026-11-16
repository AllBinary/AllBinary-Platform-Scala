/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom

import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.directory.Directory
import _root_.org.allbinary.logic.visual.transform.TransformInterface
import _root_.org.allbinary.logic.visual.transform.data.TransformDocumentFactory
import _root_.org.allbinary.logic.visual.transform.data.TransformDocumentInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class DirectoryDataModel(param_file : AbFile) extends DomNodeInterface with TransformInterface {

    private var fileBasicArrayList : BasicArrayList = null

    private var transformDocumentInterface : TransformDocumentInterface = null

    var NO_TYPE : Int = 0

    //Constructor
    {
        val file : AbFile = param_file
        this.fileBasicArrayList = Directory.getInstance().search(file)
        this.transformDocumentInterface = TransformDocumentFactory.getInstance().asInstanceOf[TransformDocumentInterface]
    }

    def getTypeId() : Int = {
        return this.NO_TYPE
    }

    def getTransformInfoInterface() : TransformInfoInterface = {
        return null
    }

    def setTransformDocumentInterface(transformDocumentInterface : TransformDocumentInterface) : Unit = {
        this.transformDocumentInterface = transformDocumentInterface
    }

    def getTransformDocumentInterface() : TransformDocumentInterface = {
        return this.transformDocumentInterface
    }

    //Create the directory Node
    def toXmlNode(document : Document) : Node = {
        val dirNode : Node = document.createElement("dir")
        val size : Int = this.fileBasicArrayList.size()
        var nextFile : AbFile = null
        var fileNode : Node = null

        {
            var index : Int = 0
            while (index < size) {
                nextFile = this.fileBasicArrayList.get(index).asInstanceOf[AbFile]
                fileNode = new FileDomDataModel(nextFile).toXmlNode(document)
                dirNode.appendChild(fileNode)
                index += 1
            }
        }
        return dirNode
    }

    def toXmlDoc() : Document = {
        return this.getTransformDocumentInterface().getDoc()
    }

    //In this case the data model is the view as well
    def view() : String = {
        var node : Node = this.toXmlNode(this.getTransformDocumentInterface().getDoc())
        this.getTransformDocumentInterface().getBaseNode().appendChild(node)
        return XmlDocumentHelper.toString(this.getTransformDocumentInterface().getDoc())
    }

}


