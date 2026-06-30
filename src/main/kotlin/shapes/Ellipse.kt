package shapes

import kotlin.math.PI

open class Ellipse(
    center: Point,
    private val radiusX: Double,
    private val radiusY: Double
) : Movable, AreaMeasurable {

    private var center: Point = center.clone()

    init {
        validate()
    }

    fun getCenter(): Point {
        return center.clone()
    }

    fun getRadiusX(): Double {
        return radiusX
    }

    fun getRadiusY(): Double {
        return radiusY
    }

    override fun getArea(): Double {
        return PI * radiusX * radiusY
    }

    override fun move(deltaX: Double, deltaY: Double) {
        center.move(deltaX, deltaY)
    }

    private fun validate() {
        if (radiusX < EPSILON) {
            throw IllegalArgumentException("An ellipse must have a positive x-radius.")
        }

        if (radiusY < EPSILON) {
            throw IllegalArgumentException("An ellipse must have a positive y-radius.")
        }
    }

    private companion object {
        const val EPSILON = 0.000001
    }
}