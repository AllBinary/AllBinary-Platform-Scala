/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.game.input.RTSLayerFormFactory
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.graphics.form.item.ItemArraySingletonFactoryInterface

class AdvancedRTSLayerFormFactory(param_label : String, param_itemArrayFactoryInterface : ItemArraySingletonFactoryInterface) extends RTSLayerFormFactory {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var scrollSelectionForm : ScrollSelectionForm = null

    //Constructor
    {
        val label : String = param_label
        val itemArrayFactoryInterface : ItemArraySingletonFactoryInterface = param_itemArrayFactoryInterface
        var scrollSelectionForm : ScrollSelectionForm = ScrollSelectionForm.getNullScrollSelectionForm()
        try {
            val items : Array[ABCustomItem] = itemArrayFactoryInterface.getItems()
            scrollSelectionForm = RTSScrollSelectionFormFactory.getInstance(label, items)
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e)
            }
        }
        this.scrollSelectionForm = scrollSelectionForm
    }

    /* (non-Javadoc)      * @see org.allbinary.game.input.RTSLayerFormFactoryInterface#getInstance(org.allbinary.game.layer.RTSLayer)      */
    override def getInstance(rtsLayer : RTSLayer) : ScrollSelectionForm = {
        return this.scrollSelectionForm
    }

}


