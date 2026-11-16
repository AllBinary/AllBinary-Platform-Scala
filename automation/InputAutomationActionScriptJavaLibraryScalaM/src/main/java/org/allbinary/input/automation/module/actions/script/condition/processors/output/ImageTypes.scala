/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.actions.script.condition.processors.output

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.input.media.image.InputImageType
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class ImageTypes() {
    import _root_.org.allbinary.input.automation.module.actions.script.condition.processors.output.ImageTypes.{*}

    private var vector : BasicArrayList = new BasicArrayListD()

    def this(node : Node) = {
        this()
        var nodeList : NodeList = node.getChildNodes()

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                var childNode : Node = nodeList.item(index)
                if (childNode.getNodeName().compareTo(ImageActionScriptOutputData.TYPE) == 0) {
                    var nextImageTypeString : String = DomNodeHelper.getTextNodeValue(childNode)
                    this.getVector().add(InputImageType.getInstance(nextImageTypeString))
                } else {
                    throw new Exception("ImageTypes Unknown Node")
                }
                index += 1
            }
        }
    }

    def getVector() : BasicArrayList = {
        return this.vector
    }

    def toXmlNode(document : Document) : Node = {
        val newNode : Node = document.createElement(ImageActionScriptOutputData.TYPES)
        val size : Int = this.vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var imageType : InputImageType = this.vector.get(index).asInstanceOf[InputImageType]
                newNode.appendChild(ModDomHelper.createTextNode(document, ImageActionScriptOutputData.TYPE, imageType.getName()))
                index += 1
            }
        }
        return newNode
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("ImageTypes: ")
        val size : Int = this.vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var imageType : InputImageType = this.vector.get(index).asInstanceOf[InputImageType]
                stringBuffer.append(imageType.getName())
                if (index < (size - 1)) {
                    stringBuffer.append(", ")
                }
                index += 1
            }
        }
        return stringBuffer.toString()
    }

}

object ImageTypes {
    //String[] selectedImageTypeStringArray
    def valueOf(anyType : Array[Object]) : ImageTypes = {
        var imageTypes : ImageTypes = new ImageTypes()

        {
            var index : Int = 0
            while (index < anyType.length) {
                var imageType : InputImageType = InputImageType.getInstance(anyType(index).asInstanceOf[String])
                imageTypes.getVector().add(imageType)
                index += 1
            }
        }
        return imageTypes
    }

}


