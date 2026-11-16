/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image.comparison.motion

import _root_.java.awt.*
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.media.image.comparison.ImageComparisonResult
import _root_.org.allbinary.media.image.comparison.pixel.PixelDelta

class AllMotionRectangles(param_imageComparisonResult : ImageComparisonResult) extends MotionRectangles(_root_.org.allbinary.media.image.comparison.motion.AllMotionRectangles.NAME, param_imageComparisonResult) {
    import _root_.org.allbinary.media.image.comparison.motion.AllMotionRectangles.{*}

    //GenerateImageWithBoundingBoxesAroundMovingArtifacts
    //Constructor
    {
        val imageComparisonResult : ImageComparisonResult = param_imageComparisonResult
        this.createMotionRectangles(imageComparisonResult)
    }

    private def createMotionRectangles(imageComparisonInfo : ImageComparisonResult) : Unit = {
        val vector : BasicArrayList = imageComparisonInfo.getNonMatchingPixelVector()
        val size : Int = vector.size()
        /*         if(iterator.hasNext())         {             PixelDelta pixelDelta = (PixelDelta) iterator.next();                       Rectangle newRectangle =                 new Rectangle(pixelDelta.getPoint().x, pixelDelta.getPoint().y, 1, 1);                       MotionRectangle motionRectangle = new MotionRectangle(newRectangle);             motionRectangle.getPixelDeltaVector().add(pixelDelta);                       this.getVector().add(motionRectangle);         }*/

        {
            var index : Int = 0
            while (index < size) {
                var pixelDelta : PixelDelta = vector.get(index).asInstanceOf[PixelDelta]
                this.addPixelDeltaToAMotionRectangle(pixelDelta)
                index += 1
            }
        }
    }

    private def addPixelDeltaToExistingMotionRectangle(pixelDelta : PixelDelta) : Boolean = {
        val vector : BasicArrayList = this.getVector()
        val size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var motionRectangle : MotionRectangle = vector.get(index).asInstanceOf[MotionRectangle]
                //Should this area be added to the rectangle
                if (shouldPixelDeltaPartOfMotionRectangle(motionRectangle, pixelDelta)) {
                    //ModifyRectangle - extend it to the lower and/or right
                    var newWidth : Int = pixelDelta.getPoint().getX() - motionRectangle.getRectangle().x
                    var newHeight : Int = pixelDelta.getPoint().getY() - motionRectangle.getRectangle().y
                    if (newWidth < motionRectangle.getRectangle().width) {
                        newWidth = motionRectangle.getRectangle().width
                    }
                    if (newHeight < motionRectangle.getRectangle().height) {
                        newHeight = motionRectangle.getRectangle().height
                    }
                    motionRectangle.getRectangle().setSize(newWidth, newHeight)
                    /*                 if(pixelDelta.getPoint().x > 560 && pixelDelta.getPoint().y > 330 &&                     pixelDelta.getPoint().x < 600 && pixelDelta.getPoint().y < 365)                     this.logUtil.putF(new StringMaker().append("Adjusted existing motionRectangle: \n" +                         motionRectangle.getRectangle() + " for: " + pixelDelta.getPoint(), this, "addPixelDeltaToExistingMotionRectangle");                                  */
                    return true
                }
                index += 1
            }
        }
        return false
    }

    //Returns a new rectangle or modifies one
    private def addPixelDeltaToAMotionRectangle(pixelDelta : PixelDelta) : Unit = {
        if (!addPixelDeltaToExistingMotionRectangle(pixelDelta)) {
            var newRectangle : Rectangle = new Rectangle(pixelDelta.getPoint().getX(), pixelDelta.getPoint().getY(), 1, 1)
            var motionRectangle : MotionRectangle = new MotionRectangle(newRectangle)
            motionRectangle.getPixelDeltaVector().add(pixelDelta)
            /*             if(pixelDelta.getPoint().x > 560 && pixelDelta.getPoint().y > 330 &&                 pixelDelta.getPoint().x < 600 && pixelDelta.getPoint().y < 365)             {                 StringMaker stringBuffer = new StringMaker();                 iterator = this.getVector();                 while(iterator.hasNext())                 {                     MotionRectangle nextMotionRectangle = (MotionRectangle) iterator.next();                                          if(nextMotionRectangle.getRectangle().x > 560 && nextMotionRectangle.getRectangle().y > 330 &&                         nextMotionRectangle.getRectangle().x < 600 && nextMotionRectangle.getRectangle().y < 365)                     {                         stringBuffer.append(nextMotionRectangle.getRectangle());                         stringBuffer.append(CommonSeps.getInstance().NEW_LINE);                     }                 }                 this.logUtil.putF(new StringMaker().append("Adding motionRectangle: " +                     motionRectangle.getRectangle() + " since it could not be added to: " +                     stringBuffer.toString(), this, "addPixelDeltaToAMotionRectangle");             }             */
            this.getVector().add(motionRectangle)
        }
    }

    private def shouldPixelDeltaPartOfMotionRectangle(motionRectangle : MotionRectangle, pixelDelta : PixelDelta) : Boolean = {
        var isPixelLeftOfTheRectangle : Boolean = false
        if (motionRectangle.getRectangle().y > pixelDelta.getPoint().getY()) {
            throw new Exception("PixelAboveTheRectangle")
        }
        if (motionRectangle.getRectangle().x > pixelDelta.getPoint().getX()) {
            isPixelLeftOfTheRectangle = true
        }
        /*          boolean isPixelInRectangle =             PixelDeltaInRectangleCollisionUtil.isCollision(rectangle, pixelDelta);            if(!isPixelInRectangle)          {          }          else          {             //ignore it is in a rectangle already             break;          }  */
        if (!isPixelLeftOfTheRectangle) {
            //Does PixelDelta seem to be part of rectangle
            return this.isPixelDeltaLikelyPartOfMotionRectangle(motionRectangle, pixelDelta)
        }
        return false
    }

    private def isPixelDeltaLikelyPartOfMotionRectangle(motionRectangle : MotionRectangle, pixelDelta : PixelDelta) : Boolean = {
        /*         BasicArrayList pixelDeltasInTheSameRow = new BasicArrayListD();                   iterator = motionRectangle.getPixelDeltaVector();                   while(iterator.hasNext())         {             PixelDelta pixelDeltaInMotionRectangle =                 (PixelDelta) iterator.next();                       if(pixelDeltaInMotionRectangle.getPoint().getY() ==                pixelDelta.getPoint().getY())             {                pixelDeltasInTheSameRow.add(pixelDeltaInMotionRectangle);             }         }          */
        var maxX : Int = motionRectangle.getRectangle().x + motionRectangle.getRectangle().width
        var maxY : Int = motionRectangle.getRectangle().y + motionRectangle.getRectangle().height
        var horizontalDistance : Int = pixelDelta.getPoint().getX() - maxX
        var verticalDistance : Int = pixelDelta.getPoint().getY() - maxY
        /*         this.logUtil.putF(             "MaxX: " + maxX +             " horizontalDistance: " + horizontalDistance +             " pixelDeltasInTheSameRow.size(): " + pixelDeltasInTheSameRow.size(), this, "isPixelDeltaLikelyPartOfMotionRectangle");          */
        if ((horizontalDistance < this.MAX_PIXEL_DISTANCE_THRESHOLD) && (verticalDistance < this.MAX_PIXEL_DISTANCE_THRESHOLD)) {
            return true
        }
        return false
    }

}

object AllMotionRectangles {
    private val NAME : String = "allMotionRectangles_"

}


