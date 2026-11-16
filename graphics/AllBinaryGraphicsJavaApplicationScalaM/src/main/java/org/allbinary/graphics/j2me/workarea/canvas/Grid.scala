/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea.canvas

import _root_.org.allbinary.graphics.GPoint

/**  *  * @author user  */
class Grid() {

    var grid : GPoint = null

    var isGridOn_Grid : Boolean = true

    var isGridPossible_Grid : Boolean = false

    private var zoom : Int = 3

    var isChanged : Boolean = true

    def this(grid : Grid) = {
        this()
        this.grid = grid.grid
        this.showGrid(grid.isGridOn_Grid)
        this.isGridPossible_Grid = grid.isGridPossible_Grid
        this.setZoom(grid.getZoom())
    }

    def isGridOn() : Boolean = {
        return this.isGridOn_Grid
    }

    def isGridPossible() : Boolean = {
        return this.isGridPossible_Grid
    }

    def getGrid() : GPoint = {
        return this.grid
    }

    def getZoom() : Int = {
        return this.zoom
    }

    def showGrid(value : Boolean) : Unit = {
        this.isGridOn_Grid = value
    }

    def setZoom(param_zoom : Int) : Unit = {
        var zoom : Int = param_zoom
        this.zoom = zoom
        if (this.zoom < 1) {
            zoom = 1
        }
        this.isChanged = true
    }

}


