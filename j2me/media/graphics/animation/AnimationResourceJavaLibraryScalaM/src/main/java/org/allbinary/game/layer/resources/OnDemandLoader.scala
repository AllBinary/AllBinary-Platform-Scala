/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.resources

import _root_.org.allbinary.animation.resource.BaseResourceAnimationInterfaceFactoryInterfaceFactory
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory
import _root_.org.allbinary.game.layer.GameLayerPlacementInterfaceBasicArrayListFactoryInterfaceFactory
import _root_.org.allbinary.game.layer.LayerPlacementInterfaceBasicArrayListFactoryInterface
import _root_.org.allbinary.game.resource.ResourceLoadingLevelFactory
import _root_.org.allbinary.image.ImageCache
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonStrings

class OnDemandLoader(param_onDemandResourcesFactory : OnDemandResourcesFactory, param_gameLayerPlacementInterfaceBasicArrayListFactoryInterfaceFactory : GameLayerPlacementInterfaceBasicArrayListFactoryInterfaceFactory, param_resourceAnimationInterfaceFactoryInterfaceFactory : BaseResourceAnimationInterfaceFactoryInterfaceFactory) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var onDemandResourcesFactory : OnDemandResourcesFactory = null

    private var gameLayerPlacementInterfaceBasicArrayListFactoryInterfaceFactory : GameLayerPlacementInterfaceBasicArrayListFactoryInterfaceFactory = null

    private var resourceAnimationInterfaceFactoryInterfaceFactory : BaseResourceAnimationInterfaceFactoryInterfaceFactory = null

    //Constructor
    {
        val onDemandResourcesFactory : OnDemandResourcesFactory = param_onDemandResourcesFactory
        val gameLayerPlacementInterfaceBasicArrayListFactoryInterfaceFactory : GameLayerPlacementInterfaceBasicArrayListFactoryInterfaceFactory = param_gameLayerPlacementInterfaceBasicArrayListFactoryInterfaceFactory
        val resourceAnimationInterfaceFactoryInterfaceFactory : BaseResourceAnimationInterfaceFactoryInterfaceFactory = param_resourceAnimationInterfaceFactoryInterfaceFactory
        this.onDemandResourcesFactory = onDemandResourcesFactory
        this.gameLayerPlacementInterfaceBasicArrayListFactoryInterfaceFactory = gameLayerPlacementInterfaceBasicArrayListFactoryInterfaceFactory
        this.resourceAnimationInterfaceFactoryInterfaceFactory = resourceAnimationInterfaceFactoryInterfaceFactory
    }

    def init(imageCache : ImageCache, level : Int, loadingString : String) : Unit = {
        val resourceLoadingLevelFactory : ResourceLoadingLevelFactory = ResourceLoadingLevelFactory.getInstance()
        if (Features.getInstance().isFeature(MainFeatureFactory.getInstance().LOAD_ALL)) {
            if (this.resourceAnimationInterfaceFactoryInterfaceFactory.isInitialized()) {
                return
            }
            this.initAll(imageCache, loadingString)
        } else if (level != resourceLoadingLevelFactory.LOAD_ALL.getLevel()) {
            val layerPlacementInterfaceBasicArrayListFactoryInterface : LayerPlacementInterfaceBasicArrayListFactoryInterface = this.gameLayerPlacementInterfaceBasicArrayListFactoryInterfaceFactory.getInstance(level)
            this.initLevel(layerPlacementInterfaceBasicArrayListFactoryInterface, imageCache, level, loadingString)
        }
    }

    private def initAll(imageCache : ImageCache, loadingString : String) : Unit = {
        var index : Int = 0
        val portion : Int = 120
        var onDemandResources : OnDemandResources = null

        {
            var onDemandIndex : Int = this.onDemandResourcesFactory.size()
            while ({ onDemandIndex -= 1; onDemandIndex } >= 0) {
                onDemandResources = this.onDemandResourcesFactory.remove(onDemandIndex)
                if (onDemandResources ne OnDemandResources.NULL_ON_DEMAND_RESOURCES) {
                    index = onDemandResources.initAt(imageCache, this.resourceAnimationInterfaceFactoryInterfaceFactory, portion, loadingString, index)
                }
            }
        }
    }

    private def initLevel(layerPlacementInterfaceBasicArrayListFactoryInterface : LayerPlacementInterfaceBasicArrayListFactoryInterface, imageCache : ImageCache, level : Int, loadingString : String) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        // PreLogUtil.put(commonStrings.START_LABEL + level, this, "initLevel");
        val portion : Int = 120
        var index : Int = 0
        val onDemandArray : Array[Int] = layerPlacementInterfaceBasicArrayListFactoryInterface.getOnDemandResources()
        PreLogUtil.put(new StringMaker().append(commonStrings.START).appendint(onDemandArray.length).toString(), this, "initLevel")
        var onDemandResources : OnDemandResources = null

        {
            var onDemandIndex : Int = onDemandArray.length
            while ({ onDemandIndex -= 1; onDemandIndex } >= 0) {
                onDemandResources = this.onDemandResourcesFactory.remove(onDemandArray(onDemandIndex))
                //if null then it is already loaded
                if (onDemandResources ne OnDemandResources.NULL_ON_DEMAND_RESOURCES) {
                    index = onDemandResources.initAt(imageCache, this.resourceAnimationInterfaceFactoryInterfaceFactory, portion, loadingString, index)
                }
            }
        }
    }

}


