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

class BasicTouchInputFactory private() {
    import _root_.org.allbinary.input.motion.button.BasicTouchInputFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    var SPECIAL_BUTTON_SEVEN_TESTING_ONLY : TouchButtonInput = null

    var SPECIAL_BUTTON_EIGHT_TESTING_ONLY : TouchButtonInput = null

    var SPECIAL_BUTTON_SIX : TouchButtonInput = null

    var SPECIAL_BUTTON_FIVE : TouchButtonInput = null

    var SPECIAL_BUTTON_FOUR : TouchButtonInput = null

    var SPECIAL_BUTTON_THREE : TouchButtonInput = null

    var SPECIAL_BUTTON_TWO : TouchButtonInput = null

    var SPECIAL_BUTTON_ONE : TouchButtonInput = null

    var UP : TouchButtonInput = null

    var LEFT : TouchButtonInput = null

    var RIGHT : TouchButtonInput = null

    var DOWN : TouchButtonInput = null

    var NONE : TouchButtonInput = null

    private var initialized : Boolean = false

    private val list : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        var MAX : Int = InputFactory.getInstance().MAX
        this.SPECIAL_BUTTON_SEVEN_TESTING_ONLY = new TouchButtonInput(MAX - 41, "Button 7 - Testing Only May Cross Over Key Values")
        this.SPECIAL_BUTTON_EIGHT_TESTING_ONLY = new TouchButtonInput(MAX - 42, "Button 8 - Testing Only May Cross Over Key Values")
        this.SPECIAL_BUTTON_SIX = new TouchButtonInput(MAX - 30, "Button 6")
        this.SPECIAL_BUTTON_FIVE = new TouchButtonInput(MAX - 31, "Button 5")
        this.SPECIAL_BUTTON_FOUR = new TouchButtonInput(MAX - 32, "Button 4")
        this.SPECIAL_BUTTON_THREE = new TouchButtonInput(MAX - 33, "Button 3")
        this.SPECIAL_BUTTON_TWO = new TouchButtonInput(MAX - 34, "Button 2")
        this.SPECIAL_BUTTON_ONE = new TouchButtonInput(MAX - 35, "Button 1")
        this.UP = new TouchButtonInput(MAX - 36, "Up Button")
        this.LEFT = new TouchButtonInput(MAX - 37, "Left Button")
        this.RIGHT = new TouchButtonInput(MAX - 38, "Right Button")
        this.DOWN = new TouchButtonInput(MAX - 39, "Down Button")
        this.NONE = new TouchButtonInput(MAX - 40, "No Button")
    }

    def init(inputToGameKeyMapping : InputToGameKeyMapping) : Unit = this.synchronized {
        if (!this.initialized) {
            this.initialized = true
            this.list.add(this.UP)
            this.list.add(this.LEFT)
            this.list.add(this.RIGHT)
            this.list.add(this.DOWN)
            this.list.add(this.SPECIAL_BUTTON_TWO)
            this.list.add(this.SPECIAL_BUTTON_FOUR)
            this.list.add(this.SPECIAL_BUTTON_THREE)
            this.list.add(this.SPECIAL_BUTTON_ONE)
            this.list.add(this.SPECIAL_BUTTON_FIVE)
            this.list.add(this.SPECIAL_BUTTON_SIX)
            this.list.add(this.SPECIAL_BUTTON_SIX)
            this.list.add(this.SPECIAL_BUTTON_SEVEN_TESTING_ONLY)
            this.list.add(this.SPECIAL_BUTTON_EIGHT_TESTING_ONLY)
            this.updateAllFromList(this.list, inputToGameKeyMapping)
        }
    }

    def updateAll(inputToGameKeyMapping : InputToGameKeyMapping) : Unit = {
        this.updateAllFromList(this.list, inputToGameKeyMapping)
    }

    def updateAllFromList(list : BasicArrayList, inputToGameKeyMapping : InputToGameKeyMapping) : Unit = {
        this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().START_LABEL).appendint(list.size()).toString(), this, "updateAll")
        var touchButtonInput : TouchButtonInput = null

        {
            var index : Int = list.size() - 1
            while (index >= 0) {
                touchButtonInput = list.objectArray(index).asInstanceOf[TouchButtonInput]
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
    // extends BaseTouchInputFactory
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : BasicTouchInputFactory = {
        if (BasicTouchInputFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            BasicTouchInputFactory.instance = new BasicTouchInputFactory()
        }
        return BasicTouchInputFactory.instance.asInstanceOf[BasicTouchInputFactory]
    }

}


