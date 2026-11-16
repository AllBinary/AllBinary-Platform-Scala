/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.CircularIndexUtil
import _root_.org.allbinary.game.layer.geographic.map.LayerCoveringCellPositionsUtil
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.CellPositionsUtil
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.util.BasicArrayListS
import _root_.org.allbinary.util.BasicArrayListUtil

/**  *  * @author user  */
class GeographicMapCellPositionArea(param_layerInterface : AllBinaryLayer) extends GeographicMapCellPositionAreaBase {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val cellPositionsUtil : CellPositionsUtil = CellPositionsUtil.getInstance()

    private val layerCoveringCellPositionsUtil : LayerCoveringCellPositionsUtil = LayerCoveringCellPositionsUtil.getInstance()

    private val reusableOccupyingGeographicMapCellPositionList : BasicArrayList = new BasicArrayListS(4)

    private val reusableSurroundingGeographicMapCellPositionList : BasicArrayList = new BasicArrayListS(12)

    private val surroundingCircularIndexUtil : CircularIndexUtil = CircularIndexUtil.createInstance(0)

    private var layerInterface : AllBinaryLayer = null

    private var LIST : BasicArrayList = BasicArrayListUtil.getInstance().getImmutableInstance()

    private var occupyingGeographicMapCellPositionList : BasicArrayList = this.LIST

    private var surroundingGeographicMapCellPositionList : BasicArrayList = this.LIST

    //Constructor
    {
        val layerInterface : AllBinaryLayer = param_layerInterface
        this.layerInterface = layerInterface
    }

    override def update(geographicMapInterface : BasicGeographicMap) : Unit = {
        //this.logUtil.putF(new StringMaker().append(layerInterface.getName()).append(" c: ").append(((PathFindingLayerInterface) layerInterface).getCurrentGeographicMapCellPosition()).append(CommonSeps.getInstance().SPACE).append(((PathFindingLayerInterface) layerInterface).getTopLeftGeographicMapCellPosition()).append(" topLeftGeographicMapCellPosition: ").append(topLeftGeographicMapCellPosition).toString(), this, "visit");
        this.occupyingGeographicMapCellPositionList = this.layerCoveringCellPositionsUtil.getAllXY(geographicMapInterface, this.layerInterface, this.layerInterface.getXP(), this.layerInterface.getYP(), this.reusableOccupyingGeographicMapCellPositionList)
        this.surroundingGeographicMapCellPositionList = this.cellPositionsUtil.getAllSurrounding(geographicMapInterface, this.occupyingGeographicMapCellPositionList, this.reusableSurroundingGeographicMapCellPositionList)
        this.surroundingCircularIndexUtil.setSize(this.surroundingGeographicMapCellPositionList.size())
    }

    /**      * @return the occupyingGeographicMapCellPositionList      */
    override def getOccupyingGeographicMapCellPositionList() : BasicArrayList = {
        return this.occupyingGeographicMapCellPositionList
    }

    /**      * @return the surroundingGeographicMapCellPositionList      */
    override def getSurroundingGeographicMapCellPositionList() : BasicArrayList = {
        return this.surroundingGeographicMapCellPositionList
    }

    override def getNextSurroundingGeographicMapCellPosition() : GeographicMapCellPosition = {
        val geographicMapCellPosition : GeographicMapCellPosition = this.surroundingGeographicMapCellPositionList.get(this.surroundingCircularIndexUtil.getIndex()).asInstanceOf[GeographicMapCellPosition]
        this.surroundingCircularIndexUtil.next()
        return geographicMapCellPosition
    }

}


