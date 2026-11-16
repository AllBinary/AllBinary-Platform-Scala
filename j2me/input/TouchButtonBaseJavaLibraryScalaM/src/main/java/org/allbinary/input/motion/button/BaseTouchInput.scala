/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil

/**  *  * @author user  */
class BaseTouchInput() {

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val basicArrayListUtil : BasicArrayListUtil = BasicArrayListUtil.getInstance()

    /**      * @return the list      */
    def getList() : BasicArrayList = {
        return this.basicArrayListUtil.getImmutableInstance()
    }

    override def toString() : String = {
        return this.getClass().getName()
    }

}


