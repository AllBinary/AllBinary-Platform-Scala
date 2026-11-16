/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.identification

import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.math.SmallIntegerSingletonFactory

/**  *  * @author User  */
class GroupCommonFactory {
    import _root_.org.allbinary.game.identification.GroupCommonFactory.{*}

    val ID : Integer = SmallIntegerSingletonFactory.getInstance().getAt(10)

    val GROUP_NAME_LABEL : String = "Group Name: "

    val ID_LABEL : String = " Id: "

    val ADDING_LABEL : String = "Adding: "

    val TO_LABEL : String = " to: "

}

object GroupCommonFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : GroupCommonFactory = {
        if (GroupCommonFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            GroupCommonFactory.instance = new GroupCommonFactory()
        }
        return GroupCommonFactory.instance.asInstanceOf[GroupCommonFactory]
    }

}


