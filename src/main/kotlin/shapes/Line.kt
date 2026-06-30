package shapes

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class Line(
    start: Point,
    end: Point
) : Movable {

    private var start: Point = start.clone()
    private var end: Point = end.clone()

    init {
        validate()
    }

    fun getStart(): Point {
        return start.clone()
    }

    fun getEnd(): Point {
        return end.clone()
    }

    /**
     * Returns the slope of the line.
     * Vertical lines have undefined slope, so this method throws an ArithmeticException.
     */
    fun getSlope(): Double {
        val deltaX = end.getX() - start.getX()
        val deltaY = end.getY() - start.getY()

        if (abs(deltaX) < EPSILON) {
            throw ArithmeticException("Vertical lines have undefined slope.")
        }

        return deltaY / deltaX
    }

    fun getLength(): Double {
        val deltaX = end.getX() - start.getX()
        val deltaY = end.getY() - start.getY()

        return sqrt(deltaX.pow(2) + deltaY.pow(2))
    }

    override fun move(deltaX: Double, deltaY: Double) {
        start.move(deltaX, deltaY)
        end.move(deltaX, deltaY)
    }

    private fun validate() {
        if (getLength() < EPSILON) {
            throw IllegalArgumentException("A line cannot have zero length.")
        }
    }

    private companion object {
        const val EPSILON = 0.000001
    }
}