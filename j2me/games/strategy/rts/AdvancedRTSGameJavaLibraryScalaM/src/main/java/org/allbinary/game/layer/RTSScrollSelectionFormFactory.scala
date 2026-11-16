/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.Rectangle
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.form.FormTypeFactory
import _root_.org.allbinary.graphics.form.MultipleScrollSelectionHorizontalForm
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.input.motion.button.CommonButtons
import _root_.org.allbinary.input.motion.button.TouchButtonLocationHelper

class RTSScrollSelectionFormFactory {
    import _root_.org.allbinary.game.layer.RTSScrollSelectionFormFactory.{*}

}

object RTSScrollSelectionFormFactory {
    def getInstance(formLabel : String, items : Array[ABCustomItem]) : ScrollSelectionForm = {
        val basicColorFactory : BasicColorFactory = BasicColorFactory.getInstance()
        val touchButtonLocationHelper : TouchButtonLocationHelper = new TouchButtonLocationHelper()
        val displayInfo : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()
        val menuX : Int = CommonButtons.getInstance().STANDARD_BUTTON_SIZE + touchButtonLocationHelper.getColumnsRemainderHalf()
        // - TouchButtonInput.STANDARD_BUTTON_SIZE;
        val width : Int = displayInfo.getLastWidth() - (menuX * 2)
        val menuRectangle : Rectangle = new Rectangle(PointFactory.getInstance().createXY(menuX, 16), width, CommonButtons.getInstance().STANDARD_BUTTON_SIZE)
        return MultipleScrollSelectionHorizontalForm.createForm(formLabel, items, menuRectangle, FormTypeFactory.getInstance().HORIZONTAL_FORM, 0, basicColorFactory.BLACK, basicColorFactory.WHITE)
    }

}


