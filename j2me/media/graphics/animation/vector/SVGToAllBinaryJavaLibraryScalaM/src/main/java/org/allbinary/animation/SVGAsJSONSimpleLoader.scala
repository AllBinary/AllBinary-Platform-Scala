/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.graphics.GraphicsStrings
import _root_.org.allbinary.logic.math.PrimitiveIntUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.math.PositionStrings
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.json.me.JSONArray
import _root_.org.json.me.JSONException
import _root_.org.json.me.JSONObject

class SVGAsJSONSimpleLoader {
    import _root_.org.allbinary.animation.SVGAsJSONSimpleLoader.{*}

    private val graphicsStrings : GraphicsStrings = GraphicsStrings.getInstance()

    private val shapeTypeFactory : ShapeTypeFactory = ShapeTypeFactory.getInstance()

    private val KEY_SVG : String = "svg"

    private val KEY_X1 : String = "x1"

    private val KEY_Y1 : String = "y1"

    private val KEY_X2 : String = "x2"

    private val KEY_Y2 : String = "y2"

    private val KEY_CX : String = "cx"

    private val KEY_CY : String = "cy"

    private val KEY_R : String = "r"

    private val KEY_X : String = PositionStrings.getInstance().X

    private val KEY_Y : String = PositionStrings.getInstance().Y

    private val ERROR_PARSE_SVG_JSON : String = "Unable to parse SVG JSON"

    private val ERROR_MISSING_KEY_PREFIX : String = "Missing key: "

    private val ERROR_INVALID_NUMBER_PREFIX : String = "Invalid number for key: "

    private val ERROR_EXPECTED_OBJECT_PREFIX : String = "Expected object for: "

    private val EMPTY_POINTS : Array[Array[Int]] = PrimitiveIntUtil.getTwoDimensionalArrayInstance()

    private val SHAPE_SEPARATOR : Array[Int] = Array[Int](1000, 1000)

    private val CIRCLE_SEGMENTS : Int = 16

    def load(svgAsJson : String) : Array[Array[Int]] = {
        if (svgAsJson == null) {
            return EMPTY_POINTS
        }
        try {
            val root : JSONObject = new JSONObject(svgAsJson)
            val svgValue : Object = root.opt(KEY_SVG)
            val svg : JSONObject = (if (svgValue == null) root else this.asObject(svgValue, KEY_SVG))
            val pointVector : BasicArrayList = new BasicArrayListD()
            val objectArray : Array[Object] = svg.keysAsArray()
            val size : Int = objectArray.length

            {
                var index : Int = 0
                while (index < size) {
                    val key : String = objectArray(index).asInstanceOf[String]
                    val value : Object = svg.opt(key)
                    if (this.shapeTypeFactory.KEY_LINE.equals(key)) {
                        this.addShapes(pointVector, value, this.shapeTypeFactory.LINE)
                    } else if (this.shapeTypeFactory.equals(key)) {
                        this.addShapes(pointVector, value, this.shapeTypeFactory.CIRCLE)
                    } else if (this.shapeTypeFactory.KEY_RECT.equals(key) || this.shapeTypeFactory.KEY_RECTANGLE.equals(key)) {
                        this.addShapes(pointVector, value, this.shapeTypeFactory.RECTANGLE)
                    }
                    index += 1
                }
            }
            return this.toPoints(pointVector)
        } catch {
            case e : JSONException => {
                throw new IllegalArgumentException(ERROR_PARSE_SVG_JSON, e)
            }
        }
        throw new IllegalStateException()
    }

    private def addShapes(pointVector : BasicArrayList, value : Object, shapeType : ShapeType) : Unit = {
        if (value.isInstanceOf[JSONArray]) {
            val array : JSONArray = value.asInstanceOf[JSONArray]
            val size : Int = array.length()

            {
                var index : Int = 0
                while (index < size) {
                    this.addShape(pointVector, array.opt(index), shapeType)
                    index += 1
                }
            }
        } else {
            this.addShape(pointVector, value, shapeType)
        }
    }

    private def addShape(pointVector : BasicArrayList, value : Object, shapeType : ShapeType) : Unit = {
        val shape : JSONObject = this.asObject(value, shapeType.getName())
        if (shapeType eq this.shapeTypeFactory.LINE) {
            this.addLine(pointVector, shape)
        } else if (shapeType eq this.shapeTypeFactory.CIRCLE) {
            this.addCircle(pointVector, shape)
        } else {
            this.addRectangle(pointVector, shape)
        }
    }

    private def addLine(pointVector : BasicArrayList, line : JSONObject) : Unit = {
        this.addPoint(pointVector, this.readInt(line, KEY_X1), this.readInt(line, KEY_Y1))
        this.addPoint(pointVector, this.readInt(line, KEY_X2), this.readInt(line, KEY_Y2))
        this.addSeparator(pointVector)
    }

    private def addCircle(pointVector : BasicArrayList, circle : JSONObject) : Unit = {
        val cx : Int = this.readInt(circle, KEY_CX)
        val cy : Int = this.readInt(circle, KEY_CY)
        val radius : Int = this.readInt(circle, KEY_R)

        {
            var index : Int = 0
            while (index <= CIRCLE_SEGMENTS) {
                val angle : Double = ((Math.PI * 2.0d) * index) / CIRCLE_SEGMENTS
                val x : Int = Math.round(cx + (Math.cos(angle) * radius)).toInt
                val y : Int = Math.round(cy + (Math.sin(angle) * radius)).toInt
                this.addPoint(pointVector, x, y)
                index += 1
            }
        }
        this.addSeparator(pointVector)
    }

    private def addRectangle(pointVector : BasicArrayList, rectangle : JSONObject) : Unit = {
        val x : Int = this.readInt(rectangle, KEY_X, 0)
        val y : Int = this.readInt(rectangle, KEY_Y, 0)
        val width : Int = this.readInt(rectangle, graphicsStrings.WIDTH)
        val height : Int = this.readInt(rectangle, graphicsStrings.HEIGHT)
        this.addPoint(pointVector, x, y)
        this.addPoint(pointVector, x + width, y)
        this.addPoint(pointVector, x + width, y + height)
        this.addPoint(pointVector, x, y + height)
        this.addPoint(pointVector, x, y)
        this.addSeparator(pointVector)
    }

    private def addPoint(pointVector : BasicArrayList, x : Int, y : Int) : Unit = {
        pointVector.add(Array[Int](x, y))
    }

    private def addSeparator(pointVector : BasicArrayList) : Unit = {
        pointVector.add(Array[Int](SHAPE_SEPARATOR(0), SHAPE_SEPARATOR(1)))
    }

    private def readInt(anyType : JSONObject, key : String) : Int = {
        val value : Object = anyType.get(key)
        if (value == null) {
            throw new IllegalArgumentException(ERROR_MISSING_KEY_PREFIX + key)
        }
        return this.toInt(value, key)
    }

    private def readInt(anyType : JSONObject, key : String, defaultValue : Int) : Int = {
        try {
            if (anyType.has(key)) {
                val value : Object = anyType.get(key)
                return this.toInt(value, key)
            }
        } catch {
            case e : Exception => {
                e.printStackTrace()
            }
        }
        return defaultValue
    }

    private def toInt(value : Object, key : String) : Int = {
        if (value.isInstanceOf[Number]) {
            return Math.round((value.asInstanceOf[Number]).doubleValue()).toInt
        }
        if (value.isInstanceOf[String]) {
            return Math.round(_root_.java.lang.Double.parseDouble(value.asInstanceOf[String])).toInt
        }
        throw new IllegalArgumentException(ERROR_INVALID_NUMBER_PREFIX + key)
    }

    private def asObject(value : Object, name : String) : JSONObject = {
        if (value.isInstanceOf[JSONObject]) {
            return value.asInstanceOf[JSONObject]
        }
        throw new IllegalArgumentException(ERROR_EXPECTED_OBJECT_PREFIX + name)
    }

    private def toPoints(pointVector : BasicArrayList) : Array[Array[Int]] = {
        if (pointVector.size() == 0) {
            return EMPTY_POINTS
        }
        val points : Array[Array[Int]] = Array.ofDim[Int](pointVector.size(), 2)

        {
            var index : Int = 0
            while (index < pointVector.size()) {
                val point : Array[Int] = pointVector.get(index).asInstanceOf[Array[Int]]
                points(index) = point
                index += 1
            }
        }
        return points
    }

}

object SVGAsJSONSimpleLoader {
    private val instance : SVGAsJSONSimpleLoader = new SVGAsJSONSimpleLoader()

    /**      * @return the instance      */
    def getInstance() : SVGAsJSONSimpleLoader = {
        return SVGAsJSONSimpleLoader.instance
    }

    def main(args : Array[String]) : Unit = {
        val svgAsJson : String = (((((((("{\"svg\": {\n" + "    \"rect\": {\n") + "        \"width\": 20,\n") + "        \"fill\": \"#008c00\",\n") + "        \"height\": 20\n") + "    },\n") + "    \"xmlns\": \"http://www.w3.org/2000/svg\",\n") + "    \"width\": 20,\n") + "    \"height\": 20\n") + "}}\n"
        //"}}\n";
        val points : Array[Array[Int]] = SVGAsJSONSimpleLoader.getInstance().load(svgAsJson)
        val stringBuilder : StringMaker = new StringMaker()
        val size : Int = points.length

        {
            var index : Int = 0
            while (index < size) {
                val size2 : Int = points(index).length

                {
                    var index2 : Int = 0
                    while (index2 < size2) {
                        stringBuilder.appendint(points(index)(index2))
                        stringBuilder.append(CommonSeps.getInstance().COMMA)
                        index2 += 1
                    }
                }
                index += 1
            }
        }
        System.out.println(stringBuilder.toString())
    }

}


