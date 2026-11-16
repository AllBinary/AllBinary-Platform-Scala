/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.unit

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.ImageItem
import _root_.org.allbinary.game.layer.RTSGameStrings
import _root_.org.allbinary.game.layer.item.LayerInterfaceFactoryImageItem
import _root_.org.allbinary.game.layer.item.RTSLayerTextAnimation
import _root_.org.allbinary.game.layer.resources.BasicGameResources
import _root_.org.allbinary.game.layer.waypoint.FlagGameResources
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.image.GameFeatureImageCacheFactory
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.form.item.CustomItemUtil
import _root_.org.allbinary.graphics.form.item.ItemArraySingletonFactoryInterface
import _root_.org.allbinary.image.ImageCache
import _root_.org.allbinary.layer.LayerInterfaceFactoryInterface

/**  *  * @author user  */
class UnitItemArrayFactory(param_resources : Array[BasicGameResources]) extends ItemArraySingletonFactoryInterface {
    import _root_.org.allbinary.game.layer.unit.UnitItemArrayFactory.{*}

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private var basicColor : BasicColor = BasicColorFactory.getInstance().WHITE

    private var resources : Array[BasicGameResources] = null

    //Constructor
    {
        val resources : Array[BasicGameResources] = param_resources
        this.resources = resources
    }

    def createFlagItem(flagResources : FlagGameResources, layerInterfaceFactoryInterface : LayerInterfaceFactoryInterface) : ABCustomItem = {
        var name : String = flagResources.NAME
        var index : Int = name.indexOf(this.commonSeps.SPACE)
        if (index >= 0) {
            name = name.substring(index)
        }
        return this.createNamedFlagItem(flagResources, name, layerInterfaceFactoryInterface)
    }

    def createNamedFlagItem(flagResources : FlagGameResources, name : String, layerInterfaceFactoryInterface : LayerInterfaceFactoryInterface) : ABCustomItem = {
        val IMAGE_CACHE : ImageCache = GameFeatureImageCacheFactory.getInstance()
        val image : Image = IMAGE_CACHE.getWithKey(flagResources.RESOURCE_ICON)
        val item : ABCustomItem = new LayerInterfaceFactoryImageItem(name, image, ImageItem.LAYOUT_DEFAULT, flagResources.NAME, this.basicColor, Array[Animation](new RTSLayerTextAnimation(RTSGameStrings.getInstance().DRAGGABLE, image)), layerInterfaceFactoryInterface)
        return item
    }

    /*     private CustomItem createItem(UnitGameResources unitResources,             CostLayerInterfaceFactoryInterface layerInterfaceFactoryInterface) throws Exception     {             ImageCache IMAGE_CACHE = GameFeatureImageCacheFactory.getInstance();              String name = unitResources.NAME;             int index = name.indexOf(this.commonSeps.SPACE);             if (index >= 0)             {                 name = name.substring(index);             }              Image image = IMAGE_CACHE.get(unitResources.RESOURCE_ICON);                          RTSLayerCostAnimation rtsLayerCostAnimation =                  new RTSLayerCostAnimation(image, layerInterfaceFactoryInterface);              LayerInterfaceFactoryImageItem layerInterfaceFactoryImageItem =                  new LayerInterfaceFactoryImageItem(                     name, image,                     ImageItem.LAYOUT_DEFAULT, unitResources.NAME, basicColor,                     new Animation[] {rtsLayerCostAnimation},                     layerInterfaceFactoryInterface);              //Buildings may need this at some point as well             TechEventHandler.getInstance().addListener(                     rtsLayerCostAnimation);                          return layerInterfaceFactoryImageItem;     }     */
    override def getItems() : Array[ABCustomItem] = {
        return UnitItemArrayFactory.ITEMS
    }

    def getResources() : Array[BasicGameResources] = {
        return this.resources
    }

    def indexOf(basicGameResources : BasicGameResources) : Int = {

        {
            var index : Int = this.resources.length - 1
            while (index >= 0) {
                if (this.resources(index) eq basicGameResources) {
                    return index
                }
                index -= 1
            }
        }
        return -1
    }

}

object UnitItemArrayFactory {
    private val ITEMS : Array[ABCustomItem] = CustomItemUtil.getInstance().CUSTOM_ITEM_ARRAY

}


