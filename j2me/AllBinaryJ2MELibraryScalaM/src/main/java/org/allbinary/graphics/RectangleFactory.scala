/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics


class RectangleFactory {
    import _root_.org.allbinary.graphics.RectangleFactory.{SINGLETON as _, ARRAY_OF_ARRAYS as _, *}
    def SINGLETON : Rectangle = _root_.org.allbinary.graphics.RectangleFactory.SINGLETON
    def ARRAY_OF_ARRAYS : Array[Array[Rectangle]] = _root_.org.allbinary.graphics.RectangleFactory.ARRAY_OF_ARRAYS

}

object RectangleFactory {
    val SINGLETON : Rectangle = new Rectangle(PointFactory.getInstance().ZERO_ZERO, 0, 0)

    val ARRAY_OF_ARRAYS : Array[Array[Rectangle]] = Array.ofDim[Rectangle](0, 0)

}


