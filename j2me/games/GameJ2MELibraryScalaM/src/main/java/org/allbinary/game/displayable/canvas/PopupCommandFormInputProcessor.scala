/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.org.allbinary.graphics.displayable.MyCanvas
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.input.motion.gesture.observer.MotionGestureEvent
import _root_.org.allbinary.util.BasicArrayList

class PopupCommandFormInputProcessor(param_gameKeyEventList : BasicArrayList, param_playerInputId : Int, param_gameCanvas : MyCanvas, param_form : ScrollSelectionForm, param_popupMenuInputProcessor : PopupMenuInputProcessor) extends CommandFormInputProcessor(param_gameKeyEventList, param_playerInputId, param_gameCanvas, param_form) {

    //private PopupMenuInputProcessor popupMenuInputProcessor;
    //Constructor
    {
        val gameKeyEventList : BasicArrayList = param_gameKeyEventList
        val playerInputId : Int = param_playerInputId
        val gameCanvas : MyCanvas = param_gameCanvas
        val form : ScrollSelectionForm = param_form
        val popupMenuInputProcessor : PopupMenuInputProcessor = param_popupMenuInputProcessor
    }

    override def processInput(key : Int) : Int = {
        //this.popupMenuInputProcessor.processInput(key);
        return super.processInput(key)
    }

    override def processMotionInput(motionGestureEvent : MotionGestureEvent) : Unit = {
        //this.popupMenuInputProcessor.processMotionInput(motionGestureEvent);
        super.processMotionInput(motionGestureEvent)
    }

}


