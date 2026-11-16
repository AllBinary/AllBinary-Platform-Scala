/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint.help

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.game.input.GameKey
import _root_.org.allbinary.game.input.GameKeyFactory
import _root_.org.allbinary.game.input.Input
import _root_.org.allbinary.game.input.PlatformInputMappingFactory
import _root_.org.allbinary.game.input.mapping.GameInputMapping
import _root_.org.allbinary.game.input.mapping.PersistentInputMapping
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.color.BasicColorUtil
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList

class InputMappingHelpPaintable(param_gameInputMappingArray : Array[GameInputMapping], param_backgroundBasicColor : BasicColor, param_basicColor : BasicColor) extends HelpPaintable("Input Mapping", param_backgroundBasicColor, param_basicColor) {
    import _root_.org.allbinary.game.paint.help.InputMappingHelpPaintable.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    val commonSeps : CommonSeps = CommonSeps.getInstance()

    val stringUtil : StringUtil = StringUtil.getInstance()

    private val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()

    private val NONE : GameKey = GameKeyFactory.getInstance().NONE

    private val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING

    private var gameInputMappingArray : Array[GameInputMapping] = null

    private var keyMappingArray : Array[BasicArrayList] = new Array[BasicArrayList](0)

    private var actionBasicColor : Array[BasicColor] = BasicColorUtil.getInstance().ZERO_ARRAY

    private var inputBasicColorArray : Array[Array[BasicColor]] = Array.ofDim[BasicColor](0, 0)

    private var selectedBasicColor : BasicColor = null

    private var updateMyFontProperties : UpdateMyFontProperties = new UpdateMyFontProperties()

    //Constructor
    {
        val gameInputMappingArray : Array[GameInputMapping] = param_gameInputMappingArray
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val basicColor : BasicColor = param_basicColor
        this.gameInputMappingArray = gameInputMappingArray
        this.update(this.NONE, this.NONE)
        if ((backgroundBasicColor eq this.basicColorFactory.WHITE) || (basicColor eq this.basicColorFactory.WHITE)) {
            this.selectedBasicColor = this.basicColorFactory.RED
        } else {
            this.selectedBasicColor = this.basicColorFactory.WHITE
        }
    }

    override def updateMeasurement(graphics : Graphics) : Unit = {
        val font : Font = graphics.getFont()
        val updateMyFontProperties : UpdateMyFontProperties = new UpdateMyFontProperties()
        updateMyFontProperties.charHeight = font.getHeight()
        val stringMaker : StringMaker = new StringMaker()
        val inputInfo : Array[String] = this.inputInfo
        val size : Int = inputInfo.length
        updateMyFontProperties.actionStringArray = new Array[String](size)
        updateMyFontProperties.keymappingBeginWidthArray = new Array[Int](size)
        updateMyFontProperties.actionStringDeltaXArray = new Array[Int](size)
        updateMyFontProperties.inputDeltaXArray = Array.ofDim[Int](size, 0)
        updateMyFontProperties.sepArray = Array.ofDim[String](size, 0)
        updateMyFontProperties.sepWidthArray = Array.ofDim[Int](size, 0)
        var list : BasicArrayList = null
        var keyMappings : String = null
        var actionString : String = null
        var input : Input = null
        var size2 : Int = 0

        {
            var index : Int = 0
            while (index < size) {
                list = this.keyMappingArray(index)
                keyMappings = this.get(list)
                //For same line action and mappings
                stringMaker.delete(0, stringMaker.length())
                actionString = stringMaker.append(inputInfo(index)).append(commonSeps.COLON).append(commonSeps.SPACE).append(commonSeps.SPACE).toString()
                updateMyFontProperties.actionStringArray(index) = actionString
                //For same line action and mappings
                stringMaker.delete(0, stringMaker.length())
                updateMyFontProperties.keymappingBeginWidthArray(index) = (font.stringWidth(stringMaker.append(updateMyFontProperties.actionStringArray(index)).append(keyMappings).toString()) >> 1)
                updateMyFontProperties.actionStringDeltaXArray(index) = font.stringWidth(actionString)
                size2 = list.size()
                updateMyFontProperties.inputDeltaXArray(index) = new Array[Int](size2)
                updateMyFontProperties.sepArray(index) = new Array[String](size2)
                updateMyFontProperties.sepWidthArray(index) = new Array[Int](size2)

                {
                    var index2 : Int = 0
                    while (index2 < size2) {
                        input = list.objectArray(index2).asInstanceOf[Input]
                        updateMyFontProperties.inputDeltaXArray(index)(index2) = font.stringWidth(input.getName())
                        updateMyFontProperties.sepArray(index)(index2) = EMPTY_STRING
                        if ((index2 + 1) < list.size()) {
                            if (list.size() == 2) {
                                updateMyFontProperties.sepArray(index)(index2) = InputMappingHelpPaintable.AND
                            } else {
                                if ((index2 + 2) == list.size()) {
                                    updateMyFontProperties.sepArray(index)(index2) = InputMappingHelpPaintable.MORE_THAN_TWO_IN_LIST_AND
                                } else {
                                    updateMyFontProperties.sepArray(index)(index2) = InputMappingHelpPaintable.SEP
                                }
                            }
                        }
                        if (updateMyFontProperties.sepArray(index)(index2) ne EMPTY_STRING) {
                            updateMyFontProperties.sepWidthArray(index)(index2) = font.stringWidth(updateMyFontProperties.sepArray(index)(index2))
                        }
                        index2 += 1
                    }
                }
                index += 1
            }
        }
        this.updateMyFontProperties = updateMyFontProperties
        super.updateMeasurement(graphics)
    }

    def update(selectedGameKey : GameKey, selectedInput : Input) : Unit = {
        val stringMaker : StringMaker = new StringMaker()
        this.logUtil.putF(stringMaker.append(CommonLabels.getInstance().START_LABEL).append("selected GameKey: ").append(this.stringUtil.toString(selectedGameKey)).append(" Input: ").append(this.stringUtil.toString(selectedInput)).toString(), this, this.commonStrings.UPDATE)
        val gameKeyMapping : PersistentInputMapping = PlatformInputMappingFactory.getInstance().getPersistentInputMappingInstance()
        val size : Int = this.gameInputMappingArray.length
        val keyInfo : Array[String] = new Array[String](size)
        val keyMappingArray : Array[BasicArrayList] = new Array[BasicArrayList](size)
        val actionBasicColor : Array[BasicColor] = new Array[BasicColor](size)
        val inputBasicColorArray : Array[Array[BasicColor]] = new Array[Array[BasicColor]](size)
        var gameInputMapping : GameInputMapping = null
        var gameKey : GameKey = null
        var list : BasicArrayList = null

        {
            var index : Int = 0
            while (index < size) {
                gameInputMapping = this.gameInputMappingArray(index)
                gameKey = gameInputMapping.getGameKey()
                list = gameKeyMapping.getInputMapping().getMappedInput(gameKey)
                var size2 : Int = list.size()
                inputBasicColorArray(index) = new Array[BasicColor](size2)

                {
                    var index2 : Int = 0
                    while (index2 < size2) {
                        inputBasicColorArray(index)(index2) = this.basicColor
                        index2 += 1
                    }
                }
                if (gameKey eq selectedGameKey) {
                    stringMaker.delete(0, stringMaker.length())
                    this.logUtil.putF(stringMaker.append("Found: selected GameKey: ").append(this.stringUtil.toString(selectedGameKey)).toString(), this, this.commonStrings.UPDATE)
                    actionBasicColor(index) = this.selectedBasicColor
                    var indexOfSelectedInput : Int = list.indexOf(selectedInput)
                    if (indexOfSelectedInput >= 0) {
                        stringMaker.delete(0, stringMaker.length())
                        this.logUtil.putF(stringMaker.append("Found: selected Input: ").append(this.stringUtil.toString(selectedInput)).toString(), this, this.commonStrings.UPDATE)
                        inputBasicColorArray(index)(indexOfSelectedInput) = this.selectedBasicColor
                    }
                } else {
                    actionBasicColor(index) = this.basicColor
                }
                //keyInfo[index] = gameInputMapping.getName()).append(" = ").append(this.get(list);
                keyInfo(index) = gameInputMapping.getName()
                keyMappingArray(index) = list
                index += 1
            }
        }
        this.keyMappingArray = keyMappingArray
        this.actionBasicColor = actionBasicColor
        this.inputBasicColorArray = inputBasicColorArray
        super.setInputInfoP(keyInfo)
        this.myFontProcessor = this.updateMyFontProcessor
    }

    private def get(keyList : BasicArrayList) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        var key : Input = null
        val size : Int = keyList.size()

        {
            var index : Int = 0
            while (index < size) {
                key = keyList.objectArray(index).asInstanceOf[Input]
                //Get system platform key(s) mapped to gamekey
                stringBuffer.append(key.getName())
                if ((index + 1) < keyList.size()) {
                    if (keyList.size() == 2) {
                        stringBuffer.append(InputMappingHelpPaintable.AND)
                    } else {
                        if ((index + 2) == keyList.size()) {
                            stringBuffer.append(InputMappingHelpPaintable.MORE_THAN_TWO_IN_LIST_AND)
                        } else {
                            stringBuffer.append(InputMappingHelpPaintable.SEP)
                        }
                    }
                }
                index += 1
            }
        }
        return stringBuffer.toString()
    }

    //    }
    override def paint(graphics : Graphics) : Unit = {
        this.myFontProcessor.process(graphics)
        //this.colorFillPaintable.paint(graphics);
        val halfWidth : Int = this.displayInfo.getLastHalfWidth()
        graphics.setColor(this.basicColor.intValue())
        graphics.drawString(this.title, halfWidth - this.titleBeginWidth, this.updateMyFontProperties.charHeight, this.anchor)
        val inputInfo : Array[String] = this.inputInfo
        val size : Int = inputInfo.length
        var y : Int = 0
        var deltaX : Int = 0
        var size2 : Int = 0
        var actionString : String = null
        var input : Input = null
        var list : BasicArrayList = null
        var sep : String = null
        var beginWidth : Int = 0

        {
            var index : Int = 0
            while (index < size) {
                //For same line action and mappings
                y = (index + 3) * this.updateMyFontProperties.charHeight
                //y = ((index * 2) + 3) * this.myFont.DEFAULT_CHAR_HEIGHT;
                deltaX = 0
                list = this.keyMappingArray(index)
                size2 = list.size()
                beginWidth = this.updateMyFontProperties.keymappingBeginWidthArray(index)
                //beginWidth = (font.stringWidth(actionString) >> 1);
                graphics.setColor(this.actionBasicColor(index).intValue())
                actionString = this.updateMyFontProperties.actionStringArray(index)
                graphics.drawString(actionString, (halfWidth - beginWidth) + deltaX, y, this.anchor)
                //For same line action and mappings
                deltaX += this.updateMyFontProperties.actionStringDeltaXArray(index)
                //beginWidth = (font.stringWidth(keyMappings) >> 1);

                {
                    var index2 : Int = 0
                    while (index2 < size2) {
                        input = list.objectArray(index2).asInstanceOf[Input]
                        graphics.setColor(this.inputBasicColorArray(index)(index2).intValue())
                        graphics.drawString(input.getName(), (halfWidth - beginWidth) + deltaX, y, this.anchor)
                        deltaX += this.updateMyFontProperties.inputDeltaXArray(index)(index2)
                        sep = this.updateMyFontProperties.sepArray(index)(index2)
                        graphics.setColor(this.basicColor.intValue())
                        graphics.drawString(sep, (halfWidth - beginWidth) + deltaX, y, this.anchor)
                        deltaX += this.updateMyFontProperties.sepWidthArray(index)(index2)
                        index2 += 1
                    }
                }
                index += 1
            }
        }
    }

}

object InputMappingHelpPaintable {
    private val AND : String = " and "

    private val SEP : String = ", "

    private val MORE_THAN_TWO_IN_LIST_AND : String = ", and "

}


