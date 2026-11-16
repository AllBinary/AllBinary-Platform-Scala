/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition

import _root_.java.awt.Color
import _root_.java.awt.Point
import _root_.java.awt.image.BufferedImage
import _root_.java.util.HashMap
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.allbinary.graphics.color.ColorCacheFactory
import _root_.org.allbinary.graphics.color.ColorCacheable
import _root_.org.allbinary.input.media.image.capture.CapturedBufferedImagesCacheSingleton
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.cache.AutomaticCacheInterface
import _root_.org.allbinary.media.image.analysis.ColorRange
import _root_.org.allbinary.media.image.analysis.ColorRangeInterface
import _root_.org.allbinary.media.image.cache.BufferedImageFrameCacheable
import _root_.org.allbinary.string.CommonSeps
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class ColorAtActionScriptCondition private (super_1 : String, super_2 : Node, constructor_ : Unit) extends BasicProfileActionScriptCondition(super_1, super_2) with ColorAtActionScriptConditionInterface {
    import _root_.org.allbinary.input.automation.actions.script.condition.ColorAtActionScriptCondition.{*}

    val logUtil_ColorAtActionScriptCondition : LogUtil = LogUtil.getInstance()

    private var colorAtActionScriptConditionJPanel : ColorAtActionScriptConditionJPanel = null

    private var point : Point = null

    private var colorRangeInterface : ColorRangeInterface = (new ColorRange()).asInstanceOf[ColorRangeInterface]

    def this(node : Node) = {
        this(ColorAtActionScriptCondition.NAME, node, ())
        this.point = new Point(0, 0)
        var actionNode : Node = DomSearchHelper.getNode(ColorAtActionScriptConditionData.NAME, node.getChildNodes())
        if (actionNode != null) {
            var nodeList : NodeList = actionNode.getChildNodes()

            {
                var index : Int = 0
                while (index < nodeList.getLength()) {
                    var childNode : Node = nodeList.item(index)
                    if (childNode.getNodeName().compareTo(ColorAtActionScriptConditionData.LOCATION_X) == 0) {
                        var locationX : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.point.x = Integer.valueOf(locationX)
                    } else if (childNode.getNodeName().compareTo(ColorAtActionScriptConditionData.LOCATION_Y) == 0) {
                        var locationY : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.point.y = Integer.valueOf(locationY)
                    } else if (childNode.getNodeName().compareTo(ColorAtActionScriptConditionData.MIN_RED) == 0) {
                        var string : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.getColorRangeInterface().setMinRed(Integer.valueOf(string))
                    } else if (childNode.getNodeName().compareTo(ColorAtActionScriptConditionData.MAX_RED) == 0) {
                        var string : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.getColorRangeInterface().setMaxRed(Integer.valueOf(string))
                    } else if (childNode.getNodeName().compareTo(ColorAtActionScriptConditionData.MIN_GREEN) == 0) {
                        var string : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.getColorRangeInterface().setMinGreen(Integer.valueOf(string))
                    } else if (childNode.getNodeName().compareTo(ColorAtActionScriptConditionData.MAX_GREEN) == 0) {
                        var string : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.getColorRangeInterface().setMaxGreen(Integer.valueOf(string))
                    } else if (childNode.getNodeName().compareTo(ColorAtActionScriptConditionData.MIN_BLUE) == 0) {
                        var string : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.getColorRangeInterface().setMinBlue(Integer.valueOf(string))
                    } else if (childNode.getNodeName().compareTo(ColorAtActionScriptConditionData.MAX_BLUE) == 0) {
                        var string : String = DomNodeHelper.getTextNodeValue(childNode)
                        this.getColorRangeInterface().setMaxBlue(Integer.valueOf(string))
                    }
                    index += 1
                }
            }
        } else {
            throw new Exception("Color At Action Script Condition Node Null")
        }
        this.init()
    }

    def this() = {
        this(ColorAtActionScriptCondition.NAME, null, ())
        this.point = new Point(0, 0)
        this.init()
    }

    private def init() : Unit = {
        this.colorAtActionScriptConditionJPanel = new ColorAtActionScriptConditionJPanel(this)
    }

    def getPoint() : Point = {
        return this.point
    }

    def setPoint(point : Point) : Unit = {
        this.point = point
    }

    override def showDialog() : Unit = {
        this.colorAtActionScriptConditionJPanel.getColorAtActionJDialog().setVisible(true)
    }

    def toHashMap() : HashMap[Object, Object] = {
        var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        hashMap.put(ColorAtActionScriptConditionData.LOCATION_X, Integer.toString(this.getPoint().x))
        hashMap.put(ColorAtActionScriptConditionData.LOCATION_Y, Integer.toString(this.getPoint().y))
        hashMap.put(ColorAtActionScriptConditionData.MIN_RED, Integer.toString(this.getColorRangeInterface().getMinRed()))
        hashMap.put(ColorAtActionScriptConditionData.MAX_RED, Integer.toString(this.getColorRangeInterface().getMaxRed()))
        hashMap.put(ColorAtActionScriptConditionData.MIN_GREEN, Integer.toString(this.getColorRangeInterface().getMinGreen()))
        hashMap.put(ColorAtActionScriptConditionData.MAX_GREEN, Integer.toString(this.getColorRangeInterface().getMaxGreen()))
        hashMap.put(ColorAtActionScriptConditionData.MIN_BLUE, Integer.toString(this.getColorRangeInterface().getMinBlue()))
        hashMap.put(ColorAtActionScriptConditionData.MAX_BLUE, Integer.toString(this.getColorRangeInterface().getMaxBlue()))
        this.logUtil_ColorAtActionScriptCondition.putF("HashMap: " + hashMap.toString(), this, "toHashMap()")
        return hashMap
    }

    override def toXmlNode(document : Document) : Node = {
        var node : Node = super.toXmlNode(document)
        node.appendChild(ModDomHelper.createNodeWithValueNodes(document, ColorAtActionScriptConditionData.NAME, this.toHashMap()))
        return node
    }

    def shouldProcess(frame : Long) : Boolean = {
        var capturedBufferedImageCacheable : BufferedImageFrameCacheable = (CapturedBufferedImagesCacheSingleton.getInstance().asInstanceOf[AutomaticCacheInterface]).get(_root_.java.lang.Long.valueOf(frame)).asInstanceOf[BufferedImageFrameCacheable]
        var bufferedImage : BufferedImage = capturedBufferedImageCacheable.getBufferedImage()
        var automaticCacheInterface : AutomaticCacheInterface = ColorCacheFactory.getInstance()
        var colorInteger : Integer = Integer.valueOf(bufferedImage.getRGB(this.getPoint().x, this.getPoint().y))
        var colorCacheable : ColorCacheable = automaticCacheInterface.get(colorInteger).asInstanceOf[ColorCacheable]
        var color : Color = colorCacheable.getColor()
        //automation inputs
        if (this.colorRangeInterface.isInRange(color)) {
            return super.shouldProcess(frame)
        }
        return false
    }

    def log() : Unit = {
        val message : String = new StringMaker().append("getPoint(): ").append(this.getPoint().toString()).append(CommonSeps.getInstance().NEW_LINE).append(this.getColorRangeInterface().toString()).toString()
        this.logUtil_ColorAtActionScriptCondition.putF(message, this, "log")
    }

    def getColorRangeInterface() : ColorRangeInterface = {
        return this.colorRangeInterface
    }

    def setColorRangeInterface(colorRangeInterface : ColorRangeInterface) : Unit = {
        this.colorRangeInterface = colorRangeInterface
    }

}

object ColorAtActionScriptCondition {
    private val NAME : String = "If Color At"

}


