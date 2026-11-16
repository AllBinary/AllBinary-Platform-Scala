/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.resources

import _root_.org.allbinary.animation.resource.BaseResourceAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.image.ImageCache
import _root_.org.allbinary.logic.communication.log.LogUtil

class OnDemandResources() {
    import _root_.org.allbinary.game.layer.resources.OnDemandResources.{NULL_ON_DEMAND_RESOURCES as _, *}
    def NULL_ON_DEMAND_RESOURCES : OnDemandResources = _root_.org.allbinary.game.layer.resources.OnDemandResources.NULL_ON_DEMAND_RESOURCES

    val logUtil : LogUtil = LogUtil.getInstance()

    def waitFor() : Unit = {
    }

    def init() : Unit = {
    }

    def initAt(imageCache : ImageCache, resourceAnimationInterfaceFactoryInterfaceFactory : BaseResourceAnimationInterfaceFactoryInterfaceFactory, portion : Int, loadingString : String, index : Int) : Int = {
        return 0
    }

}

object OnDemandResources {
    val NULL_ON_DEMAND_RESOURCES : OnDemandResources = new OnDemandResources()

}


