/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.geological.resources

import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition

/**  *  * @author user  */
class GeologicalGeographicMapCellPosition(param_column : Int, param_row : Int, param_columns : Int, param_rows : Int, param_width : Int, param_height : Int, param_geologicalResource : GeologicalResource) extends GeographicMapCellPosition(param_column, param_row, param_columns, param_rows, param_width, param_height) {

    private var geologicalResource : GeologicalResource = null

    //Constructor
    {
        val column : Int = param_column
        val row : Int = param_row
        val columns : Int = param_columns
        val rows : Int = param_rows
        val width : Int = param_width
        val height : Int = param_height
        val geologicalResource : GeologicalResource = param_geologicalResource
        this.geologicalResource = geologicalResource
    }

    /**      * @return the geologicalResource      */
    def getGeologicalResource() : GeologicalResource = {
        return this.geologicalResource
    }

}


