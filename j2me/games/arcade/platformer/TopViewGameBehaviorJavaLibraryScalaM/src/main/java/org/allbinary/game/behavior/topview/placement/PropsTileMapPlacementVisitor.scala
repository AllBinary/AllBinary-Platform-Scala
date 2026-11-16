/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.behavior.topview.placement

import _root_.org.allbinary.game.rand.MyRandomFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.mapeditor.core.TileLayer
import _root_.org.mapeditor.core.TiledMap

/**  *  * @author User  */
class PropsTileMapPlacementVisitor extends TileMapPlacementVisitor {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val randomFactory : MyRandomFactory = MyRandomFactory.getInstance()

    override def visit(lastMap : TiledMap, mapData : Array[Array[Int]]) : Unit = {
        val layerIndex : Int = 0
        val tileLayer : TileLayer = (lastMap.getLayer(layerIndex).asInstanceOf[TileLayer])
        val mapArray : Array[Array[Int]] = tileLayer.getMapArray()
        val size : Int = mapData.length
        val size2 : Int = mapData(0).length

        {
            var index : Int = 0
            while (index < size) {

                {
                    var index2 : Int = 0
                    while (index2 < size2) {
                        //top 33
                        if (mapArray(index)(index2) == 14) {
                        } else {
                            this.visit2(mapArray, mapData, index, index2)
                        }
                        if ((index % 7) == 0) {
                            if (mapArray(index)(index2) == 19) {
                                val randomInt : Int = this.randomFactory.getAbsoluteNextIntAllowZero(3)
                                if (randomInt == 0) {
                                    mapData(index)(index2) = 1
                                } else if (randomInt == 1) {
                                    mapData(index)(index2) = 81
                                } else if (randomInt == 2) {
                                    mapData(index)(index2) = 97
                                }
                            } else if (mapArray(index)(index2) == 17) {
                                val randomInt : Int = this.randomFactory.getAbsoluteNextIntAllowZero(3)
                                if (randomInt == 0) {
                                    mapData(index)(index2) = 17
                                } else if (randomInt == 1) {
                                    mapData(index)(index2) = 81
                                } else if (randomInt == 2) {
                                    mapData(index)(index2) = 97
                                }
                            }
                        }
                        if ((index2 % 7) == 0) {
                            if (mapArray(index)(index2) == 34) {
                                val randomInt : Int = this.randomFactory.getAbsoluteNextIntAllowZero(4)
                                if (randomInt == 0) {
                                    mapData(index)(index2) = 33
                                } else if (randomInt == 1) {
                                    mapData(index)(index2) = 65
                                } else if (randomInt == 2) {
                                    mapData(index)(index2) = 81
                                } else if (randomInt == 3) {
                                    mapData(index)(index2) = 97
                                }
                            }
                        }
                        index2 += 1
                    }
                }
                index += 1
            }
        }
    }

    def visit2(mapArray : Array[Array[Int]], mapData : Array[Array[Int]], index : Int, index2 : Int) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        var countX : Int = 0
        var countY : Int = 0
        var index3 : Int = index - 1

        {
            var index4 : Int = index2 - 1
            while (index4 > 0) {
                index3 -= 1
                if ((index3 < 0) || (index4 < 0)) {
                    return
                }
                if ((mapArray(index3)(index4) != 14) || (mapData(index3)(index4) != 0)) {
                    if ((countX > 10) && (countY > 10)) {

                        {
                            var index5 : Int = index3 + 1
                            while (index5 < (index - 1)) {

                                {
                                    var index6 : Int = index4 + 1
                                    while (index6 < (index2 - 1)) {
                                        if ((mapArray(index5)(index6) != 14) || (mapData(index5)(index6) != 0)) {
                                            //this.logUtil.putF("Room is already cluttered", this, commonStrings.PROCESS);
                                            return
                                        }
                                        index6 += 1
                                    }
                                }
                                index5 += 1
                            }
                        }
                        //this.logUtil.putF("Found Clearing", this, commonStrings.PROCESS);
                        val x : Int = index - (countX / 2)
                        val y : Int = index2 - (countY / 2)
                        //this.logUtil.putF("x: " + x + " y: " + y, this, commonStrings.PROCESS);
                        if ((((x >= 0) && (y >= 0)) && (x < mapData.length)) && (y < mapData(0).length)) {
                        }
                    }
                    return
                }
                countY += 1
                countX += 1
                index4 -= 1
            }
        }
    }

}


