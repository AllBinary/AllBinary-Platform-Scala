/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.tools

import _root_.java.util.HashMap
import _root_.org.allbinary.log.LOGGING
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.w3c.dom.Node

class GraphicItemFactory private() {
    import _root_.org.allbinary.graphics.j2me.workarea.tools.GraphicItemFactory.{*}

    private var graphicItems : HashMap[Object, Object] = null

    private val DEFAULT : GraphicsItemInterfaceFactoryInterface = new SelectionToolFactory()

    //Constructor
    {
        this.graphicItems = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        this.graphicItems.put(LinesGraphicItem.getStaticName(), new LinesGraphicItemFactory())
    }

    def getInstance(itemName : String) : GraphicsItemInterfaceFactoryInterface = {
        var graphicsItemInterfaceFactoryInterface : GraphicsItemInterfaceFactoryInterface = this.graphicItems.get(itemName).asInstanceOf[GraphicsItemInterfaceFactoryInterface]
        if (graphicsItemInterfaceFactoryInterface == null) {
            graphicsItemInterfaceFactoryInterface = DEFAULT
        }
        return graphicsItemInterfaceFactoryInterface
    }

    def getInstance(graphicItemNodeList : BasicArrayList) : HashMap[Object, Object] = {
        var numberOfItems : Int = graphicItemNodeList.size()
        var graphicItemHashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        if (LOGGING.contains(LOGGING.MENUEVENT)) {
        }

        {
            var index : Int = 0
            while (index < numberOfItems) {
                var graphicItem : GraphicItemInterface = GraphicItemBuilder.getInstance(graphicItemNodeList.get(index).asInstanceOf[Node])
                graphicItemHashMap.put(graphicItem.getTreeNode(), graphicItem)
                index += 1
            }
        }
        return graphicItemHashMap
    }

}

object GraphicItemFactory {
    private val instance : GraphicItemFactory = new GraphicItemFactory()

    /**      * @return the instance      */
    def getInstance() : GraphicItemFactory = {
        return GraphicItemFactory.instance
    }

}


