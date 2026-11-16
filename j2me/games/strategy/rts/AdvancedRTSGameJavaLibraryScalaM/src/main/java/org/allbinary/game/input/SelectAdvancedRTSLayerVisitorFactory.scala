/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.logic.util.visitor.Visitor

class SelectAdvancedRTSLayerVisitorFactory private() extends SelectRTSLayerVisitorFactoryInterface {
    import _root_.org.allbinary.game.input.SelectAdvancedRTSLayerVisitorFactory.{*}

    override def create(selectedRTSLayersPlayerGameInput : SelectedRTSLayersPlayerGameInput) : Visitor = {
        return new SelectAdvancedRTSLayerVisitor(selectedRTSLayersPlayerGameInput)
    }

}

object SelectAdvancedRTSLayerVisitorFactory {
    private val instance : SelectAdvancedRTSLayerVisitorFactory = new SelectAdvancedRTSLayerVisitorFactory()

    def getInstance() : SelectAdvancedRTSLayerVisitorFactory = {
        return SelectAdvancedRTSLayerVisitorFactory.instance
    }

}


