/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image.gui

import _root_.java.awt.*
import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class ImageJPanel(param_bufferedImage : BufferedImage) extends _root_.javax.swing.JPanel {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val canvasStrings : CanvasStrings = CanvasStrings.getInstance()

    private var isDrawn : Boolean = false

    private var bufferedImage : BufferedImage = null

    //Constructor
    {
        val bufferedImage : BufferedImage = param_bufferedImage
        this.initComponents()
        this.bufferedImage = bufferedImage
        this.setSize(this.bufferedImage.getWidth(null), this.bufferedImage.getHeight(null))
    }

    override def paint(graphics : Graphics) : Unit = {
        if (!this.isDrawn) {
            this.logUtil.putF(this.commonStrings.START, this, this.canvasStrings.PAINT)
            graphics.drawImage(bufferedImage, 0, 0, this.bufferedImage.getWidth(null), this.bufferedImage.getHeight(null), null)
            this.isDrawn = true
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private def initComponents() : Unit = {
        var layout : _root_.javax.swing.GroupLayout = new _root_.javax.swing.GroupLayout(this)
        this.setLayout(layout)
        layout.setHorizontalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, _root_.java.lang.Short.MAX_VALUE))
        layout.setVerticalGroup(layout.createParallelGroup(_root_.javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, _root_.java.lang.Short.MAX_VALUE))
    }

}


