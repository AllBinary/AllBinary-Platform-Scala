/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.identification

import _root_.org.allbinary.logic.NullUtil

class BasicGroupFactory {
    import _root_.org.allbinary.game.identification.BasicGroupFactory.{*}

    val NAME : String = "GROUP_NAME"

    val NO_SUCH_GROUP : String = "No Such Group: "

    val GOOD : Group = new Group("Good Guys", (0).toShort)

    val ENEMY : Group = new Group("Bad Guys", (1).toShort)

    val ENEMY_ON_LEVEL : Group = new Group("Bad Guys on Level", (2).toShort)

    val NONE : Group = new Group("Not On A Team", (3).toShort)

    val GOOD_ARRAY : Array[Group] = Array[Group](this.GOOD)

    val ENEMY_ARRAY : Array[Group] = Array[Group](this.ENEMY)

    val ENEMY_ON_LEVEL_ARRAY : Array[Group] = Array[Group](this.ENEMY, this.ENEMY_ON_LEVEL)

    val NONE_ARRAY : Array[Group] = Array[Group](this.NONE)

}

object BasicGroupFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : BasicGroupFactory = {
        if (BasicGroupFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            BasicGroupFactory.instance = new BasicGroupFactory()
        }
        return BasicGroupFactory.instance.asInstanceOf[BasicGroupFactory]
    }

}


