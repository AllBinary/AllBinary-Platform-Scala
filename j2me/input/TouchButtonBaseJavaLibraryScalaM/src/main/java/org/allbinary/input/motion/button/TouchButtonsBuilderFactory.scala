/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button


class TouchButtonsBuilderFactory {
    import _root_.org.allbinary.input.motion.button.TouchButtonsBuilderFactory.{NO_TOUCH_BUTTON_BUILDER_FACTORY as _, *}
    def NO_TOUCH_BUTTON_BUILDER_FACTORY : TouchButtonsBuilderFactory = _root_.org.allbinary.input.motion.button.TouchButtonsBuilderFactory.NO_TOUCH_BUTTON_BUILDER_FACTORY

    def getInstance() : BaseTouchInput = {
        return NoButtonsTouchInputFactory.getInstance()
    }

}

object TouchButtonsBuilderFactory {
    val NO_TOUCH_BUTTON_BUILDER_FACTORY : TouchButtonsBuilderFactory = new TouchButtonsBuilderFactory()

}


