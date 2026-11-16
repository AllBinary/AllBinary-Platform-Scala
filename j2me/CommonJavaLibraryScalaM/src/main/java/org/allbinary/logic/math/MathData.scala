/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math

import _root_.org.allbinary.string.CommonPhoneStrings
import _root_.org.allbinary.string.CommonSeps

class MathData private() {
    import _root_.org.allbinary.logic.math.MathData.{*}

    var EQUALS : String = null

    val PLUS : String = "+"

    val GREATER_THAN : String = ">"

    var MINUS : String = null

    var DIVIDE : String = null

    var MULTIPLY : String = null

    //Constructor
    {
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        this.EQUALS = commonSeps.EQUALS
        this.MINUS = commonSeps.DASH
        this.DIVIDE = commonSeps.FORWARD_SLASH
        this.MULTIPLY = CommonPhoneStrings.getInstance().STAR
    }

}

object MathData {
    private val instance : MathData = new MathData()

    def getInstance() : MathData = {
        return MathData.instance
    }

}


