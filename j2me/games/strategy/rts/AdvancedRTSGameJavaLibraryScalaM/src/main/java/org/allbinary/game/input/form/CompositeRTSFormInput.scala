/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input.form

import _root_.org.allbinary.game.layer.RTSPlayerLayerInterface
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.layer.AllBinaryGameLayerManager
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.layer.AllBinaryLayerManager
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCompositeInterface
import _root_.org.allbinary.string.CommonLabels

/**  *  * @author user  */
class CompositeRTSFormInput(param_groupInterface : Array[Group], param_isPrimaryWaypointCreator : Boolean, param_itemIndex : Array[Int]) extends RTSFormInput(param_groupInterface) {

    private var rtsFormInputArray : Array[RTSFormInput] = null

    private var itemIndex : Array[Int] = null

    private var isPrimaryWaypointCreator : Boolean = false

    //Constructor
    {
        val groupInterface : Array[Group] = param_groupInterface
        val isPrimaryWaypointCreator : Boolean = param_isPrimaryWaypointCreator
        val itemIndex : Array[Int] = param_itemIndex
        this.itemIndex = itemIndex
        this.isPrimaryWaypointCreator = isPrimaryWaypointCreator
        this.rtsFormInputArray = new Array[RTSFormInput](2)
        this.rtsFormInputArray(0) = new WaypointRTSFormInput(this.groupInterfaceArray, isPrimaryWaypointCreator)
        this.rtsFormInputArray(1) = new UnitRTSFormInput(this.groupInterfaceArray)
    }

    override def setAllBinaryGameLayerManager(allBinaryGameLayerManager : AllBinaryGameLayerManager) : Unit = {
        super.setAllBinaryGameLayerManager(allBinaryGameLayerManager)
        val geographicMapCompositeInterface : GeographicMapCompositeInterface = allBinaryGameLayerManager.asInstanceOf[GeographicMapCompositeInterface]
        val geographicMapInterface : BasicGeographicMap = geographicMapCompositeInterface.getGeographicMapInterface()(0)
        val size : Int = this.rtsFormInputArray.length

        {
            var index : Int = 0
            while (index < size) {
                this.rtsFormInputArray(index).setAllBinaryGameLayerManager(allBinaryGameLayerManager)
                index += 1
            }
        }
    }

    override def processAtPoint(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, point : GPoint) : Unit = {
        var scrollSelectionForm : ScrollSelectionForm = rtsPlayerLayerInterface.getCurrentScrollSelectionForm()
        var index : Int = scrollSelectionForm.getSelectedIndexForPoint(point)
        if (this.isStickyItemSelected() && (associatedRtsLayer eq CollidableDestroyableDamageableLayer.getNullInstance())) {
            //Make sure your not drag and dropping units yet
            if (this.getSelectedStickyItemIndex() <= this.itemIndex(0)) {
                this.rtsFormInputArray(0).processAtPoint(associatedRtsLayer, rtsPlayerLayerInterface, layerManager, point)
            }
        } else if (index > this.itemIndex(0)) {
            this.rtsFormInputArray(1).processAtPoint(associatedRtsLayer, rtsPlayerLayerInterface, layerManager, point)
        }
    }

    override def processGameSpecific(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, item : ABCustomItem, index : Int) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        this.logUtil.putF(((CommonLabels.getInstance().INDEX_LABEL + index) + " > ") + this.itemIndex(0), this, commonStrings.PROCESS)
        if (this.isStickyItemSelected() && (associatedRtsLayer eq CollidableDestroyableDamageableLayer.getNullInstance())) {
            //Make sure your not drag and dropping units yet
            if (this.getSelectedStickyItemIndex() <= this.itemIndex(0)) {
                this.rtsFormInputArray(0).processGameSpecific(associatedRtsLayer, rtsPlayerLayerInterface, layerManager, item, index)
            }
        } else if (index > this.itemIndex(0)) {
            this.rtsFormInputArray(1).processGameSpecific(associatedRtsLayer, rtsPlayerLayerInterface, layerManager, item, index)
        }
    }

    override def processSticky(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, point : GPoint) : Boolean = {
        return this.rtsFormInputArray(0).processSticky(associatedRtsLayer, rtsPlayerLayerInterface, layerManager, point)
    }

    override def processStickyGameSpecific(associatedRtsLayer : CollidableDestroyableDamageableLayer, rtsPlayerLayerInterface : RTSPlayerLayerInterface, layerManager : AllBinaryLayerManager, item : ABCustomItem, index : Int) : Unit = {
        this.rtsFormInputArray(0).processStickyGameSpecific(associatedRtsLayer, rtsPlayerLayerInterface, layerManager, item, index)
    }

    override def getSelectedStickyItemIndex() : Int = {
        return this.rtsFormInputArray(0).getSelectedStickyItemIndex()
    }

    /**      * @return the stickyItemSelected      */
    override def isStickyItemSelected() : Boolean = {
        return this.rtsFormInputArray(0).isStickyItemSelected()
    }

    /**      * @param stickyItemSelected the stickyItemSelected to set      */
    override def setStickyItemSelected(stickyItemSelected : Boolean) : Unit = {
        this.rtsFormInputArray(0).setStickyItemSelected(stickyItemSelected)
    }

    /**      * @return the selectedStickyItem      */
    override def getSelectedStickyItem() : ABCustomItem = {
        return this.rtsFormInputArray(0).getSelectedStickyItem()
    }

    /**      * @param selectedStickyItem the selectedStickyItem to set      */
    override def setSelectedStickyItem(selectedStickyItem : ABCustomItem) : Unit = {
        this.rtsFormInputArray(0).setSelectedStickyItem(selectedStickyItem)
    }

}


