/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image


class ImageUnifierProperties() {

    private var rows : Integer = null

    private var columns : Integer = null

    private var imageUnifierCell : ImageUnifierCell = null

    def getWidth() : Int = {
        return this.getColumns().intValue() * this.getImageUnifierCell().getWidth().intValue()
    }

    def getHeight() : Int = {
        return this.getRows().intValue() * this.getImageUnifierCell().getHeight().intValue()
    }

    def getRows() : Integer = {
        return this.rows
    }

    def setRows(rows : Integer) : Unit = {
        this.rows = rows
    }

    def getColumns() : Integer = {
        return this.columns
    }

    def setColumns(columns : Integer) : Unit = {
        this.columns = columns
    }

    def getImageUnifierCell() : ImageUnifierCell = {
        return this.imageUnifierCell
    }

    def setImageUnifierCell(imageUnifierCell : ImageUnifierCell) : Unit = {
        this.imageUnifierCell = imageUnifierCell
    }

}


