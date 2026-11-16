/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button


/**  *  * @author User  */
class TouchScreenTypesFactory {
    import _root_.org.allbinary.input.motion.button.TouchScreenTypesFactory.{*}

    val FINGER : TouchScreenType = new TouchScreenType("Finger")

    val NOTOUCH : TouchScreenType = new TouchScreenType("No Touch")

    val STYLUS : TouchScreenType = new TouchScreenType("Stylus")

    val UNDEFINED : TouchScreenType = new TouchScreenType("Undefined")

}

object TouchScreenTypesFactory {
    private val instance : TouchScreenTypesFactory = new TouchScreenTypesFactory()

    /**      * @return the instance      */
    def getInstance() : TouchScreenTypesFactory = {
        return TouchScreenTypesFactory.instance
    }

}


