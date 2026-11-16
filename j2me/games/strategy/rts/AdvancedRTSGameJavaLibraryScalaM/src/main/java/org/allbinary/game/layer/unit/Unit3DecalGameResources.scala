/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.unit

import _root_.org.allbinary.game.layer.resources.BasicGameResources
import _root_.org.allbinary.game.layer.resources.GameGraphicsResourceUtil
import _root_.org.allbinary.AndroidUtil
import _root_.org.allbinary.game.configuration.feature.GraphicsFeatureFactory
import _root_.org.allbinary.logic.NullUtil

class Unit3DecalGameResources private() extends BasicGameResources {
    import _root_.org.allbinary.game.layer.unit.Unit3DecalGameResources.{*}

    //Constructor
    {
        val ROOT : String = "/unit_decal"
        val SMALL : String = "_40_by_40.png"
        val MEDIUM : String = SMALL
        val SIZE_FOUR : String = SMALL
        val SIZE_FIVE : String = SMALL
        val SIZE_SIX : String = SMALL
        val SIZE : Array[String] = Array[String](SMALL, MEDIUM, SIZE_FOUR, SIZE_FIVE, SIZE_SIX)
        super.init(ROOT, SIZE)
    }

    override def append(ROOT : String, sizeString : String) : Unit = {
        super.append(ROOT, sizeString)
    }

    override def getString() : String = {
        if (AndroidUtil.isAndroid()) {
            return GameGraphicsResourceUtil.getInstance().getStringForFeature(GraphicsFeatureFactory.getInstance().SPRITE_QUARTER_ROTATION_GRAPHICS)
        } else {
            return super.getString()
        }
        throw new IllegalStateException()
    }

}

object Unit3DecalGameResources {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : BasicGameResources = {
        if (Unit3DecalGameResources.instance eq NullUtil.getInstance().NULL_OBJECT) {
            Unit3DecalGameResources.instance = new Unit3DecalGameResources()
        }
        return Unit3DecalGameResources.instance.asInstanceOf[Unit3DecalGameResources]
    }

}


