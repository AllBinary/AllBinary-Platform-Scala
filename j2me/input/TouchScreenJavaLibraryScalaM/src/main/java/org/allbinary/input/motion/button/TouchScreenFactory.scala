/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

class TouchScreenFactory private() {
    import _root_.org.allbinary.input.motion.button.TouchScreenFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private var touch : Boolean = false

    private var multiTouch : Boolean = false

    private var multiTouchDistinct : Boolean = false

    private var touchScreenType : TouchScreenType = TouchScreenTypesFactory.getInstance().NOTOUCH

    //Constructor
    {
        try {
            //System.out.println("Hardware: " + hardwareString);
            this.setTouch(true)
            /*             if(hardwareString.indexOf(TOUCHSCREEN) >= 0)             {                 //System.out.println("Touch");                 this.setTouch(true);             }             else                 if(hardwareString.length() < 400)             {                     //System.out.println("Touch for Emulator");                     this.setTouch(true);             }                 else                 {                     //System.out.println("No Touch");                     this.setTouch(false);                 }                 */
            this.setMultiTouch(false)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, TouchScreenFactory.SINGLETON, commonStrings.GET_INSTANCE, e)
            }
        }
    }

    def setMultiTouch(multiTouch : Boolean) : Unit = {
        this.multiTouch = multiTouch
    }

    def isMultiTouch() : Boolean = {
        return this.multiTouch
    }

    def setTouch(touch : Boolean) : Unit = {
        this.touch = touch
    }

    def isTouch() : Boolean = {
        return this.touch
    }

    def setMultiTouchDistinct(multiTouchDistinct : Boolean) : Unit = {
        this.multiTouchDistinct = multiTouchDistinct
    }

    def isMultiTouchDistinct() : Boolean = {
        return this.multiTouchDistinct
    }

    def setTouchScreenType(touchScreenType : TouchScreenType) : Unit = {
        this.touchScreenType = touchScreenType
    }

    def getTouchScreenType() : TouchScreenType = {
        return this.touchScreenType
    }

    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        /*         private boolean touch;          private boolean multiTouch;         private boolean multiTouchDistinct;                  private TouchScreenType touchScreenType;         */
        stringBuffer.append("TouchScreen: ")
        stringBuffer.appendboolean(this.isTouch())
        stringBuffer.append(" MultiTouch: ")
        stringBuffer.appendboolean(this.isMultiTouch())
        stringBuffer.append(" Distinct MultiTouch: ")
        stringBuffer.appendboolean(this.isMultiTouchDistinct())
        stringBuffer.append(" TouchScreenType: ")
        stringBuffer.append(StringUtil.getInstance().toString(this.getTouchScreenType()))
        return stringBuffer.toString()
    }

}

object TouchScreenFactory {
    private val SINGLETON : TouchScreenFactory = new TouchScreenFactory()

    def getInstance() : TouchScreenFactory = {
        return TouchScreenFactory.SINGLETON
    }

}


