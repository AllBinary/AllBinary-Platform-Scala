/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.form

import _root_.org.allbinary.game.identification.GroupCommonFactory
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.game.layer.item.LayerInterfaceFactoryImageItem
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.direction.DirectionFactory
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.layer.LayerInterfaceFactoryInterface
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory
import _root_.org.allbinary.util.ABHashtable

/**  *  * @author user  */
class RTSFormInput(param_groupInterfaceArray : Array[Group]) {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val groupCommonFactory : GroupCommonFactory = GroupCommonFactory.getInstance()

    private val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    val newUnconstructedRTSLayerInterfaceArray : Array[CollidableDestroyableDamageableLayer] = new Array[CollidableDestroyableDamageableLayer](7)

    var groupInterfaceArray : Array[Group] = null

    private var selectedGeographicCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    private var stickyItemSelected : Boolean = false

    private var selectedStickyItemIndex : Int = 0

    private var selectedStickyItem : ABCustomItem = ABCustomItem.getNullInstance()

    //Constructor
    {
        val groupInterfaceArray : Array[Group] = param_groupInterfaceArray
        //this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR);
        val size : Int = this.newUnconstructedRTSLayerInterfaceArray.length

        {
            var index : Int = 0
            while (index < size) {
                this.newUnconstructedRTSLayerInterfaceArray(index) = CollidableDestroyableDamageableLayer.getNullInstance()
                index += 1
            }
        }
        this.groupInterfaceArray = groupInterfaceArray
        this.hashtable.put(DirectionFactory.getInstance().NAME, DirectionFactory.getInstance().DOWN)
        //throw new Exception("No Group Provided");
        if (groupInterfaceArray != null) {
            this.hashtable.put(this.groupCommonFactory.ID, groupInterfaceArray)
        }
    }

    def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
    }

    def processAtPoint(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, point : GPoint) : Unit = {
        val index : Int = this.getIndexAt(rtsPlayerLayerInterface, point)
        if (index < 0) {
            return
        }
        val scrollSelectionForm : ScrollSelectionForm = rtsPlayerLayerInterface.getCurrentScrollSelectionForm()
        //this.getItemAt(rtsPlayerLayerInterface, point);
        val item : ABCustomItem = scrollSelectionForm.get(index)
        if (item == null) {
            return
        }
        this.processGameSpecific(associatedRtsLayer, rtsPlayerLayerInterface, layerManager, item, index)
    }

    def process(layerManager : AllBinaryLayerManager) : Unit = {
        this.setAllBinaryGameLayerManager(layerManager.asInstanceOf[AllBinaryGameLayerManager])
    }

    def processGameSpecific(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, item : ABCustomItem, index : Int) : Unit = {
    }

    def processSticky(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, point : GPoint) : Boolean = {
        var index : Int = this.getIndexAt(rtsPlayerLayerInterface, point)
        if (index < 0) {
            return false
        }
        val scrollSelectionForm : ScrollSelectionForm = rtsPlayerLayerInterface.getCurrentScrollSelectionForm()
        //this.getItemAt(rtsPlayerLayerInterface, point);
        val item : ABCustomItem = scrollSelectionForm.get(index)
        if (item == null) {
            return false
        }
        this.processStickyGameSpecific(associatedRtsLayer, rtsPlayerLayerInterface, layerManager, item, index)
        return true
    }

    def processStickyGameSpecific(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, item : ABCustomItem, index : Int) : Unit = {
    }

    def getItemAt(rtsPlayerLayerInterface : RTSPlayerLayerInterface, point : GPoint) : ABCustomItem = {
        this.logUtil.putF(new StringMaker().append("Point: ").append(StringUtil.getInstance().toString(point)).toString(), this, "getItemAt")
        val scrollSelectionForm : ScrollSelectionForm = rtsPlayerLayerInterface.getCurrentScrollSelectionForm()
        return scrollSelectionForm.getSelectedItem(point)
    }

    def getIndexAt(rtsPlayerLayerInterface : RTSPlayerLayerInterface, point : GPoint) : Int = {
        this.logUtil.putF(new StringMaker().append("Point: ").append(StringUtil.getInstance().toString(point)).toString(), this, "getItemAt")
        val scrollSelectionForm : ScrollSelectionForm = rtsPlayerLayerInterface.getCurrentScrollSelectionForm()
        return scrollSelectionForm.getSelectedIndexForPoint(point)
    }

    def getInstance(layerManager : AllBinaryLayerManager, aItem : ABCustomItem, geographicMapCellPosition : GeographicMapCellPosition) : CollidableDestroyableDamageableLayer = {
        val item : LayerInterfaceFactoryImageItem = aItem.asInstanceOf[LayerInterfaceFactoryImageItem]
        val layerInterfaceFactoryInterface : LayerInterfaceFactoryInterface = item.getLayerInterfaceFactoryInterface()
        val cellPoint : GPoint = geographicMapCellPosition.getPoint()
        //this.geographicMapInterface.getCellPositionAt(cellPoint.getX(), cellPoint.getY())
        if (layerInterfaceFactoryInterface != null) {
            this.hashtable.put(AllBinaryGameLayerManager.ID, layerManager)
            return layerInterfaceFactoryInterface.getNextInstance(this.getHashtable(), cellPoint.getX(), cellPoint.getY(), cellPoint.getZ()).asInstanceOf[RTSLayer]
        }
        return CollidableDestroyableDamageableLayer.getNullInstance()
    }

    /**      * @return the selectedGeographicCellPosition      */
    def getSelectedGeographicCellPosition() : GeographicMapCellPosition = {
        return this.selectedGeographicCellPosition
    }

    /**      * @param selectedGeographicCellPosition      *            the selectedGeographicCellPosition to set      */
    def setSelectedGeographicCellPosition(selectedGeographicCellPosition : GeographicMapCellPosition) : Unit = {
        this.logUtil.putF(new StringMaker().append("Selected GeographicMapCellPosition: ").append(selectedGeographicCellPosition.toString()).toString(), this, "setSelectedGeographicCellPosition")
        this.selectedGeographicCellPosition = selectedGeographicCellPosition
    }

    /**      * @return the stickyItemSelected      */
    def isStickyItemSelected() : Boolean = {
        return this.stickyItemSelected
    }

    /**      * @param stickyItemSelected the stickyItemSelected to set      */
    def setStickyItemSelected(stickyItemSelected : Boolean) : Unit = {
        this.stickyItemSelected = stickyItemSelected
    }

    /**      * @return the selectedStickyItem      */
    def getSelectedStickyItem() : ABCustomItem = {
        return this.selectedStickyItem
    }

    /**      * @param selectedStickyItem the selectedStickyItem to set      */
    def setSelectedStickyItem(selectedStickyItem : ABCustomItem) : Unit = {
        this.selectedStickyItem = selectedStickyItem
    }

    /**      * @return the selectedStickyItemIndex      */
    def getSelectedStickyItemIndex() : Int = {
        return this.selectedStickyItemIndex
    }

    /**      * @param selectedStickyItemIndex the selectedStickyItemIndex to set      */
    def setSelectedStickyItemIndex(selectedStickyItemIndex : Int) : Unit = {
        this.selectedStickyItemIndex = selectedStickyItemIndex
    }

    def getHashtable() : ABHashtable[Object, Object] = {
        return this.hashtable
    }

}


