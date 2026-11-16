/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.game.input.mapping.InputToGameKeyMapping
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class BasicTouchInputFactory {
    import _root_.org.allbinary.input.motion.button.BasicTouchInputFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val SPECIAL_BUTTON_SIX : TouchButtonInput = new TouchButtonInput(InputFactory.getInstance().MAX - 30, "Button 6")

    val SPECIAL_BUTTON_FIVE : TouchButtonInput = new TouchButtonInput(InputFactory.getInstance().MAX - 31, "Button 5")

    val SPECIAL_BUTTON_FOUR : TouchButtonInput = new TouchButtonInput(InputFactory.getInstance().MAX - 32, "Button 4")

    val SPECIAL_BUTTON_THREE : TouchButtonInput = new TouchButtonInput(InputFactory.getInstance().MAX - 33, "Button 3")

    val SPECIAL_BUTTON_TWO : TouchButtonInput = new TouchButtonInput(InputFactory.getInstance().MAX - 34, "Button 2")

    val SPECIAL_BUTTON_ONE : TouchButtonInput = new TouchButtonInput(InputFactory.getInstance().MAX - 35, "Button 1")

    val UP : TouchButtonInput = new TouchButtonInput(InputFactory.getInstance().MAX - 36, "Up Button")

    val LEFT : TouchButtonInput = new TouchButtonInput(InputFactory.getInstance().MAX - 37, "Left Button")

    val RIGHT : TouchButtonInput = new TouchButtonInput(InputFactory.getInstance().MAX - 38, "Right Button")

    val DOWN : TouchButtonInput = new TouchButtonInput(InputFactory.getInstance().MAX - 39, "Down Button")

    val NONE : TouchButtonInput = new TouchButtonInput(InputFactory.getInstance().MAX - 40, "No Button")

    private var initialized : Boolean = false

    private val list : BasicArrayList = new BasicArrayListD()

    def init(inputToGameKeyMapping : InputToGameKeyMapping) : Unit = this.synchronized {
        if (!this.initialized) {
            this.initialized = true
            this.list.add(this.UP)
            this.list.add(this.LEFT)
            this.list.add(this.RIGHT)
            this.list.add(this.DOWN)
            this.list.add(SPECIAL_BUTTON_TWO)
            this.list.add(SPECIAL_BUTTON_FOUR)
            this.list.add(SPECIAL_BUTTON_THREE)
            this.list.add(SPECIAL_BUTTON_ONE)
            this.list.add(SPECIAL_BUTTON_FIVE)
            this.list.add(SPECIAL_BUTTON_SIX)
            this.updateAllList(this.list, inputToGameKeyMapping)
        }
    }

    def updateAll(inputToGameKeyMapping : InputToGameKeyMapping) : Unit = {
        this.updateAllList(this.getList(), inputToGameKeyMapping)
    }

    def updateAllList(list : BasicArrayList, inputToGameKeyMapping : InputToGameKeyMapping) : Unit = {
        this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().START).appendint(list.size()).toString(), this, "updateAll")

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                var touchButtonInput : TouchButtonInput = list.get(index).asInstanceOf[TouchButtonInput]
                touchButtonInput.update(inputToGameKeyMapping)
                index -= 1
            }
        }
    }

    def getList() : BasicArrayList = {
        return this.list
    }

}

object BasicTouchInputFactory {
    //extends BaseTouchInputFactory
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : BasicTouchInputFactory = {
        if (BasicTouchInputFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            BasicTouchInputFactory.instance = new BasicTouchInputFactory()
        }
        return BasicTouchInputFactory.instance.asInstanceOf[BasicTouchInputFactory]
    }

}


