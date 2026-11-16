/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.resource

import _root_.org.allbinary.animation.FeaturedAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class FeatureResourceInitializationUtil {
    import _root_.org.allbinary.game.resource.FeatureResourceInitializationUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def init(level : Int) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF(commonStrings.START, this, commonStrings.INIT)
        var featuredResourceFactory : FeaturedResourceFactory = FeaturedAnimationInterfaceFactoryInterfaceFactory.getInstance()
        featuredResourceFactory.init(level)
        // opengl change
        FeaturedResourceRelativeRelationshipFactory.getInstance().init(level)
    }

}

object FeatureResourceInitializationUtil {
    private val instance : FeatureResourceInitializationUtil = new FeatureResourceInitializationUtil()

    def getInstance() : FeatureResourceInitializationUtil = {
        return FeatureResourceInitializationUtil.instance
    }

}


