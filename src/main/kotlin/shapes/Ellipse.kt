package shapes

import kotlin.math.PI

open class Ellipse(
    center: Point,
    private val radiusX: Double,
    private val radiusY: Double
) : Movable {

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

    fun getArea(): Double {
        return PI * radiusX * radiusY
    }

    override fun move(deltaX: Double, deltaY: Double) {
        center.move(deltaX, deltaY)
    }

    private fun validate() {
        if (radiusX <= 0.0) {
            throw IllegalArgumentException("An ellipse must have a positive x-radius.")
        }

        if (radiusY <= 0.0) {
            throw IllegalArgumentException("An ellipse must have a positive y-radius.")
        }
    }
}