package shapes

import kotlin.math.abs

class Triangle(
    point1: Point,
    point2: Point,
    point3: Point
) : Movable, AreaMeasurable {

    private var point1: Point = point1.clone()
    private var point2: Point = point2.clone()
    private var point3: Point = point3.clone()

    init {
        validate()
    }

    fun getPoint1(): Point {
        return point1.clone()
    }

    fun getPoint2(): Point {
        return point2.clone()
    }

    fun getPoint3(): Point {
        return point3.clone()
    }

    override fun getArea(): Double {
        val x1 = point1.getX()
        val y1 = point1.getY()
        val x2 = point2.getX()
        val y2 = point2.getY()
        val x3 = point3.getX()
        val y3 = point3.getY()

        return abs(
            x1 * (y2 - y3) +
                    x2 * (y3 - y1) +
                    x3 * (y1 - y2)
        ) / 2.0
    }

    override fun move(deltaX: Double, deltaY: Double) {
        point1.move(deltaX, deltaY)
        point2.move(deltaX, deltaY)
        point3.move(deltaX, deltaY)
    }

    private fun validate() {
        if (getArea() < EPSILON) {
            throw IllegalArgumentException("A triangle cannot have an area of zero.")
        }
    }

    private companion object {
        const val EPSILON = 0.000001
    }
}