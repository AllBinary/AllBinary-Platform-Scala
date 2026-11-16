/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media

import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonLabels

/**  *  * @author User  */
class ScaleProperties {
    import _root_.org.allbinary.media.ScaleProperties.{instance as _, *}
    def instance : ScaleProperties = _root_.org.allbinary.media.ScaleProperties.instance

    //    public int height = 960;
    var scaleX : Float = 0.0f

    var scaleY : Float = 0.0f

    var scaleWidth : Int = 0

    var scaleHeight : Int = 0

    var shouldScale : Boolean = false

    override def toString() : String = {
        return new StringMaker().append(CommonLabels.getInstance().COLON_SEP).appendboolean(this.shouldScale).append("scaleX: ").appendfloat(this.scaleX).append("scaleY: ").appendfloat(this.scaleY).append("scaleWidth: ").appendint(this.scaleWidth).append("scaleHeight: ").appendint(this.scaleHeight).toString()
    }

}

object ScaleProperties {
    val instance : ScaleProperties = new ScaleProperties()

}


