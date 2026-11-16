/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.tools

import _root_.org.allbinary.graphics.j2me.StatusFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author user  */
class ToolFactory {
    import _root_.org.allbinary.graphics.j2me.workarea.tools.ToolFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var selectedTool : GraphicsItemInterfaceFactoryInterface = null

    private var tool : String = null

    private val SELECTED_LABEL : String = "Selected: "

    def setSelectedTool(tool : String) : Unit = {
        try {
            StatusFactory.getInstance().setStatus(this.SELECTED_LABEL + tool)
            this.tool = tool
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, "setSelectionTool", e)
            }
        }
    }

    def getSelectedToolFactory() : GraphicsItemInterfaceFactoryInterface = {
        StatusFactory.getInstance().setStatus("Tool In Use: " + this.tool)
        if (this.tool != null) {
            this.selectedTool = GraphicItemFactory.getInstance().getInstance(this.tool)
            this.logUtil.putF("New Tool: " + this.selectedTool, this, "getSelectedToolFactory")
            return this.selectedTool
        } else {
            return null
        }
        throw new IllegalStateException()
    }

}

object ToolFactory {
    private val instance : ToolFactory = new ToolFactory()

    /**      * @return the instance      */
    def getInstance() : ToolFactory = {
        return ToolFactory.instance
    }

}


