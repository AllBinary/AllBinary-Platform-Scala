/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.game.input.form.AssignWaypointsUtil
import _root_.org.allbinary.game.layer.AdvancedRTSGameLayer
import _root_.org.allbinary.game.layer.RTSLayer
import _root_.org.allbinary.game.layer.building.BuildingLayer
import _root_.org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer
import _root_.org.allbinary.game.layer.unit.UnitLayer
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.logic.util.visitor.Visitor

class SelectAdvancedRTSLayerVisitor(param_selectedRTSLayersPlayerGameInput : SelectedRTSLayersPlayerGameInput) extends Visitor {

    private var selectedRTSLayersPlayerGameInput : SelectedRTSLayersPlayerGameInput = null

    //Constructor
    {
        val selectedRTSLayersPlayerGameInput : SelectedRTSLayersPlayerGameInput = param_selectedRTSLayersPlayerGameInput
        this.selectedRTSLayersPlayerGameInput = selectedRTSLayersPlayerGameInput
    }

    override def visit(anyType : Object) : Object = {
        val selectedLayer : CollidableDestroyableDamageableLayer = anyType.asInstanceOf[CollidableDestroyableDamageableLayer]
        if ((selectedLayer ne CollidableDestroyableDamageableLayer.getNullInstance()) && (selectedLayer.getType() == BuildingLayer.getStaticType())) {
            val rtsGameLayer : AdvancedRTSGameLayer = selectedLayer.asInstanceOf[AdvancedRTSGameLayer]
            val assignWaypointsUtil : AssignWaypointsUtil = AssignWaypointsUtil.getInstance()
            val list : BasicArrayList = this.selectedRTSLayersPlayerGameInput.getSelectedBasicArrayList()
            var currentRTSLayer : RTSLayer = null
            var unitLayer : UnitLayer = null

            {
                var index : Int = list.size() - 1
                while (index >= 0) {
                    currentRTSLayer = list.get(index).asInstanceOf[RTSLayer]
                    if (currentRTSLayer.getType() == UnitLayer.getStaticType()) {
                        unitLayer = currentRTSLayer.asInstanceOf[UnitLayer]
                        unitLayer.setParentLayer(rtsGameLayer)
                        assignWaypointsUtil.set(unitLayer, rtsGameLayer)
                    }
                    index -= 1
                }
            }
        }
        return NullUtil.getInstance().NULL_OBJECT
    }

}


