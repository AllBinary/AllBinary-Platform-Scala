/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.canvas

import _root_.java.awt.*
import _root_.java.util.HashMap
import _root_.javax.swing.tree.DefaultMutableTreeNode
import _root_.javax.swing.tree.MutableTreeNode
import _root_.org.allbinary.animation.VectorExplosionGenerator
import _root_.org.allbinary.animation.VectorMirrorGenerator
import _root_.org.allbinary.animation.vector.VectorCenterGenerator
import _root_.org.allbinary.game.input.GameInputStrings
import _root_.org.allbinary.graphics.GPoint
import _root_.org.allbinary.graphics.PointFactory
import _root_.org.allbinary.graphics.color.BasicColorFactory
import _root_.org.allbinary.graphics.j2me.GraphicsException
import _root_.org.allbinary.graphics.j2me.StatusFactory
import _root_.org.allbinary.graphics.j2me.workarea.WorkAreaJTreeJPanel
import _root_.org.allbinary.graphics.j2me.workarea.tools.GraphicItemFactory
import _root_.org.allbinary.graphics.j2me.workarea.tools.GraphicItemInterface
import _root_.org.allbinary.graphics.j2me.workarea.tools.LinesGraphicItem
import _root_.org.allbinary.graphics.j2me.workarea.tools.MouseStrings
import _root_.org.allbinary.graphics.j2me.workarea.tools.Points
import _root_.org.allbinary.graphics.j2me.workarea.tools.ToolFactory
import _root_.org.allbinary.graphics.j2me.workarea.tools.event.MyGraphicItemEvent
import _root_.org.allbinary.graphics.j2me.workarea.tools.event.MyGraphicItemEventListener
import _root_.org.allbinary.graphics.j2me.workarea.tools.event.MyGraphicItemEventService
import _root_.org.allbinary.graphics.pipeline.RandomRotationFactory
import _root_.org.allbinary.log.LOGGING
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.GuiLog
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.w3c.dom.Node

class CanvasJPanel private () extends _root_.javax.swing.JPanel with _root_.java.awt.event.MouseListener with _root_.java.awt.event.MouseMotionListener with _root_.java.awt.event.KeyListener with MyGraphicItemEventListener {
    import _root_.org.allbinary.graphics.j2me.workarea.canvas.CanvasJPanel.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val guiLog : GuiLog = GuiLog.getInstance()

    private val gameInputStrings : GameInputStrings = GameInputStrings.getInstance()

    private var selectedTool : GraphicItemInterface = null

    private var graphicItemHashMap : HashMap[Object, Object] = null

    private var canvasDimension : IntegerDimension = null

    private var angle : Double = 0

    private var canvasTreeNode : DefaultMutableTreeNode = null

    private var frameLabel : CanvasTreeLabel = null

    private var workAreaJTreeJPanel : WorkAreaJTreeJPanel = null

    private var grid : Grid = null

    def this(workAreaJTreeJPanel : WorkAreaJTreeJPanel, dimension : Dimension, x : Int, y : Int) = {
        this()
        this.grid = new Grid()
        try {
            this.workAreaJTreeJPanel = workAreaJTreeJPanel
            this.initComponents()
            this.initMyComponents()
            this.setSize(dimension)
            this.setCanvasSize(x, y)
        } catch {
            case e : Exception => {
                if (LOGGING.contains(LOGGING.GRAPHICSCREATION)) {
                    this.guiLog.put("Constructor Error", this, "contructor", e)
                }
            }
        }
    }

    def this(workAreaJTreeJPanel : WorkAreaJTreeJPanel, dimension : Dimension, canvasDom : CanvasDom) = {
        this()
        this.grid = new Grid(canvasDom.getGrid())
        try {
            this.workAreaJTreeJPanel = workAreaJTreeJPanel
            this.initComponents()
            this.initMyComponents()
            this.setSize(dimension)
            this.setCanvasSize(canvasDom.getDimension().getWidth(), canvasDom.getDimension().getHeight())
            this.graphicItemHashMap = canvasDom.getGraphicItemHashMap().asInstanceOf[HashMap[Object, Object]]
            val graphicItemArray : Array[Object] = this.graphicItemHashMap.keySet().toArray()
            val size : Int = graphicItemArray.length

            {
                var index : Int = 0
                while (index < size) {
                    var graphicItemTreeNode : MutableTreeNode = graphicItemArray(index).asInstanceOf[MutableTreeNode]
                    this.canvasTreeNode.add(graphicItemTreeNode)
                    index += 1
                }
            }
            this.repaint()
            this.setAngle(canvasDom.getAngle())
            this.workAreaJTreeJPanel.updateTree()
            this.workAreaJTreeJPanel.expand()
            this.workAreaJTreeJPanel.repaint()
        } catch {
            case e : Exception => {
                if (LOGGING.contains(LOGGING.GRAPHICSCREATION)) {
                    this.guiLog.put("Constructor Error", this, "contructor", e)
                }
            }
        }
    }

    private def initMyComponents() : Unit = {
        this.frameLabel = new CanvasTreeLabel("FrameLabel" + new Integer(CanvasJPanel.frame).toString())
        this.canvasTreeNode = new DefaultMutableTreeNode(this.frameLabel)
        CanvasJPanel.frame += 1
        this.workAreaJTreeJPanel.add(this.getTreeNode())
        this.graphicItemHashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        this.grid.grid = PointFactory.getInstance().createXY(0, 0)
        this.setCanvasDimension(new IntegerDimension(0, 0))
        this.selectedTool = null
        this.addKeyListener(this)
        this.addMouseListener(this)
        this.addMouseMotionListener(this)
        MyGraphicItemEventService.addListener(this)
    }

    def getTreeNode() : MutableTreeNode = {
        return this.canvasTreeNode
    }

    private def initComponents() : Unit = {
        setLayout(new _root_.java.awt.GridLayout(1, 1))
    }

    //GEN-END:initComponents
    def setCanvasSize(x : Int, y : Int) : Unit = {
        this.grid.isGridPossible_Grid = true
        if (x <= 0) {
            this.grid.isGridPossible_Grid = false
            throw new GraphicsException("X Size Error: " + x, this, "setWorkAreaSize")
        }
        if (y <= 0) {
            this.grid.isGridPossible_Grid = false
            throw new GraphicsException("Y Size Error: " + y, this, "setWorkAreaSize")
        }
        if (x > this.getWidth()) {
            this.grid.isGridPossible_Grid = false
        }
        if (y > this.getHeight()) {
            this.grid.isGridPossible_Grid = false
        }
        this.setCanvasDimension(new IntegerDimension(x, y))
        this.grid.isChanged = true
    }

    def setGrid(point : GPoint) : Unit = {
        this.setGrid(point.getX(), point.getY())
    }

    //xSize number of pixels between gridlines
    def setGrid(xSize : Int, ySize : Int) : Unit = {
        try {
            if ((xSize >= (getCanvasDimension().getWidth() / 2)) || (xSize < 1)) {
                throw new GraphicsException((("X Size Error: " + xSize) + " WorkArea X: ") + getCanvasDimension().getWidth(), this, "setGrid")
            }
            if ((ySize >= (getCanvasDimension().getHeight() / 2)) || (ySize < 1)) {
                throw new GraphicsException((("Y Size Error" + ySize) + " WorkArea Y: ") + getCanvasDimension().getHeight(), this, "setGrid")
            }
            this.grid.grid = PointFactory.getInstance().createXY(xSize, ySize)
            this.grid.isChanged = true
        } catch {
            case e : Exception => {
            }
        }
    }

    def setDefaultGrid() : Unit = {
        var xPixelsPerWorkAreaPixel : Int = this.getWidth() / this.getCanvasDimension().getWidth()
        var yPixelsPerWorkAreaPixel : Int = this.getHeight() / this.getCanvasDimension().getHeight()
        /*         if(xPixelsPerWorkAreaPixel<9)         {         this.setGrid(6,6);         }         else         if(xPixelsPerWorkAreaPixel<7)         {         this.setGrid(12,12);         }         else         if(xPixelsPerWorkAreaPixel<5)         {         this.setGrid(24,24);         }         else         if(xPixelsPerWorkAreaPixel<3)         {         this.setGrid(48,48);         }         else         {         this.setGrid(1,1);         }*/
        this.setGrid(1, 1)
        this.grid.isChanged = true
    }

    def getAngle() : Double = {
        return this.angle
    }

    def setAngle(angle : Double) : Unit = {
        //while(angle < 0) angle += 360;
        this.angle = angle
    }

    def addAngle(angle : Double) : Unit = {
        this.setAngle(this.angle + angle)
    }

    //This should be a tool
    def explodeAll() : Unit = {
        var newPoints : BasicArrayList = new BasicArrayListD()
        val graphicItemArray : Array[Object] = this.getGraphicItemHashMap().keySet().toArray()
        val size : Int = graphicItemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var graphicItemNode : MutableTreeNode = graphicItemArray(index).asInstanceOf[MutableTreeNode]
                var graphicItem : GraphicItemInterface = this.getGraphicItemHashMap().get(graphicItemNode).asInstanceOf[GraphicItemInterface]
                if (graphicItem.getName() eq LinesGraphicItem.getStaticName()) {

                    {
                        while (graphicItem.getPointsInterface().getSize() > 2) {
                            var newGraphicItem : GraphicItemInterface = GraphicItemFactory.getInstance().getInstance(graphicItem.getName()).getInstance(this)
                            var pointOne : GPoint = GPoint.getInstance(graphicItem.removePoint())
                            var pointTwo : GPoint = GPoint.getInstance(graphicItem.removePoint())
                            //Point pointTwo = new Point((Point) points.remove(points.size()-1));
                            if ((pointOne != null) && (pointTwo != null)) {
                                newGraphicItem.addPoint(pointOne)
                                newGraphicItem.addPoint(pointTwo)
                            }
                            newPoints.add(newGraphicItem)
                        }
                    }
                }
                index += 1
            }
        }
        val size2 : Int = newPoints.size()

        {
            var index : Int = 0
            while (index < size2) {
                var newGraphicItem : GraphicItemInterface = newPoints.get(index).asInstanceOf[GraphicItemInterface]
                this.canvasTreeNode.add(newGraphicItem.getTreeNode())
                this.getGraphicItemHashMap().put(newGraphicItem.getTreeNode(), newGraphicItem)
                index += 1
            }
        }
        this.workAreaJTreeJPanel.updateTree()
        this.workAreaJTreeJPanel.expand()
        this.workAreaJTreeJPanel.repaint()
    }

    def explode(howMuch : Int, explosionType : Int) : Unit = {
        //move and rotate each line a random amount
        val graphicItemArray : Array[Object] = this.getGraphicItemHashMap().keySet().toArray()
        val size : Int = graphicItemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : GraphicItemInterface = this.getGraphicItemHashMap().get(graphicItemArray(index)).asInstanceOf[GraphicItemInterface]
                var basicArrayList : BasicArrayList = VectorExplosionGenerator.getInstance().createList(item.getPointsInterface().getPoints(), howMuch, VectorExplosionGenerator.getInstance().RANDOM)
                var newPoints : Points = new Points()
                newPoints.addPoints(basicArrayList)
                item.setPointsInterface(newPoints)
                var angleDelta : Int = RandomRotationFactory.getInstance().getNextRandomAngle(howMuch)
                //angle +
                item.setAngle(angleDelta)
                index += 1
            }
        }
        this.repaint()
    }

    def mirror() : Unit = {
        var width : Int = this.getCanvasDimension().getWidth()
        //move and rotate each line a random amount
        val graphicItemArray : Array[Object] = this.getGraphicItemHashMap().keySet().toArray()
        val size : Int = graphicItemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : GraphicItemInterface = this.getGraphicItemHashMap().get(graphicItemArray(index)).asInstanceOf[GraphicItemInterface]
                var basicArrayList : BasicArrayList = VectorMirrorGenerator.getInstance().getInstance(item.getPointsInterface().getPoints(), width)
                var newPoints : Points = new Points()
                newPoints.addPoints(basicArrayList)
                item.setPointsInterface(newPoints)
                index += 1
            }
        }
        this.repaint()
    }

    def center() : Unit = {
        new VectorCenterGenerator().transform(this.getGraphicItemHashMap())
        this.repaint()
    }

    //add a new graphic item from the currently selected graphic tool
    def setNewTool() : Unit = {
        try {
            StatusFactory.getInstance().setStatus("Tool Selected")
            //assign new tool
            this.selectedTool = ToolFactory.getInstance().getSelectedToolFactory().getInstance(this)
            //move new graphic item to list
            var newNode : MutableTreeNode = this.selectedTool.getTreeNode()
            this.getGraphicItemHashMap().put(newNode, this.selectedTool)
            this.canvasTreeNode.add(newNode)
            //add mouse click
            if (this.getSelectedTool() == null) {
                throw new GraphicsException("No Tool Selected", this, "setSelectedTool")
            }
        } catch {
            case e : Exception => {
            }
        }
    }

    def duplicateGraphicItem(graphicItem : GraphicItemInterface) : Unit = {
        var graphicItemClone : GraphicItemInterface = graphicItem.duplicate()
        this.getGraphicItemHashMap().put(graphicItemClone.getTreeNode(), graphicItemClone)
        this.canvasTreeNode.add(graphicItemClone.getTreeNode())
    }

    def duplicateGraphicItemHashMap(hashMap : HashMap[Object, Object]) : Unit = {
        val mutableTreeNodeArray : Array[Object] = hashMap.keySet().toArray()
        val size : Int = mutableTreeNodeArray.length

        {
            var index : Int = 0
            while (index < size) {
                var treeNode : MutableTreeNode = mutableTreeNodeArray(index).asInstanceOf[MutableTreeNode]
                var graphicItem : GraphicItemInterface = hashMap.get(treeNode).asInstanceOf[GraphicItemInterface]
                this.duplicateGraphicItem(graphicItem)
                index += 1
            }
        }
    }

    def getGraphicItemHashMap() : HashMap[Object, Object] = {
        return this.graphicItemHashMap
    }

    def getXPixelsPerWorkAreaPixel() : Int = {
        //int xWorkArea = ;
        var x : Int = (this.getGrid().grid.getX() * (this.getWidth() - 10)) / this.getCanvasDimension().getWidth()
        if (this.getGrid().getZoom() == 1) {
            return 1
        } else {
            return x
        }
        throw new IllegalStateException()
    }

    def getYPixelsPerWorkAreaPixel() : Int = {
        var y : Int = (this.getGrid().grid.getY() * (this.getHeight() - 10)) / this.getCanvasDimension().getHeight()
        if (this.getGrid().getZoom() == 1) {
            return 1
        } else {
            return y
        }
        throw new IllegalStateException()
    }

    def getSelectedTool() : GraphicItemInterface = {
        return this.selectedTool
    }

    def drawItems(graphics : Graphics) : Unit = {
        var angleDouble : _root_.java.lang.Double = new _root_.java.lang.Double(this.angle)
        //graphics.drawString(new Integer(this.graphicItemHashMap.keySet().size()).toString(),5,5);
        val graphicItemArray : Array[Object] = this.getGraphicItemHashMap().keySet().toArray()
        val size : Int = graphicItemArray.length

        {
            var index : Int = 0
            while (index < size) {
                var item : GraphicItemInterface = this.getGraphicItemHashMap().get(graphicItemArray(index)).asInstanceOf[GraphicItemInterface]
                item.paint(graphics, angleDouble, this.getCanvasDimension(), this.getXPixelsPerWorkAreaPixel(), this.getYPixelsPerWorkAreaPixel())
                index += 1
            }
        }
    }

    def drawGrid(graphics : Graphics) : Unit = {
        var xAdjust : Int = (this.getWidth() % this.getXPixelsPerWorkAreaPixel()) / 2
        var yAdjust : Int = (this.getHeight() % this.getYPixelsPerWorkAreaPixel()) / 2
        var xLeft : Int = xAdjust
        var yUpper : Int = yAdjust
        var xRight : Int = this.getWidth() - xAdjust
        var yLower : Int = this.getHeight() - yAdjust
        graphics.setColor(CanvasJPanel.gridColor)

        {
            var value : Int = yAdjust
            while (value <= (this.getHeight() - yAdjust)) {
                graphics.drawLine(xLeft, value, xRight, value)
                value += this.getYPixelsPerWorkAreaPixel()
            }
        }

        {
            var value : Int = xAdjust
            while (value <= (this.getWidth() - xAdjust)) {
                graphics.drawLine(value, yUpper, value, yLower)
                value += this.getYPixelsPerWorkAreaPixel()
            }
        }
    }

    override def paint(graphics : Graphics) : Unit = {
        try {
            if (this.getGrid().isChanged) {
                graphics.setColor(CanvasJPanel.backgroundColor)
                graphics.fillRect(0, 0, getWidth(), getHeight())
                if (((this.getGrid().getZoom() > 2) && this.getGrid().isGridOn_Grid) && this.getGrid().isGridPossible_Grid) {
                    this.setDefaultGrid()
                    this.drawGrid(graphics)
                }
                //draw items
                this.drawItems(graphics)
                graphics.drawString(new _root_.java.lang.Double(this.getAngle()).toString(), this.getWidth() - 75, this.getHeight() - 15)
                this.grid.isChanged = false
            }
        } catch {
            case e : Exception => {
            }
        }
    }

    override def repaint() : Unit = {
        if (this.grid != null) {
            this.grid.isChanged = true
        }
        super.repaint()
    }

    def toDom() : Node = {
        return new CanvasDom(this).toDom()
    }

    def changed() : Unit = {
        this.grid.isChanged = true
    }

    def mouseClicked(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit = {
        StatusFactory.getInstance().setStatusNoLog(MouseStrings.getInstance().MOUSE_CLICKED_LABEL + this.logMouseEvent(mouseEvent))
        if ((this.getSelectedTool() != null) && this.getSelectedTool().isActive()) {
            var graphicItem : GraphicItemInterface = this.getSelectedTool()
            //add new point to graphic item if required
            graphicItem.mouseClicked(mouseEvent, this.getXPixelsPerWorkAreaPixel(), this.getYPixelsPerWorkAreaPixel())
        } else {
            this.setNewTool()
            //start using a new graphic item immediately
            var graphicItem : GraphicItemInterface = this.getSelectedTool()
            //add new point to graphic item if required
            if (graphicItem != null) {
                graphicItem.mouseClicked(mouseEvent, this.getXPixelsPerWorkAreaPixel(), this.getYPixelsPerWorkAreaPixel())
            }
        }
        this.grid.isChanged = true
        this.repaint()
        this.workAreaJTreeJPanel.updateTree()
        this.workAreaJTreeJPanel.expand()
        this.workAreaJTreeJPanel.repaint()
    }

    def mouseEntered(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit = {
        StatusFactory.getInstance().setStatusNoLog(this.logMouseEvent(mouseEvent))
    }

    def mouseExited(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit = {
        StatusFactory.getInstance().setStatusNoLog(this.logMouseEvent(mouseEvent))
    }

    def mousePressed(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit = {
        StatusFactory.getInstance().setStatusNoLog(MouseStrings.getInstance().MOUSE_PRESSED_LABEL + this.logMouseEvent(mouseEvent))
        //&& this.getSelectedTool().isActive()
        if (this.getSelectedTool() != null) {
            var graphicItem : GraphicItemInterface = this.getSelectedTool()
            graphicItem.mousePressed(mouseEvent, this.getXPixelsPerWorkAreaPixel(), this.getYPixelsPerWorkAreaPixel())
        }
        this.requestFocus()
        this.grid.isChanged = true
        this.repaint()
    }

    def mouseReleased(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit = {
        StatusFactory.getInstance().setStatusNoLog(MouseStrings.getInstance().MOUSE_RELEASED_LABEL + this.logMouseEvent(mouseEvent))
        var graphicItem : GraphicItemInterface = this.getSelectedTool()
        //&& this.getSelectedTool().isActive()
        if (graphicItem != null) {
            graphicItem.mouseReleased(mouseEvent, this.getXPixelsPerWorkAreaPixel(), this.getYPixelsPerWorkAreaPixel())
        }
        this.requestFocus()
        this.grid.isChanged = true
        this.repaint()
    }

    def mouseDragged(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit = {
        StatusFactory.getInstance().setStatusNoLog(MouseStrings.getInstance().MOUSE_DRAGGED_LABEL + this.logMouseEvent(mouseEvent))
        var graphicItem : GraphicItemInterface = this.getSelectedTool()
        //&& this.getSelectedTool().isActive()
        if (graphicItem != null) {
            graphicItem.mouseDragged(mouseEvent, this.getXPixelsPerWorkAreaPixel(), this.getYPixelsPerWorkAreaPixel())
        }
        this.requestFocus()
        this.grid.isChanged = true
        this.repaint()
    }

    def mouseMoved(mouseEvent : _root_.java.awt.event.MouseEvent) : Unit = {
        StatusFactory.getInstance().setStatusNoLog(MouseStrings.getInstance().MOUSE_MOVED_LABEL + this.logMouseEvent(mouseEvent))
        if ((this.getSelectedTool() != null) && this.getSelectedTool().isActive()) {
            var graphicItem : GraphicItemInterface = this.getSelectedTool()
            graphicItem.mouseMoved(mouseEvent, this.getXPixelsPerWorkAreaPixel(), this.getYPixelsPerWorkAreaPixel())
        }
        this.requestFocus()
        this.grid.isChanged = true
        this.repaint()
    }

    private def logMouseEvent(mouseEvent : _root_.java.awt.event.MouseEvent) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(PositionStrings.getInstance().X_LABEL)
        stringBuffer.appendint(mouseEvent.getX() / this.getXPixelsPerWorkAreaPixel())
        stringBuffer.append(CommonSeps.getInstance().SPACE)
        stringBuffer.append(PositionStrings.getInstance().Y_LABEL)
        stringBuffer.appendint(mouseEvent.getY() / this.getYPixelsPerWorkAreaPixel())
        return stringBuffer.toString()
    }

    def keyPressed(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
        StatusFactory.getInstance().setStatus("Key Pressed")
        try {
            val graphicItemArray : Array[Object] = this.graphicItemHashMap.keySet().toArray()
            val size : Int = graphicItemArray.length

            {
                var index : Int = 0
                while (index < size) {
                    var graphicItemInterface : GraphicItemInterface = this.graphicItemHashMap.get(graphicItemArray(index)).asInstanceOf[GraphicItemInterface]
                    var keyCode : Int = keyEvent.getKeyCode()
                    if (graphicItemInterface.isActive()) {
                        if (keyCode == _root_.java.awt.event.KeyEvent.VK_UP) {
                            graphicItemInterface.translate(0, -1)
                        } else if (keyCode == _root_.java.awt.event.KeyEvent.VK_DOWN) {
                            graphicItemInterface.translate(0, 1)
                        } else if (keyCode == _root_.java.awt.event.KeyEvent.VK_LEFT) {
                            graphicItemInterface.translate(-1, 0)
                        } else if (keyCode == _root_.java.awt.event.KeyEvent.VK_RIGHT) {
                            graphicItemInterface.translate(1, 0)
                        }
                    }
                    index += 1
                }
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, this.gameInputStrings.KEY_PRESSED, e)
            }
        }
        if ((this.getSelectedTool() != null) && this.getSelectedTool().isActive()) {
            StatusFactory.getInstance().setStatus("Key Pressed for Tool")
            var graphicItem : GraphicItemInterface = this.getSelectedTool()
            graphicItem.keyPressed(keyEvent)
        } else {
            this.setNewTool()
        }
        this.grid.isChanged = true
        this.repaint()
    }

    def keyReleased(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
    }

    def keyTyped(keyEvent : _root_.java.awt.event.KeyEvent) : Unit = {
    }

    def delete(evt : MyGraphicItemEvent) : Unit = {
        this.getGraphicItemHashMap().remove(evt.getTreeNode())
        this.workAreaJTreeJPanel.updateTree()
        this.workAreaJTreeJPanel.expand()
        this.workAreaJTreeJPanel.repaint()
    }

    def deselect(evt : MyGraphicItemEvent) : Unit = {
        //LogUtil.put("Deselect", this, "deselect");
        var graphicItemInterface : GraphicItemInterface = this.getGraphicItemHashMap().get(evt.getTreeNode()).asInstanceOf[GraphicItemInterface]
        if (graphicItemInterface != null) {
            graphicItemInterface.setColor(Color.WHITE)
            graphicItemInterface.deactivate()
            this.workAreaJTreeJPanel.repaint()
        }
    }

    def highlight(evt : MyGraphicItemEvent) : Unit = {
        var graphicItemInterface : GraphicItemInterface = this.getGraphicItemHashMap().get(evt.getTreeNode()).asInstanceOf[GraphicItemInterface]
        if (graphicItemInterface != null) {
            graphicItemInterface.setColor(Color.YELLOW)
            graphicItemInterface.activate()
            this.workAreaJTreeJPanel.repaint()
        }
    }

    def duplicate() : CanvasJPanel = {
        var newCanvasJPanel : CanvasJPanel = new CanvasJPanel(this.workAreaJTreeJPanel, this.getSize(), this.getCanvasDimension().getWidth(), this.getCanvasDimension().getHeight())
        newCanvasJPanel.setGrid(this.getGrid().getGrid())
        newCanvasJPanel.setAngle(this.getAngle())
        newCanvasJPanel.duplicateGraphicItemHashMap(this.getGraphicItemHashMap())
        this.workAreaJTreeJPanel.updateTree()
        this.workAreaJTreeJPanel.expand()
        this.workAreaJTreeJPanel.repaint()
        return newCanvasJPanel
    }

    def duplicate(event : MyGraphicItemEvent) : Unit = {
        var treeNode : MutableTreeNode = event.getTreeNode()
        var graphicItem : GraphicItemInterface = this.getGraphicItemHashMap().get(treeNode).asInstanceOf[GraphicItemInterface]
        if (graphicItem != null) {
            this.duplicateGraphicItem(graphicItem)
            this.workAreaJTreeJPanel.updateTree()
            this.workAreaJTreeJPanel.expand()
            this.workAreaJTreeJPanel.repaint()
        }
    }

    def rotate(event : MyGraphicItemEvent) : Unit = {
        var treeNode : MutableTreeNode = event.getTreeNode()
        var graphicItem : GraphicItemInterface = this.getGraphicItemHashMap().get(treeNode).asInstanceOf[GraphicItemInterface]
        if (graphicItem != null) {
            graphicItem.addAngle(event.getAngle())
        }
    }

    def getCanvasDimension() : IntegerDimension = {
        return this.canvasDimension
    }

    def setCanvasDimension(canvasDimension : IntegerDimension) : Unit = {
        this.canvasDimension = canvasDimension
    }

    /**      * @return the grid      */
    def getGrid() : Grid = {
        return this.grid
    }

}

object CanvasJPanel {
    private var frame : Int = 0

    private val gridColor : Color = new Color(BasicColorFactory.getInstance().WHITE.intValue())

    private val backgroundColor : Color = new Color(BasicColorFactory.getInstance().CLEAR_COLOR.intValue())

}


