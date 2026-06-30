package shapes

import kotlin.math.abs

open class Rectangle(
    corner1: Point,
    corner2: Point
) : Movable, AreaMeasurable {

    private var corner1: Point = corner1.clone()
    private var corner2: Point = corner2.clone()

    init {
        validate()
    }

    fun getCorner1(): Point {
        return corner1.clone()
    }

    fun getCorner2(): Point {
        return corner2.clone()
    }

    fun getWidth(): Double {
        return abs(corner2.getX() - corner1.getX())
    }

    fun getHeight(): Double {
        return abs(corner2.getY() - corner1.getY())
    }

    override fun getArea(): Double {
        return getWidth() * getHeight()
    }

    override fun move(deltaX: Double, deltaY: Double) {
        corner1.move(deltaX, deltaY)
        corner2.move(deltaX, deltaY)
    }

    private fun validate() {
        if (getWidth() < EPSILON) {
            throw IllegalArgumentException("A rectangle cannot have zero width.")
        }

        if (getHeight() < EPSILON) {
            throw IllegalArgumentException("A rectangle cannot have zero height.")
        }
    }

    private companion object {
        const val EPSILON = 0.000001
    }
}