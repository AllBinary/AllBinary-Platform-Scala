/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.image.BufferedImage
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author User  */
class SpriteSplitterUtil {
    import _root_.org.allbinary.media.image.SpriteSplitterUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonSeps : CommonSeps = CommonSeps.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    //private final ImageUtil imageUtil = ImageUtil.getInstance();
    val ANIMATIONS_LABELS : Array[String] = Array[String]("Row Total:", "Column Total:", "Column Total:", "Row Total:", "Column Total:", "Row Total:")

    val DIRECTIONAL_ANIMATIONS : String = "Directional DLRU"

    val HORIZONTAL_ANIMATIONS : String = "Horizontal Animations"

    val HORIZONTAL_SPRITE : String = "Horizontal A=R=Y F=C=X"

    //public final String VERTICLE_ANIMATIONS = "Verticle Animations";
    private val ROW_NAME : Array[String] = Array[String]("idle", "walk", "attack", "defeat")

    private val _ROW : String = "_row"

    def process(imageProcessorInput : ImageProcessorInput, totalFrames : Int, totalAnimations : Int, widthReduction : Int, heightReduction : Int, increaseWidth : Int, increaseHeight : Int, spriteType : String, visitor : ImageProcessedVisitor) : Unit = {
        var bufferedImage : BufferedImage = null
        var generatedBufferedImageArray : Array[Array[BufferedImage]] = null
        val bufferedImageArray : Array[BufferedImage] = imageProcessorInput.getBufferedImageArray()

        {
            var index : Int = 0
            while (index < bufferedImageArray.length) {
                bufferedImage = bufferedImageArray(index)
                this.logUtil.putF(spriteType, this, this.commonStrings.RUN)
                if (spriteType eq this.HORIZONTAL_SPRITE) {
                    val cellHeight : Int = bufferedImage.getHeight() / totalAnimations
                    val cellWidth : Int = bufferedImage.getWidth() / totalFrames
                    val columns : Int = totalFrames
                    val rows : Int = totalAnimations
                    generatedBufferedImageArray = Array.ofDim[BufferedImage](rows, columns)
                    this.logUtil.putF((("Processing Individual Cells columns: " + columns) + " rows: ") + rows, this, this.commonStrings.RUN)
                    this.logUtil.putF((("Processing Individual Cells cellHeight: " + cellHeight) + " cellWidth: ") + cellWidth, this, this.commonStrings.RUN)
                    val imageUtil : ImageUtil = ImageUtil.getInstance()
                    var nameEnding : String = null
                    var x : Int = 0
                    var y : Int = 0

                    {
                        var index2 : Int = 0
                        while (index2 < rows) {
                            y = cellHeight * index2

                            {
                                var index3 : Int = 0
                                while (index3 < columns) {
                                    x = cellWidth * index3
                                    generatedBufferedImageArray(index2)(index3) = bufferedImage.getSubimage(x + widthReduction, y + heightReduction, cellWidth - (widthReduction * 2), cellHeight - (heightReduction * 2))
                                    if ((increaseWidth != 0) || (increaseHeight != 0)) {
                                        generatedBufferedImageArray(index2)(index3) = imageUtil.createBufferedImageAllowTranslate(generatedBufferedImageArray(index2)(index3), cellWidth + increaseWidth, cellHeight + increaseHeight, false, true)
                                    }
                                    nameEnding = new StringMaker().appendint(index2).append(this.commonSeps.UNDERSCORE).appendint(index3).toString()
                                    visitor.visit(generatedBufferedImageArray(index2)(index3), nameEnding, index)
                                    index3 += 1
                                }
                            }
                            index2 += 1
                        }
                    }
                    this.logUtil.putF("Processing Rows from Cells", this, this.commonStrings.RUN)
                    val imageUnifierProperties : ImageUnifierProperties = new ImageUnifierProperties()
                    imageUnifierProperties.setRows(Integer.valueOf(1))
                    imageUnifierProperties.setColumns(Integer.valueOf(columns))
                    val imageUnifierCell : ImageUnifierCell = new ImageUnifierCell(Integer.valueOf(cellWidth - (2 * widthReduction)), Integer.valueOf(cellHeight - (2 * heightReduction)))
                    imageUnifierProperties.setImageUnifierCell(imageUnifierCell)

                    {
                        var index2 : Int = 0
                        while (index2 < rows) {
                            y = cellHeight * index2
                            val tempBufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](columns)

                            {
                                var index3 : Int = 0
                                while (index3 < columns) {
                                    //Join columns
                                    tempBufferedImageArray(index3) = generatedBufferedImageArray(index2)(index3)
                                    //generatedBufferedImage = bufferedImage.getSubimage(0, y, bufferedImage.getWidth(), cellHeight);
                                    nameEnding = new StringMaker().appendint(index2).append(this.commonSeps.UNDERSCORE).appendint(1).append(this._ROW).toString()
                                    index3 += 1
                                }
                            }
                            val generatedBufferedImage : BufferedImage = ImageUnifierUtil.getInstance().getImage(tempBufferedImageArray, imageUnifierProperties)
                            visitor.visit(generatedBufferedImage, nameEnding, index)
                            index2 += 1
                        }
                    }
                } else if (spriteType eq HORIZONTAL_ANIMATIONS) {
                } else if (spriteType eq this.DIRECTIONAL_ANIMATIONS) {
                    val totalFrames2 : Int = 4
                    val cellHeight : Int = bufferedImage.getHeight() / totalFrames2
                    val cellWidth : Int = bufferedImage.getWidth() / totalAnimations
                    val columns : Int = totalAnimations
                    val rows : Int = totalFrames2
                    generatedBufferedImageArray = Array.ofDim[BufferedImage](rows, columns)
                    this.logUtil.putF("Processing Individual Cells for each Direction", this, this.commonStrings.RUN)
                    var nameEnding : String = null
                    var x : Int = 0
                    var y : Int = 0

                    {
                        var index2 : Int = 0
                        while (index2 < rows) {
                            y = cellHeight * index2

                            {
                                var index3 : Int = 0
                                while (index3 < columns) {
                                    x = cellWidth * index3
                                    generatedBufferedImageArray(index2)(index3) = bufferedImage.getSubimage(x + widthReduction, y + heightReduction, cellWidth - (widthReduction * 2), cellHeight - (heightReduction * 2))
                                    if ((increaseWidth != 0) || (increaseHeight != 0)) {
                                        generatedBufferedImageArray(index2)(index3) = ImageUtil.getInstance().createBufferedImageAllowTranslate(generatedBufferedImageArray(index2)(index3), cellWidth + increaseWidth, cellHeight + increaseHeight, false, true)
                                    }
                                    nameEnding = new StringMaker().append(this.commonStrings.DIRECTION_NAME(index2)).append(this.commonSeps.UNDERSCORE).appendint(index3).toString()
                                    visitor.visit(generatedBufferedImageArray(index2)(index3), nameEnding, index)
                                    index3 += 1
                                }
                            }
                            index2 += 1
                        }
                    }
                    val imageUnifierProperties : ImageUnifierProperties = new ImageUnifierProperties()
                    imageUnifierProperties.setRows(Integer.valueOf(1))
                    imageUnifierProperties.setColumns(Integer.valueOf(columns))
                    val imageUnifierCell : ImageUnifierCell = new ImageUnifierCell(Integer.valueOf(cellWidth - (2 * widthReduction)) + increaseWidth, Integer.valueOf((cellHeight - (2 * heightReduction)) + increaseHeight))
                    imageUnifierProperties.setImageUnifierCell(imageUnifierCell)
                    this.logUtil.putF("Processing Rows from Cells for each Direction", this, this.commonStrings.RUN)

                    {
                        var index2 : Int = 0
                        while (index2 < rows) {
                            y = cellHeight * index2
                            val tempBufferedImageArray : Array[BufferedImage] = new Array[BufferedImage](columns)

                            {
                                var index3 : Int = 0
                                while (index3 < columns) {
                                    //Join columns
                                    tempBufferedImageArray(index3) = generatedBufferedImageArray(index2)(index3)
                                    //generatedBufferedImage = bufferedImage.getSubimage(0, y, bufferedImage.getWidth(), cellHeight);
                                    nameEnding = new StringMaker().append(this.commonStrings.DIRECTION_NAME(index2)).append(this.commonSeps.UNDERSCORE).appendint(1).append(this._ROW).toString()
                                    index3 += 1
                                }
                            }
                            val generatedBufferedImage : BufferedImage = ImageUnifierUtil.getInstance().getImage(tempBufferedImageArray, imageUnifierProperties)
                            visitor.visit(generatedBufferedImage, nameEnding, index)
                            index2 += 1
                        }
                    }
                }
                index += 1
            }
        }
    }

}

object SpriteSplitterUtil {
    private val instance : SpriteSplitterUtil = new SpriteSplitterUtil()

    /**      * @return the instance      */
    def getInstance() : SpriteSplitterUtil = {
        return SpriteSplitterUtil.instance
    }

}


