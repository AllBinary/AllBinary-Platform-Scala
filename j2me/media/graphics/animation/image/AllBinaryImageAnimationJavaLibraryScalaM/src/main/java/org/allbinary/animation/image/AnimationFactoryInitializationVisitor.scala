/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps

/**  *  * @author User  */
class AnimationFactoryInitializationVisitor {

    var width : Int = 0

    var height : Int = 0

    var dx : Int = 0

    var dy : Int = 0

    var originalDx : Int = 0

    var originalDy : Int = 0

    def visit() : Unit = {
    }

    override def toString() : String = {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val commonLabels : CommonLabels = CommonLabels.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(PositionStrings.getInstance().DX_LABEL).appendfloat(this.dx.toFloat)
        stringBuffer.append(PositionStrings.getInstance().DY_LABEL).appendfloat(this.dy.toFloat)
        stringBuffer.append(commonLabels.WIDTH_LABEL)
        stringBuffer.appendint(this.width)
        stringBuffer.append(commonSeps.SPACE)
        stringBuffer.append(commonLabels.HEIGHT_LABEL)
        stringBuffer.appendint(this.height)
        return stringBuffer.toString()
    }

}


