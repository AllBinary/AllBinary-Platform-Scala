/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button


class TouchScreenFactory private() {
    import _root_.org.allbinary.input.motion.button.TouchScreenFactory.{*}

    private var multiTouch : Boolean = false

    private var touch : Boolean = false

    private var touchScreenType : TouchScreenType = TouchScreenTypesFactory.getInstance().NOTOUCH

    /*     public void setMultiTouch(boolean multiTouch)     {         this.multiTouch = multiTouch;     }     */
    def isMultiTouch() : Boolean = {
        return this.multiTouch
    }

    def setTouch(touch : Boolean) : Unit = {
    }

    def isTouch() : Boolean = {
        return this.touch
    }

    def getTouchScreenType() : TouchScreenType = {
        return this.touchScreenType
    }

}

object TouchScreenFactory {
    private val SINGLETON : TouchScreenFactory = new TouchScreenFactory()

    def getInstance() : TouchScreenFactory = {
        return TouchScreenFactory.SINGLETON
    }

}


