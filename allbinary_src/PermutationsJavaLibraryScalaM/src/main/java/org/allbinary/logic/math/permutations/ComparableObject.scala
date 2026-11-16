/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math.permutations

import _root_.org.allbinary.TsUtil

/**  *  * @author user  */
class ComparableObject extends Comparable[Object] {

    override def compareTo(anyType : Object) : Int = {
        if (TsUtil.getInstance().hashCode(this) < TsUtil.getInstance().hashCode(anyType)) {
            return -1
        } else if (TsUtil.getInstance().hashCode(this) > TsUtil.getInstance().hashCode(anyType)) {
            return 1
        }
        return 0
    }

}


