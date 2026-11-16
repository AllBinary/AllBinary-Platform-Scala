/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonSeps

class CurrentlyPressedTouchButtonSingletonDebug extends CurrentlyPressedTouchButtonSingleton {
    import _root_.org.allbinary.input.motion.button.CurrentlyPressedTouchButtonSingletonDebug.{*}

    private var string : String = StringUtil.getInstance().EMPTY_STRING

    private var listString : String = StringUtil.getInstance().EMPTY_STRING

    private var appendText : String = StringUtil.getInstance().EMPTY_STRING

    private val PRESSED_AND_FIRED : String = "pressed & fired"

    private val PRESSED_AND_NOT_FIRED : String = "pressed in button but not fired"

    private val ASSOCIATED_RELEASED_AND_FIRED : String = "assoc. rel & fired"

    private val RELEASED_AND_FIRED : String = "rel & fired 1"

    private val RELEASED_AND_FIRED_2 : String = "rel & fired 2"

    private val RELEASED_AND_NOT_FIRED : String = "rel & not fired"

    private def appendTouchButtonInput(append : String, touchButtonInput : TouchButtonInput) : Unit = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(touchButtonInput.toString())
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(append)
        this.appendText = stringBuffer.toString()
        this.string = new StringMaker().append(this.listString).append(this.appendText).toString()
    }

    private def append(append : String) : Unit = {
        this.appendText = new StringMaker().append(this.appendText).append(append).toString()
        this.string = new StringMaker().append(this.listString).append(this.appendText).toString()
    }

    def clearLog(x : Int, y : Int) : Unit = {
        this.appendText = new StringMaker().append(GPoint.toStringStatic(x, y, 0)).append(CommonSeps.getInstance().SPACE).toString()
        this.string = new StringMaker().append(this.listString).append(this.appendText).toString()
    }

    def releaseAndNotFired() : Unit = {
        this.append(this.RELEASED_AND_NOT_FIRED)
    }

    def releaseAndFired(touchButtonInput : TouchButtonInput) : Unit = {
        this.appendTouchButtonInput(this.RELEASED_AND_FIRED, touchButtonInput)
    }

    def releaseAndFired2(touchButtonInput : TouchButtonInput) : Unit = {
        this.appendTouchButtonInput(this.RELEASED_AND_FIRED_2, touchButtonInput)
    }

    def releaseAndFiredAssociated(touchButtonInput : TouchButtonInput) : Unit = {
        this.appendTouchButtonInput(this.ASSOCIATED_RELEASED_AND_FIRED, touchButtonInput)
    }

    def pressedAndFired(touchButtonInput : TouchButtonInput) : Unit = {
        this.appendTouchButtonInput(this.PRESSED_AND_FIRED, touchButtonInput)
    }

    def pressedAndNotFired(touchButtonInput : TouchButtonInput) : Unit = {
        this.appendTouchButtonInput(this.PRESSED_AND_NOT_FIRED, touchButtonInput)
    }

    override def removeAt(index : Int) : TouchButtonInput = {
        var touchButtonInput : TouchButtonInput = super.removeAt(index)
        this.listString = this.list.toString()
        this.string = new StringMaker().append(this.listString).append(this.appendText).toString()
        return touchButtonInput
    }

    override def remove(touchButtonInput : TouchButtonInput) : Boolean = {
        var isRemoved : Boolean = super.remove(touchButtonInput)
        this.listString = this.list.toString()
        this.string = new StringMaker().append(this.listString).append(this.appendText).toString()
        return isRemoved
    }

    override def add(touchButtonInput : TouchButtonInput) : Unit = {
        super.add(touchButtonInput)
        this.listString = this.list.toString()
        this.string = new StringMaker().append(this.listString).append(this.appendText).toString()
    }

    override def toString() : String = {
        return this.string
    }

}

object CurrentlyPressedTouchButtonSingletonDebug {
    private val instanceC : CurrentlyPressedTouchButtonSingletonDebug = new CurrentlyPressedTouchButtonSingletonDebug()

    def getInstance() : CurrentlyPressedTouchButtonSingleton = {
        return CurrentlyPressedTouchButtonSingletonDebug.instanceC
    }

}


