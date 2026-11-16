/*  * AllBinary Open License Version 1  * Copyright (c) 2007 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class TouchButtonsListBuilder extends BaseTouchInput {

    private val baseTouchInputList : BasicArrayList = new BasicArrayListD()

    def addList(list : BasicArrayList) : Unit = {
        val size : Int = this.baseTouchInputList.size()
        var baseTouchInput : BaseTouchInput = null

        {
            var index : Int = 0
            while (index < size) {
                baseTouchInput = this.baseTouchInputList.get(index).asInstanceOf[BaseTouchInput]
                list.addAllList(baseTouchInput.getList())
                index += 1
            }
        }
    }

    def add(baseTouchInput : BaseTouchInput) : Unit = {
        this.baseTouchInputList.add(baseTouchInput)
    }

}


