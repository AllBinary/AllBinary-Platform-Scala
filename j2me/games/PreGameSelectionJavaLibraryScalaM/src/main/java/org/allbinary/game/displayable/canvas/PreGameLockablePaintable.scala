/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.displayable.canvas

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.image.GameFeatureImageCacheFactory
import _root_.org.allbinary.logic.system.security.licensing.LockedResources
import _root_.org.allbinary.logic.system.security.licensing.LockedUtil
import _root_.org.allbinary.graphics.form.LockablePaintable
import _root_.org.allbinary.graphics.form.ScrollCurrentSelectionForm

class PreGameLockablePaintable(param_paintableForm : ScrollCurrentSelectionForm, param_lockedIndex : Int) extends LockablePaintable(param_lockedIndex) {

    private var halfWidth : Int = 0

    private var paintableForm : ScrollCurrentSelectionForm = null

    //Constructor
    {
        val paintableForm : ScrollCurrentSelectionForm = param_paintableForm
        val lockedIndex : Int = param_lockedIndex
        //ScrollCurrentSelectionForm paintableForm
        this.paintableForm = paintableForm
        this.halfWidth = GameFeatureImageCacheFactory.getInstance().getWithKey(LockedResources.getInstance().LOCKED_DEMO_GAME_FEATURE_RESOURCE).getWidth() / 2
    }

    override def paint(graphics : Graphics, currentIndex : Int, x : Int, y : Int) : Unit = {
        if (LockedUtil.getInstance().isLocked() && (this.getPaintableForm().getSelectedIndex() >= this.getLockedIndex())) {
            //98 - 64
            this.getAnimation().paintXY(graphics, this.getPaintableForm().getDx() - this.halfWidth, this.getPaintableForm().getDy() + 34)
        }
    }

    def getPaintableForm() : ScrollCurrentSelectionForm = {
        return this.paintableForm
    }

}


