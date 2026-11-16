/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class CurrentlyPressedTouchButtonSingleton() {
    import _root_.org.allbinary.input.motion.button.CurrentlyPressedTouchButtonSingleton.{*}

    val list : BasicArrayList = new BasicArrayListD()

    def size() : Int = {
        return this.list.size()
    }

    def removeAt(index : Int) : TouchButtonInput = {
        return this.list.removeAt(index).asInstanceOf[TouchButtonInput]
    }

    def remove(touchButtonInput : TouchButtonInput) : Boolean = {
        return this.list.remove(touchButtonInput)
    }

    def get(index : Int) : TouchButtonInput = {
        return this.list.objectArray(index).asInstanceOf[TouchButtonInput]
    }

    def contains(touchButtonInput : TouchButtonInput) : Boolean = {
        return this.list.contains(touchButtonInput)
    }

    def add(touchButtonInput : TouchButtonInput) : Unit = {
        this.list.add(touchButtonInput)
    }

}

object CurrentlyPressedTouchButtonSingleton {
    private val instance : CurrentlyPressedTouchButtonSingleton = new CurrentlyPressedTouchButtonSingleton()

    def getInstance() : CurrentlyPressedTouchButtonSingleton = {
        return CurrentlyPressedTouchButtonSingleton.instance
    }

}


