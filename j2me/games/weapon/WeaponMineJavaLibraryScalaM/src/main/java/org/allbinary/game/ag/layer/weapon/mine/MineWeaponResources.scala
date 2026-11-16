/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.layer.weapon.mine

import _root_.org.allbinary.game.layer.resources.BasicGameResources
import _root_.org.allbinary.logic.NullUtil

/**  *  * @author Berthelot, Travis  * @version 1.0  */
class MineWeaponResources() extends BasicGameResources {
    import _root_.org.allbinary.game.ag.layer.weapon.mine.MineWeaponResources.{*}

    val DROP_TEXT_RESOURCE : String = "/mine_drop_text_20_by_20.png"

    val DROP_RESOURCE : String = "/mine_drop_20_by_20.png"

    val DROP_ICON_RESOURCE : String = "/mine_drop_icon_20_by_20.png"

    //Constructor
    {
        val ROOT : String = "/mine"
        val SMALL : String = "_20_by_20.png"
        val MEDIUM : String = SMALL
        val SIZE_FOUR : String = SMALL
        val SIZE_FIVE : String = SMALL
        val SIZE_SIX : String = SMALL
        val SIZE : Array[String] = Array[String](SMALL, MEDIUM, SIZE_FOUR, SIZE_FIVE, SIZE_SIX)
        super.init(ROOT, SIZE)
    }

}

object MineWeaponResources {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : MineWeaponResources = {
        if (MineWeaponResources.instance eq NullUtil.getInstance().NULL_OBJECT) {
            MineWeaponResources.instance = new MineWeaponResources()
        }
        return MineWeaponResources.instance.asInstanceOf[MineWeaponResources]
    }

}


