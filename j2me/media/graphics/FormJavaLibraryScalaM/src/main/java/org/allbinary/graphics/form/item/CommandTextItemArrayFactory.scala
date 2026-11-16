/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form.item

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.ImageItem
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.form.ScreenInfo
import _root_.org.allbinary.logic.VectorUtil
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.visitor.Visitor
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class CommandTextItemArrayFactory(param_visitorInterface : Visitor) {

    //protected final CommonStrings commonStrings = CommonStrings.getInstance();
    private val list : BasicArrayList = new BasicArrayListD()

    private var visitorInterface : Visitor = null

    //Constructor
    {
        val visitorInterface : Visitor = param_visitorInterface
        this.visitorInterface = visitorInterface
    }

    final def getInstance(vector : Object, backgroundBasicColor : BasicColor, foregroundBasicColor : BasicColor) : Array[ABCustomItem] = {
        val vectorUtil : VectorUtil = VectorUtil.getInstance()
        val size : Int = vectorUtil.getSize(vector)
        this.list.clear()
        var textItem : CommandTextItem = null
        var priorityLimit : Int = 7
        val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        val isLargeEnoughDisplayForBigMenu : Boolean = (displayInfo.isPortrait() && (displayInfo.getLastHeight() >= ScreenInfo.getInstance().MEDIUM_WIDTH)) || (!displayInfo.isPortrait() && (displayInfo.getLastWidth() >= ScreenInfo.getInstance().MEDIUM_WIDTH))
        if (!isLargeEnoughDisplayForBigMenu && (size > 3)) {
            priorityLimit = 3
        }
        var command : Command = null

        {
            var index : Int = 0
            while (index < size) {
                command = vectorUtil.elementAt(vector, index).asInstanceOf[Command]
                //isNotPriority || command.getPriority() == 3
                if (command.getPriority() < priorityLimit) {
                    //PreLogUtil.put("Label: " + command.getLabel(), this, this.commonStrings.GET_INSTANCE);
                    var aBoolean : _root_.java.lang.Boolean = this.visitorInterface.visit(command).asInstanceOf[_root_.java.lang.Boolean]
                    if (aBoolean.booleanValue()) {
                        textItem = new CommandTextItem(command, ImageItem.LAYOUT_DEFAULT, StringUtil.getInstance().EMPTY_STRING, backgroundBasicColor, foregroundBasicColor)
                        this.list.add(textItem)
                    }
                }
                index += 1
            }
        }
        val textItemArray : Array[ABCustomItem] = new Array[ABCustomItem](this.list.size())
        val size2 : Int = textItemArray.length

        {
            var index : Int = 0
            while (index < size2) {
                textItemArray(index) = this.list.objectArray(index).asInstanceOf[ABCustomItem]
                index += 1
            }
        }
        return textItemArray
    }

}


