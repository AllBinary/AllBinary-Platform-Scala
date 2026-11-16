/*  * AllBinary Open License Version 1  * Copyright (c) 2026 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation


/**  *  * @author User  */
class ShapeTypeFactory {
    import _root_.org.allbinary.animation.ShapeTypeFactory.{*}

    val KEY_LINE : String = "line"

    val KEY_CIRCLE : String = "circle"

    val KEY_RECTANGLE : String = "rectangle"

    val KEY_RECT : String = "rect"

    val LINE : ShapeType = new ShapeType(KEY_LINE)

    val CIRCLE : ShapeType = new ShapeType(KEY_CIRCLE)

    val RECTANGLE : ShapeType = new ShapeType(KEY_RECTANGLE)

}

object ShapeTypeFactory {
    private val instance : ShapeTypeFactory = new ShapeTypeFactory()

    /**      * @return the instance      */
    def getInstance() : ShapeTypeFactory = {
        return ShapeTypeFactory.instance
    }

}


