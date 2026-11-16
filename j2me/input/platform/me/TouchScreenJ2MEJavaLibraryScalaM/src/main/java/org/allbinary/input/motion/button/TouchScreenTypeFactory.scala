/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button


class TouchScreenTypeFactory {
    import _root_.org.allbinary.input.motion.button.TouchScreenTypeFactory.{*}

    def TouchScreenTypeFactory() : Unit = {
        val touchScreenFactory : TouchScreenFactory = TouchScreenFactory.getInstance()
        touchScreenFactory.setTouch(true)
    }

}

object TouchScreenTypeFactory {
    private val instance : TouchScreenTypeFactory = new TouchScreenTypeFactory()

    def getInstance() : TouchScreenTypeFactory = {
        return TouchScreenTypeFactory.instance
    }

}


