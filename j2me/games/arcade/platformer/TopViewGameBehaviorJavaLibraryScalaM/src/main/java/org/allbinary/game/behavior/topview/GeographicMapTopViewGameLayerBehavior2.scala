/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.behavior.topview

import _root_.org.allbinary.media.graphics.geography.map.MultiGeographicMapBehavior
import _root_.org.allbinary.game.layer.AllBinaryTiledLayer
import _root_.org.allbinary.game.physics.acceleration.GravityUtil
import _root_.org.allbinary.game.physics.velocity.VelocityProperties
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellPosition
import _root_.org.allbinary.media.graphics.geography.map.GeographicMapCellType
import _root_.org.allbinary.media.graphics.geography.map.SimpleGeographicMapCellPositionFactory

/**  *  * @author User  */
class GeographicMapTopViewGameLayerBehavior2(param_maxGravityActionIndex : Int, param_autoStepBlocks : Boolean, param_offsetY : Int) extends GeographicMapTopViewLayerBehavior(param_maxGravityActionIndex) {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val gravityUtil : GravityUtil = GravityUtil.getInstance()

    private val geographicMapBehavior : MultiGeographicMapBehavior = new MultiGeographicMapBehavior()

    private var autoStepBlocks : Boolean = false

    private var offsetY : Int = 0

    //public GeographicMapCellPosition blockGeographicMapCellPosition;
    private var previousGeographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION

    //    }
    //Constructor
    {
        val maxGravityActionIndex : Int = param_maxGravityActionIndex
        val autoStepBlocks : Boolean = param_autoStepBlocks
        val offsetY : Int = param_offsetY
        this.autoStepBlocks = autoStepBlocks
        this.offsetY = offsetY
    }

    override def gravity(velocityProperties : VelocityProperties, geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], geographicMapCellPosition : GeographicMapCellPosition) : Unit = {
        if (geographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            this.geographicMapBehavior.getCellTypeAt(geographicMapInterfaceArray, geographicMapCellTypeArray, geographicMapCellPosition)
            val hasSolidBlock : Boolean = this.hasSolidBlock(geographicMapInterfaceArray, geographicMapCellTypeArray)
            if (!hasSolidBlock) {
                //this.logUtil.putF(new StringMaker().append("Not on Block: ").append(geographicMapCellPosition).append(" cellType: ").append(cellType).toString(), this, "gravity");
                this.gravityUtil.process(velocityProperties, this.gravityUtil.GAME_GRAVITY_VELOCITY)
                velocityProperties.limitXYToForwardAndReverseMaxVelocity()
                this.gravity()
            } else {
            }
        }
    }

    private def getPositionTopLeft(geographicMapInterfaceArray : Array[BasicGeographicMap], layer : AllBinaryLayer, x : Int, y : Int) : GeographicMapCellPosition = {
        //                .toString(), this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
        val xCellPosition : Int = layer.getXP() + -x
        val yCellPosition : Int = layer.getYP() + -y
        return geographicMapInterfaceArray(0).getCellPositionAtXYNoThrow(xCellPosition, yCellPosition)
    }

    private def getPositionTopRight(geographicMapInterfaceArray : Array[BasicGeographicMap], layer : AllBinaryLayer, x : Int, y : Int) : GeographicMapCellPosition = {
        //                .toString(), this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
        val xCellPosition : Int = (layer.getXP() + -x) + layer.getWidth()
        val yCellPosition : Int = layer.getYP() + -y
        return geographicMapInterfaceArray(0).getCellPositionAtXYNoThrow(xCellPosition, yCellPosition)
    }

    private def getPositionBottomLeft(geographicMapInterfaceArray : Array[BasicGeographicMap], layer : AllBinaryLayer, x : Int, y : Int) : GeographicMapCellPosition = {
        //                .toString(), this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
        val xCellPosition : Int = layer.getXP() + -x
        val yCellPosition : Int = (layer.getYP() + -y) + layer.getHeight()
        return geographicMapInterfaceArray(0).getCellPositionAtXYNoThrow(xCellPosition, yCellPosition)
    }

    private def getPositionBottomRight(geographicMapInterfaceArray : Array[BasicGeographicMap], layer : AllBinaryLayer, x : Int, y : Int) : GeographicMapCellPosition = {
        //                .toString(), this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
        val xCellPosition : Int = (layer.getXP() + -x) + layer.getWidth()
        val yCellPosition : Int = (layer.getYP() + -y) + layer.getHeight()
        return geographicMapInterfaceArray(0).getCellPositionAtXYNoThrow(xCellPosition, yCellPosition)
    }

    private def getLeftPosition(geographicMapInterfaceArray : Array[BasicGeographicMap], layer : AllBinaryLayer) : GeographicMapCellPosition = {
        val xCellPosition : Int = layer.getXP()
        val yCellPosition : Int = layer.getYP() + layer.getHeight()
        return geographicMapInterfaceArray(0).getCellPositionAtXYNoThrow(xCellPosition, yCellPosition)
    }

    private def getRightPosition(geographicMapInterfaceArray : Array[BasicGeographicMap], layer : AllBinaryLayer) : GeographicMapCellPosition = {
        val xCellPosition : Int = layer.getXP() + layer.getWidth()
        val yCellPosition : Int = layer.getYP() + layer.getHeight()
        return geographicMapInterfaceArray(0).getCellPositionAtXYNoThrow(xCellPosition, yCellPosition)
    }

    override def getGeographicMapCellPositionIfNotSolidBlockOrOffMapLocation(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], velocityProperties : VelocityProperties, layer : AllBinaryLayer, x : Int, y : Int) : GeographicMapCellPosition = {
        var geographicMapCellPosition : GeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
        val topLeftGeographicMapCellPosition : GeographicMapCellPosition = this.getPositionTopLeft(geographicMapInterfaceArray, layer, x, y)
        geographicMapCellPosition = this.getGeographicMapCellPositionIfNotSolidBlockOrOffMap(geographicMapInterfaceArray, geographicMapCellTypeArray, topLeftGeographicMapCellPosition, velocityProperties, layer)
        if (geographicMapCellPosition eq SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            //            }
            return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
        }
        val topRightGeographicMapCellPosition : GeographicMapCellPosition = this.getPositionTopRight(geographicMapInterfaceArray, layer, x, y)
        geographicMapCellPosition = this.getGeographicMapCellPositionIfNotSolidBlockOrOffMap(geographicMapInterfaceArray, geographicMapCellTypeArray, topRightGeographicMapCellPosition, velocityProperties, layer)
        if (geographicMapCellPosition eq SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            //            }
            return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
        }
        val bottomLeftGeographicMapCellPosition : GeographicMapCellPosition = this.getPositionBottomLeft(geographicMapInterfaceArray, layer, x, y)
        geographicMapCellPosition = this.getGeographicMapCellPositionIfNotSolidBlockOrOffMap(geographicMapInterfaceArray, geographicMapCellTypeArray, bottomLeftGeographicMapCellPosition, velocityProperties, layer)
        if (geographicMapCellPosition eq SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            //            }
            return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
        }
        val bottomRightGeographicMapCellPosition : GeographicMapCellPosition = this.getPositionBottomRight(geographicMapInterfaceArray, layer, x, y)
        geographicMapCellPosition = this.getGeographicMapCellPositionIfNotSolidBlockOrOffMap(geographicMapInterfaceArray, geographicMapCellTypeArray, bottomRightGeographicMapCellPosition, velocityProperties, layer)
        if (geographicMapCellPosition eq SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
        } else {
        }
        return geographicMapCellPosition
    }

    override def getGeographicMapCellPositionIfNotSolidBlockOrOffMap(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], geographicMapCellPosition : GeographicMapCellPosition, velocityProperties : VelocityProperties, layer : AllBinaryLayer) : GeographicMapCellPosition = {
        //this.previousGeographicMapCellPosition != geographicMapCellPosition && 
        if (geographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            val possibleStepGeographicMapCellPosition : GeographicMapCellPosition = geographicMapCellPosition
            //this.logUtil.putF(possibleStepGeographicMapCellPosition.toString(), this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
            val tiledLayer : AllBinaryTiledLayer = geographicMapInterfaceArray(0).getAllBinaryTiledLayer()
            //this.logUtil.putF(new StringMaker().append("tileLayer: ").append(tiledLayer.getColumns()).append(CommonSeps.getInstance().COLON).append(tiledLayer.getRows()).toString(), this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
            if ((((possibleStepGeographicMapCellPosition.getColumn() > 0) && (possibleStepGeographicMapCellPosition.getRow() > 0)) && (possibleStepGeographicMapCellPosition.getColumn() < tiledLayer.getColumns())) && (possibleStepGeographicMapCellPosition.getRow() < tiledLayer.getRows())) {
                this.geographicMapBehavior.getCellTypeAt(geographicMapInterfaceArray, geographicMapCellTypeArray, possibleStepGeographicMapCellPosition)
                val hasSolidBlock : Boolean = this.hasSolidBlock(geographicMapInterfaceArray, geographicMapCellTypeArray)
                val hasOffMap : Boolean = this.isOffMap(geographicMapInterfaceArray, geographicMapCellTypeArray)
                //|| basicPlatormGeographicMapCellTypeFactory.JUMP_THRU_CELL_TYPE.isType(cellType)
                if (hasSolidBlock || hasOffMap) {
                    //velocityProperties.getVelocityXBasicDecimalP().set(0);
                    this.previousGeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                    return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
                } else {
                    //this.logUtil.putF("cellType: " + cellType, this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
                    this.previousGeographicMapCellPosition = possibleStepGeographicMapCellPosition
                    return possibleStepGeographicMapCellPosition
                }
            }
        } else {
        }
        //this.logUtil.putF("not moving", this, "getGeographicMapCellPositionIfNotSolidBlockOrOffMap");
        this.previousGeographicMapCellPosition = SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
        return SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION
    }

    override def moveAndLand(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], geographicMapCellPosition : GeographicMapCellPosition, velocityProperties : VelocityProperties, layer : AllBinaryLayer, x : Int, y : Int) : Unit = {
        //this.logUtil.putF(new StringMaker().append("x: ").append(x).append(" y: ").append(y).append(CommonSeps.getInstance().SPACE).append(layer.getViewPosition().getXP()).toString(), this, "moveAndLand");
        if (geographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            val topViewCharacterInterface : TopViewCharacterInterface = (layer.asInstanceOf[TopViewCharacterInterface])
            topViewCharacterInterface.terrainMove(geographicMapInterfaceArray, geographicMapCellTypeArray, x, y)
        } else {
        }
    }

    override def move(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], velocityProperties : VelocityProperties, layer : AllBinaryLayer, x : Int, y : Int) : Boolean = {
        val geographicMapCellPosition : GeographicMapCellPosition = this.getGeographicMapCellPositionIfNotSolidBlockOrOffMapLocation(geographicMapInterfaceArray, geographicMapCellTypeArray, velocityProperties, layer, x, y)
        //this.gravity(velocityProperties, geographicMapInterfaceArray, geographicMapCellPosition);
        this.moveAndLand(geographicMapInterfaceArray, geographicMapCellTypeArray, geographicMapCellPosition, velocityProperties, layer, x, y)
        if (geographicMapCellPosition eq SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    override def left(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], velocityProperties : VelocityProperties, layer : AllBinaryLayer) : Unit = {
        val geographicMapCellPosition : GeographicMapCellPosition = this.getLeftPosition(geographicMapInterfaceArray, layer)
        if (geographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            val possibleStepGeographicMapCellPosition : GeographicMapCellPosition = geographicMapInterfaceArray(0).getGeographicMapCellPositionFactory().getAt(geographicMapCellPosition.getColumn(), geographicMapCellPosition.getRow() - 1)
            this.geographicMapBehavior.getCellTypeAt(geographicMapInterfaceArray, geographicMapCellTypeArray, possibleStepGeographicMapCellPosition)
            val hasSolidBlock : Boolean = this.hasSolidBlock(geographicMapInterfaceArray, geographicMapCellTypeArray)
            if (hasSolidBlock) {
                if (this.autoStepBlocks) {
                    val topViewCharacterInterface : TopViewCharacterInterface = (layer.asInstanceOf[TopViewCharacterInterface])
                    topViewCharacterInterface.leftp()
                } else {
                    velocityProperties.getVelocityXBasicDecimalP().setint(0)
                }
            } else {
                val topViewCharacterInterface : TopViewCharacterInterface = (layer.asInstanceOf[TopViewCharacterInterface])
                topViewCharacterInterface.leftp()
            }
        }
    }

    override def right(geographicMapInterfaceArray : Array[BasicGeographicMap], geographicMapCellTypeArray : Array[GeographicMapCellType], velocityProperties : VelocityProperties, layer : AllBinaryLayer) : Unit = {
        val geographicMapCellPosition : GeographicMapCellPosition = this.getRightPosition(geographicMapInterfaceArray, layer)
        if (geographicMapCellPosition ne SimpleGeographicMapCellPositionFactory.NULL_GEOGRAPHIC_MAP_CELL_POSITION) {
            val possibleStepGeographicMapCellPosition : GeographicMapCellPosition = geographicMapInterfaceArray(0).getGeographicMapCellPositionFactory().getAt(geographicMapCellPosition.getColumn(), geographicMapCellPosition.getRow() - 1)
            this.geographicMapBehavior.getCellTypeAt(geographicMapInterfaceArray, geographicMapCellTypeArray, possibleStepGeographicMapCellPosition)
            val hasSolidBlock : Boolean = this.hasSolidBlock(geographicMapInterfaceArray, geographicMapCellTypeArray)
            if (hasSolidBlock) {
                if (this.autoStepBlocks) {
                    val topViewCharacterInterface : TopViewCharacterInterface = (layer.asInstanceOf[TopViewCharacterInterface])
                    topViewCharacterInterface.rightp()
                } else {
                    velocityProperties.getVelocityXBasicDecimalP().setint(0)
                }
            } else {
                val topViewCharacterInterface : TopViewCharacterInterface = (layer.asInstanceOf[TopViewCharacterInterface])
                topViewCharacterInterface.rightp()
            }
        }
    }

}


