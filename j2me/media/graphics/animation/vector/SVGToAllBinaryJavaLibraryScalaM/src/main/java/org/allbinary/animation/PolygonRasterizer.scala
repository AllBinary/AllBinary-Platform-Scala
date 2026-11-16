/* Generated Code Do Not Modify */
package org.allbinary.animation


class PolygonRasterizer {
    import _root_.org.allbinary.animation.PolygonRasterizer.{*}

    def getPixelBuffer(svgPath : String, pathX : Array[Int], pathY : Array[Int], pixelBuffer : Array[Int], width : Int, height : Int) : Array[Int] = {
        val pointCount : Int = PathParser.parsePath(svgPath, pathX, pathY, pathX.length)

        {
            var i : Int = 0
            while (i < pixelBuffer.length) {
                pixelBuffer(i) = 0xFFFFFFFF
                i += 1
            }
        }
        PolygonRasterizer.getInstance().fillPolygon(pathX, pathY, pointCount, pixelBuffer, width, height, 0xFFFF00FF)
        return pixelBuffer
    }

    def fillPolygon(polyX : Array[Int], polyY : Array[Int], numPoints : Int, buffer : Array[Int], width : Int, height : Int, colorRGB : Int) : Unit = {
        if (numPoints < 3) {
            return
        }
        val fixedPoint : FixedPoint = FixedPoint.getInstance()
        // Convert coordinates from fixed-point back to integers
        var x : Array[Int] = new Array[Int](numPoints)
        var y : Array[Int] = new Array[Int](numPoints)
        var minY : Int = height
        var maxY : Int = 0

        {
            var i : Int = 0
            while (i < numPoints) {
                x(i) = fixedPoint.toInt(polyX(i))
                y(i) = fixedPoint.toInt(polyY(i))
                if (y(i) < minY) {
                    minY = y(i)
                }
                if (y(i) > maxY) {
                    maxY = y(i)
                }
                i += 1
            }
        }
        // Bounds checking against target canvas size
        if (minY < 0) {
            minY = 0
        }
        if (maxY >= height) {
            maxY = height - 1
        }
        // storage for X intersections
        var scanlineX : Array[Int] = new Array[Int](numPoints)
        // Loop through every scanline row

        {
            var scanY : Int = minY
            while (scanY <= maxY) {
                var intersectCount : Int = 0
                // Find intersections with all polygon edges

                {
                    var i : Int = 0
                    while (i < numPoints) {
                        var next : Int = (i + 1) % numPoints
                        var x1 : Int = x(i)
                        var y1 : Int = y(i)
                        var x2 : Int = x(next)
                        var y2 : Int = y(next)
                        if (((y1 < scanY) && (y2 >= scanY)) || ((y2 < scanY) && (y1 >= scanY))) {
                            // Avoid division by zero
                            if (y2 != y1) {
                                var interX : Int = x1 + (((scanY - y1) * (x2 - x1)) / (y2 - y1))
                                scanlineX({ val value_N68295 = intersectCount; intersectCount += 1; value_N68295 }) = interX
                            }
                        }
                        i += 1
                    }
                }
                // Simple bubble sort for the X intersections

                {
                    var i : Int = 0
                    while (i < (intersectCount - 1)) {

                        {
                            var j : Int = i + 1
                            while (j < intersectCount) {
                                if (scanlineX(i) > scanlineX(j)) {
                                    var temp : Int = scanlineX(i)
                                    scanlineX(i) = scanlineX(j)
                                    scanlineX(j) = temp
                                }
                                j += 1
                            }
                        }
                        i += 1
                    }
                }
                // Fill spans between pairs of intersections (Even-Odd Fill)

                {
                    var i : Int = 0
                    scala.util.boundary { (break_N68766 : scala.util.boundary.Label[Unit]) ?=>
                        while (i < intersectCount) {
                            if ((i + 1) >= intersectCount) {
                                scala.util.boundary.break()(using break_N68766)
                            }
                            var startX : Int = scanlineX(i)
                            var endX : Int = scanlineX(i + 1)
                            if (startX < 0) {
                                startX = 0
                            }
                            if (endX >= width) {
                                endX = width - 1
                            }
                            var rowOffset : Int = scanY * width

                            {
                                var pixelX : Int = startX
                                while (pixelX <= endX) {
                                    buffer(rowOffset + pixelX) = colorRGB
                                    pixelX += 1
                                }
                            }
                            i += 2
                        }
                    }
                }
                scanY += 1
            }
        }
    }

    def main(args : Array[String]) : Unit = {
        val width : Int = 100
        val height : Int = 100
        val pathX : Array[Int] = new Array[Int](200)
        val pathY : Array[Int] = new Array[Int](200)
        val pixelBuffer : Array[Int] = new Array[Int](width * height)
        val svgPath : String = "M 32.139812,81.554575 14.450128,74.294372 V 50.000034 25.705697 l 17.73231,-7.268329 C 41.935209,14.439788 49.953112,11.168898 50,11.168723 c 0.04689,-1.74e-4 8.064791,3.270238 17.817562,7.267583 l 17.73231,7.267899 V 50 74.295795 l -17.73231,7.2679 c -9.752771,3.997344 -17.789855,7.264116 -17.860188,7.259492 -0.07033,-0.0046 -8.088235,-3.275499 -17.817562,-7.268612 z"
        PolygonRasterizer.getInstance().getPixelBuffer(svgPath, pathX, pathY, pixelBuffer, width, height)
    }

}

object PolygonRasterizer {
    private val instance : PolygonRasterizer = new PolygonRasterizer()

    /**      * @return the instance      */
    def getInstance() : PolygonRasterizer = {
        return PolygonRasterizer.instance
    }

}


