/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.style.color

import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class ColorsView() extends DomNodeInterface {

    private val commonPhoneStrings : CommonPhoneStrings = CommonPhoneStrings.getInstance()

    private val HEXRADIX : Int = 16

    private val MAX : Int = 255

    val delta : Int = 20

    def getColorNode(document : Document, redIndex : Int, greenIndex : Int, blueIndex : Int) : Node = {
        var hexColorStringBuffer : StringMaker = new StringMaker()
        if (redIndex < this.HEXRADIX) {
            hexColorStringBuffer.append(this.commonPhoneStrings.ZERO)
        }
        hexColorStringBuffer.append(Integer.toString(redIndex, HEXRADIX))
        if (greenIndex < this.HEXRADIX) {
            hexColorStringBuffer.append(this.commonPhoneStrings.ZERO)
        }
        hexColorStringBuffer.append(Integer.toString(greenIndex, HEXRADIX))
        if (blueIndex < this.HEXRADIX) {
            hexColorStringBuffer.append(this.commonPhoneStrings.ZERO)
        }
        hexColorStringBuffer.append(Integer.toString(blueIndex, HEXRADIX))
        var colorNode : Node = ModDomHelper.createNameValueNodes(document, ColorData.getInstance().NAME, hexColorStringBuffer.toString())
        return colorNode
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = ModDomHelper.createNameValueNodes(document, ColorsData.getInstance().NAME, "RGB Colors In Hex")
        var blackNode : Node = ModDomHelper.createNameValueNodes(document, ColorData.getInstance().NAME, "000000")
        node.appendChild(blackNode)
        //Gray Scale

        {
            var index : Int = 0
            while (index < this.MAX) {
                var hexColorStringBuffer : StringMaker = new StringMaker()
                if (index < this.HEXRADIX) {
                    hexColorStringBuffer.append(this.commonPhoneStrings.ZERO)
                }
                hexColorStringBuffer.append(Integer.toString(index, HEXRADIX))
                if (index < this.HEXRADIX) {
                    hexColorStringBuffer.append(this.commonPhoneStrings.ZERO)
                }
                hexColorStringBuffer.append(Integer.toString(index, HEXRADIX))
                if (index < this.HEXRADIX) {
                    hexColorStringBuffer.append(this.commonPhoneStrings.ZERO)
                }
                hexColorStringBuffer.append(Integer.toString(index, HEXRADIX))
                var colorNode : Node = ModDomHelper.createNameValueNodes(document, ColorData.getInstance().NAME, hexColorStringBuffer.toString())
                node.appendChild(colorNode)
                index += this.delta
            }
        }
        var whiteNode : Node = ModDomHelper.createNameValueNodes(document, ColorData.getInstance().NAME, "FFFFFF")
        node.appendChild(whiteNode)
        //Blue

        {
            var blueIndex : Int = this.MAX / 2
            while (blueIndex < this.MAX) {

                {
                    var greenIndex : Int = 0
                    while (greenIndex < (this.MAX / 2)) {

                        {
                            var redIndex : Int = 0
                            while (redIndex < (this.MAX / 2)) {
                                node.appendChild(this.getColorNode(document, redIndex, greenIndex, blueIndex))
                                redIndex += this.delta
                            }
                        }
                        greenIndex += this.delta
                    }
                }
                blueIndex += this.delta
            }
        }
        //Red

        {
            var redIndex : Int = this.MAX / 2
            while (redIndex < this.MAX) {

                {
                    var greenIndex : Int = 0
                    while (greenIndex < (this.MAX / 2)) {

                        {
                            var blueIndex : Int = 0
                            while (blueIndex < (this.MAX / 2)) {
                                node.appendChild(this.getColorNode(document, redIndex, greenIndex, blueIndex))
                                blueIndex += this.delta
                            }
                        }
                        greenIndex += this.delta
                    }
                }
                redIndex += this.delta
            }
        }
        //Green

        {
            var greenIndex : Int = this.MAX / 2
            while (greenIndex < this.MAX) {

                {
                    var redIndex : Int = 0
                    while (redIndex < (this.MAX / 2)) {

                        {
                            var blueIndex : Int = 0
                            while (blueIndex < (this.MAX / 2)) {
                                node.appendChild(this.getColorNode(document, redIndex, greenIndex, blueIndex))
                                blueIndex += this.delta
                            }
                        }
                        redIndex += this.delta
                    }
                }
                greenIndex += this.delta
            }
        }
        //All

        {
            var greenIndex : Int = 0
            while (greenIndex < this.MAX) {

                {
                    var redIndex : Int = 0
                    while (redIndex < this.MAX) {

                        {
                            var blueIndex : Int = 0
                            while (blueIndex < this.MAX) {
                                node.appendChild(this.getColorNode(document, redIndex, greenIndex, blueIndex))
                                blueIndex += 2 * this.delta
                            }
                        }
                        redIndex += 2 * this.delta
                    }
                }
                greenIndex += 2 * this.delta
            }
        }
        return node
    }

}


