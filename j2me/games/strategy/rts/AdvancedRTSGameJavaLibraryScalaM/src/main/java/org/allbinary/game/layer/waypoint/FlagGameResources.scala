/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint

import _root_.org.allbinary.game.layer.resources.BasicGameResources
import _root_.org.allbinary.game.layer.resources.GameGraphicsResourceUtil
import _root_.org.allbinary.logic.string.StringUtil

class FlagGameResources() extends BasicGameResources {
    import _root_.org.allbinary.game.layer.waypoint.FlagGameResources.{*}

    var NAME : String = StringUtil.getInstance().EMPTY_STRING

    //public String RESOURCE_BASE;
    var RESOURCE_ICON_ANIMATION : String = StringUtil.getInstance().EMPTY_STRING

    var RESOURCE_ICON_BUILD : String = StringUtil.getInstance().EMPTY_STRING

    var RESOURCE_ICON : String = StringUtil.getInstance().EMPTY_STRING

    //private final static String EMPTY = "_empty";
    private val ICON_SIZE : String = "_64_by_64.png"

    override def append(ROOT : String, sizeString : String) : Unit = {
        super.append(ROOT, sizeString)
        var string : String = GameGraphicsResourceUtil.getInstance().getName()
        BasicGameResources.stringBuffer.delete(0, BasicGameResources.stringBuffer.length())
        BasicGameResources.stringBuffer.append(ROOT)
        BasicGameResources.stringBuffer.append(FlagGameResources.DESTROY)
        BasicGameResources.stringBuffer.append(string)
        BasicGameResources.stringBuffer.append(sizeString)
        this.RESOURCE_DESTROY = BasicGameResources.stringBuffer.toString()
        BasicGameResources.stringBuffer.delete(0, BasicGameResources.stringBuffer.length())
        BasicGameResources.stringBuffer.append(FlagGameResources.ICON)
        BasicGameResources.stringBuffer.append(ROOT)
        this.RESOURCE_ICON_ANIMATION = BasicGameResources.stringBuffer.toString()
        BasicGameResources.stringBuffer.delete(0, BasicGameResources.stringBuffer.length())
        BasicGameResources.stringBuffer.append(ROOT)
        BasicGameResources.stringBuffer.append(FlagGameResources.ICON)
        BasicGameResources.stringBuffer.append(string)
        BasicGameResources.stringBuffer.append(this.ICON_SIZE)
        this.RESOURCE_ICON = BasicGameResources.stringBuffer.toString()
        BasicGameResources.stringBuffer.delete(0, BasicGameResources.stringBuffer.length())
        BasicGameResources.stringBuffer.append(ROOT)
        BasicGameResources.stringBuffer.append(FlagGameResources.ICON_BUILD)
        BasicGameResources.stringBuffer.append(string)
        BasicGameResources.stringBuffer.append(this.ICON_SIZE)
        this.RESOURCE_ICON_BUILD = BasicGameResources.stringBuffer.toString()
    }

}

object FlagGameResources {
    private val ICON : String = "_icon"

    private val BUILD : String = "_build"

    private val DESTROY : String = "_destroy"

    private val ICON_BUILD : String = "_icon" + FlagGameResources.BUILD

}


