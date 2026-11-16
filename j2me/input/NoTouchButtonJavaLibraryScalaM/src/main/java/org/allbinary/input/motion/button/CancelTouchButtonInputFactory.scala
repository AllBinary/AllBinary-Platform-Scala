/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.game.input.InputFactory
import _root_.org.allbinary.logic.NullUtil

class CancelTouchButtonInputFactory private() {
    import _root_.org.allbinary.input.motion.button.CancelTouchButtonInputFactory.{*}

    private val cancelInputArray : Array[TouchButtonInput] = new Array[TouchButtonInput](InputFactory.getInstance().MAX)

    //Constructor
    {
        val basicTouchInputFactory : BasicTouchInputFactory = BasicTouchInputFactory.getInstance()

        {
            var index : Int = this.cancelInputArray.length - 1
            while (index >= 0) {
                this.cancelInputArray(index) = basicTouchInputFactory.NONE
                index -= 1
            }
        }
        this.cancelInputArray(basicTouchInputFactory.UP.getId()) = basicTouchInputFactory.DOWN
        this.cancelInputArray(basicTouchInputFactory.DOWN.getId()) = basicTouchInputFactory.UP
        this.cancelInputArray(basicTouchInputFactory.LEFT.getId()) = basicTouchInputFactory.RIGHT
        this.cancelInputArray(basicTouchInputFactory.RIGHT.getId()) = basicTouchInputFactory.LEFT
    }

    def getCancel(touchButtonInput : TouchButtonInput) : TouchButtonInput = {
        return this.cancelInputArray(touchButtonInput.getId())
    }

}

object CancelTouchButtonInputFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : CancelTouchButtonInputFactory = {
        if (CancelTouchButtonInputFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            CancelTouchButtonInputFactory.instance = new CancelTouchButtonInputFactory()
        }
        return CancelTouchButtonInputFactory.instance.asInstanceOf[CancelTouchButtonInputFactory]
    }

}


